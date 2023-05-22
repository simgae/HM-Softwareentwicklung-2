package edu.hm.cs.rs.se.ss23.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Aufruf der Werkzeuge, alle nacheinander.
 * @author Reinhard Schiedermeier, rs@cs.hm.edu
 * @version 2023-05-03
 */
@SuppressWarnings({"PMD.NPathComplexity", // bug im PMD 6.55 => Integer.MAX_VALUE
        "checkstyle:DescendantToken"}) // Pfade unabhaengig, kein Zusammenfassen moeglich
public abstract class BaseToolRunner {
    /** {@return Pfad zum Sourcecode, wo src und test liegen.} */
    public String projectDir() {
        throw new UnsupportedOperationException();
    }

    /** {@return Pfad zu den ausgepackten Tools.} */
    public String toolBundleDir() {
        throw new UnsupportedOperationException();
    }

    /** {@return Installationspfad des JDK.} */
    public String jdkDir() {
        return System.getProperty("java.home");
    }

    /** {@return Abbildung von einzelnen Schluesseln auf Pfade.} *
     */
    public Map<String, Path> mapPaths() {
        return """
               src={project}src                 # Produktionscode in der IDE
               test={project}test               # Tests
               junit={bundle}junit-platform-console-standalone.jar # JUnit-4
               pmd={bundle}pmd-bin              # Ausgepacktes PMD-Zip
               pmdxml={bundle}pmd.xml           # Configfile fuer PMD
               checkstyle={bundle}checkstyle.jar  # Checkstyle-Jar
               checkstylexml={bundle}checkstyle.xml # Configfile fuer Checkstyle
               spotbugs={bundle}spotbugs        # Ausgepacktes Spotbugs
               spotbugsxml={bundle}spotbugs.xml # Ausnahmen fuer Spotbugs
               ccnscanner={bundle}ccnscanner.jar    # CCN-Scanner
               jacoco={bundle}jacoco            # Agent und Jarfile von Jacoco
               pitest={bundle}pitest            # Jarfiles von PiTest
               report={project}report           # Ausgabedir fuer Logfiles
               out={project}out                 # Ausgabedir fuer Classfiles"""
                .replace("{project}", ensureTrailingSeparator(projectDir()))
                .replace("{bundle}", ensureTrailingSeparator(toolBundleDir()))
                .lines()
                .filter(Predicate.not(String::isBlank))
                .map(line -> line.split("[=#]"))
                .collect(Collectors.toMap(pair -> pair[0],
                                          pair -> Path.of(pair[1].trim())));
    }

    private String ensureTrailingSeparator(String dirname) {
        return dirname.endsWith(File.separator)?
                dirname:
                dirname + File.separatorChar;
    }

    /** Abbildung von Schluesseln auf einzelne Pfadnamen. */
    private Map<String, Path> paths = mapPaths();

    /** Directory mit dem Quelltext des Produktionscodes. */
    private final Path src = paths.get("src");

    /** Directory mit dem Quelltext der Tests. */
    private final Path test = paths.get("test");

    /** Wo JUnit-4 ist. */
    private final Path junit = paths.get("junit");

    /** Installationsdirectory von PMD. */
    private final Path pmd = paths.get("pmd");

    /** Configfile von PMD. */
    private final Path pmdxml = firstOf(src.resolve("pmd.xml"), paths.get("pmdxml"));

    /** Installationsdirectory von Checkstyle. */
    private final Path checkstyle = paths.get("checkstyle");

    /** Configfile von Checkstyle. */
    private final Path checkstylexml = firstOf(src.resolve("checkstyle.xml"), paths.get("checkstylexml"));

    /** Installationsdirectory von Spotbugs. */
    private final Path spotbugs = paths.get("spotbugs");

    /** Configfile von Spotbugs. */
    private final Path spotbugsxml = firstOf(src.resolve("spotbugs.xml"), paths.get("spotbugsxml"));

    /** Installationsdirectory des CCN-Scanners. */
    private final Path ccnscanner = paths.get("ccnscanner");

    /** Installationsdirectory von Jacoco. */
    private final Path jacoco = paths.get("jacoco");

    /** Installationsdirectory von PiTest. */
    private final Path pitest = paths.get("pitest");

    /** Ausgabe-Directory fuer Logfiles. */
    private final Path reports = paths.get("report");

    /** Dir mit allen Classfiles. */
    private final Path bin = paths.get("out");

    /** Pfadname des Analysefiles von Jacoco. */
    private final Path jacocoStat = bin.resolve("jacoco.exec");

    /** Major-Version der laufenden Runtime. */
    private final int javaVersion = Integer.parseInt(System.getProperty("java.version").split("\\D")[0]);

    /** Trennzeile fuer die Ausgabe. */
    private final String splitter = "-".repeat(80);

    /** Dir fuer alle Protokolle. */
    private Path report;

    /** Logfile mit allen Kommandos und Ausgaben. */
    private Path log;

    /** Protokoll der ausgefuehrten Kommandos. */
    private Path commandLog;

    /** Hauptprogramm.
     * Startet nacheinander verschiedene Werkzeuge.
     * @param args Kommandozeileargumente: Name eines Package, dessen Inhalt die Werkzeuge verarbeiten.
     * @throws IOException wenn ein Werkzeug scheitert.
     */
    public void runAll(String subPkg) throws IOException {
        if(subPkg.isEmpty())
            throw new IllegalArgumentException("package substring required");
        final String subPath = subPkg.replace('.', File.separatorChar);

        report = reports.resolve(subPath);
        log = report.resolve("all.log");
        commandLog = report.resolve("command.log");

        recursiveDelete(bin);
        recursiveDelete(report);
        Files.createDirectories(bin);
        Files.createDirectories(report);
        Files.createDirectories(report.resolve("jacoco"));

        run("javac", "javac",
            "-cp", bin,
            "-encoding", "US-ASCII",
            "--enable-preview", "--release", javaVersion,
            "-d", bin,
            "--source-path", src,
            findFiles(src, subPath, "!Demo", "java")).forEach(System.out::println);
        run("javac-tests", "javac",
            "-cp", pathCat(junit, bin),
            "-encoding", "US-ASCII",
            "--enable-preview", "--release", javaVersion,
            "-d", bin,
            "--source-path", pathCat(test, src),
            findFiles(test, subPath, "java")).forEach(System.out::println);
        run("javadoc", "javadoc",
            "-cp", pathCat(junit, bin),
            "-encoding", "US-ASCII",
            "--enable-preview", "--release", javaVersion,
            "-d", report.resolve("javadoc"),
            "-private",
            "-quiet",
            "-Xdoclint:-missing",
            "--source-path", test,
            findFiles(src, subPath, "!Test", "!Demo", "java")).forEach(System.out::println);
        run("pmd", "java",
            "-cp", collectJars(pmd.resolve("lib")),
            "net.sourceforge.pmd.PMD",
            "--encoding", "US-ASCII",
            // "--use-version", "java-" + javaVersion + "-preview",
            "-d", findDirs(src, subPath),
            "-f", "text",
            "-R", pmdxml,
            "--no-cache",
            "--relativize-paths-with", src).forEach(System.out::println);
        run("checkstyle", "java",
            "-cp", pathCat(checkstyle, bin),
            "com.puppycrawl.tools.checkstyle.Main",
            "-c", checkstylexml,
            findFiles(src, subPath, "!Test", "!Demo", "java")).forEach(System.out::println);
        run("spotbugs", "java",
            "-client", "-Xmx512m",
            "-cp", collectJars(spotbugs.resolve("lib")),
            "-Dspotbugs.home=" + spotbugs,
            "edu.umd.cs.findbugs.FindBugs2",
            "-effort:max",
            "-low",
            "-emacs",
            "-exclude", spotbugsxml,
            "-sourcepath", findDirs(src, subPath),
            findFiles(bin, subPath, "!Demo", "!Test", "class")).forEach(System.out::println);
        run("ccnscanner", "java",
            "-cp", collectJars(pmd.resolve("lib")) + File.pathSeparator + ccnscanner,
            "CCNScanner",
            findDirs(src, subPath)).forEach(System.out::println);
        run("junit", "java",
            "-cp", pathCat(junit, bin),
            "org.junit.runner.JUnitCore",
            findFQCNs(bin, subPkg, "Test")).forEach(System.out::println);
        run("jacoco-agent", "java",
            "-cp", pathCat(junit, bin),
            "-javaagent:"
                    + jacoco.resolve("lib").resolve("jacocoagent.jar")
                    + "=append=false"
                    + ",destfile=" + jacocoStat
                    + ",excludes=*Test:*Demo",
            "org.junit.runner.JUnitCore",
            findFQCNs(bin, subPkg, "Test")).forEach(System.out::println);
        run("jacoco", "java",
            "-jar", jacoco.resolve("lib").resolve("jacococli.jar"),
            "report", jacocoStat,
            "--sourcefiles", src,
            findFiles(bin, subPath, "!Demo", "!Test", "class")
                    .flatMap(classfile -> Stream.of("--classfiles", classfile)),
            "--html", report.resolve("jacoco"),
            "--xml", report.resolve("jacoco").resolve("jacoco.xml"),
            "--csv", report.resolve("jacoco").resolve("jacoco.csv")).forEach(System.out::println);
        run("pitest", "java",
            "-cp", pathCat(bin, junit) + File.pathSeparator + collectJars(pitest),
            "org.pitest.mutationtest.commandline.MutationCoverageReport",
            "--outputFormats", "HTML,XML",
            "--mutators", "STRONGER",
            "--jvmArgs", "--enable-preview",
            "--excludedMethods", "hashCode,equals,toString",
            "--excludedClasses", "*Test,*Demo",
            "--reportDir", report.resolve("pitest"),
            "--threads", Runtime.getRuntime().availableProcessors(),
            "--timestampedReports=false",
            "--targetClasses", findFQCNs(bin, subPkg, "!Test").collect(Collectors.joining(",")),
            "--targetTests", findFQCNs(bin, subPkg, "Test").collect(Collectors.joining(",")),
            "--sourceDirs", src).forEach(System.out::println);

        System.out.println(log);
    }

    /**
     * Startet ein anderes Programm und liefert dessen Konsolenausgabe (out und err) zurueck.
     * @param parts Programmname und Kommandozeilenargumente.
     * @return Ausgabe des Programms.
     * @exception IOException bei einem Fehler im Filesystem.
     * @exception InterruptedException bei einer Unterbrechung des Prozesses.
     */
    private List<String> run(String name, Object... parts) throws IOException {
        final List<String> wordList = new ArrayList<>();
        for(Object part : parts)
            switch(part) {
                case String string -> wordList.add(string);
                case Stream<?> stream -> wordList.addAll(stream.map(word -> (String)word).toList());
                case String[] strings -> wordList.addAll(Arrays.asList(strings));
                case Path path -> wordList.add(path.toString());
                case Integer number -> wordList.add(Integer.toString(number));
                default -> throw new AssertionError();
            }
        System.out.println(splitter);
        System.out.println(String.join(" ", wordList));
        Files.writeString(log, splitter + "\n[" + name + "]\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        Files.write(log, List.of(String.join(" ", wordList)), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        Files.write(commandLog, List.of(String.join(" ", wordList.stream().map(BaseToolRunner::doubleQuote).toList())), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        final ProcessBuilder builder = new ProcessBuilder(wordList)
                .redirectErrorStream(true)
                .directory(new File(System.getProperty("java.io.tmpdir")));
        builder.environment().put("JAVA_HOME", jdkDir());
        builder.environment().put("PATH", Path.of(jdkDir()).resolve("bin").toString());
        final Process process = builder.start();
        final List<String> output = new ArrayList<>();
        try(InputStream inputStream = process.getInputStream();
            Reader reader = new InputStreamReader(inputStream, Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(reader)) {
            final Thread collector = new Thread(() -> bufferedReader.lines().forEach(output::add));
            collector.start();
            if(process.waitFor() != 0)
                throw new IOException("process failed: " + wordList.toString().replace(", ", " "));
            collector.join();
        } catch(InterruptedException exception) {
            throw new IOException(exception);
        } catch(IOException ioException) {
            output.add("* FAILED *");
        } finally {
            Files.write(report.resolve(name + ".log"), output);
            Files.write(log, output, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        return output;
    }

    private static String doubleQuote(String word) {
        return word.contains("*") || word.contains(" ")? '\"' + word + '\"': word;
    }

    /** {@return Files unter einem Directory mit bestimmten Pfadnamen.}
     * @param dir Startdirectory.
     * @param subs Substrings, die alle im Pfadnamen vorkommen muessen.
     *             Strings, die mit ! beginnen, muessen fehlen.
     */
    private Stream<String> findFiles(Path dir, String... subs) throws IOException {
        final int baseLength = dir.toString().length();
        return Files.walk(dir)
                .filter(Files::isRegularFile)
                .filter(Files::isReadable)
                .map(Path::toString)
                .filter(file -> Stream.of(subs)
                        .filter(sub -> sub.startsWith("!"))
                        .map(sub -> sub.substring(1))
                        .noneMatch(file.substring(baseLength)::contains))
                .filter(file -> Stream.of(subs)
                        .filter(Predicate.not(String::isEmpty))
                        .filter(Predicate.not(sub -> sub.startsWith("!")))
                        .allMatch(file.substring(baseLength)::contains));
    }

    private String pathCat(Path... paths) {
        return Stream.of(paths).map(Path::toString).collect(Collectors.joining(File.pathSeparator));
    }

    private String collectJars(Path dir) throws IOException {
        return Files.list(dir).map(Path::toString)
                .filter(file -> file.endsWith(".jar"))
                .collect(Collectors.joining(File.pathSeparator));
    }

    private Stream<String> findDirs(Path dir, String... subs) throws IOException {
        final int baseLength = dir.toString().length();
        return Files.walk(dir)
                .filter(Files::isDirectory)
                .map(Path::toString)
                .filter(file -> Stream.of(subs)
                        .filter(Predicate.not(String::isEmpty))
                        .allMatch(file.substring(baseLength)::contains))
                .filter(Predicate.not(adir -> adir.contains(Path.of("edu", "hm", "cs", "rs").toString())));
    }

    private Stream<String> findFQCNs(Path dir, String... subs) throws IOException {
        return Files.walk(dir)
                .filter(Files::isRegularFile)
                .filter(Files::isReadable)
                .map(dir::relativize)
                .map(Path::toString)
                .filter(filename -> filename.endsWith(".class"))
                .map(filename -> filename.replace(".class", ""))
                .map(filename -> filename.replace(File.separator, "."))
                .filter(file -> Stream.of(subs)
                        .filter(sub -> sub.startsWith("!"))
                        .map(sub -> sub.substring(1))
                        .noneMatch(file::contains))
                .filter(file -> Stream.of(subs)
                        .map(sub -> sub.replace(File.separator, "."))
                        .filter(Predicate.not(String::isEmpty))
                        .filter(Predicate.not(sub -> sub.startsWith("!")))
                        .allMatch(file::contains));
    }

    private Path firstOf(Path... paths) {
        return Stream.of(paths).filter(Files::exists).findFirst().orElse(null);
    }

    /** Loescht ein Directory rekursiv (mit dem ganzen Inhalt).
     * @param root Directory.
     * @throws IOException wenn die Methode das Dir nicht loeschen kann.
     */
    private void recursiveDelete(Path root) throws IOException {
        if(Files.exists(root))
            Files.walkFileTree(root, new FileVisitor<>() {
                @Override public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) {
                    return FileVisitResult.CONTINUE;
                }

                @Override public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                    Files.delete(path);
                    return FileVisitResult.CONTINUE;
                }

                @Override public FileVisitResult visitFileFailed(Path path, IOException e) throws IOException {
                    throw e;
                }

                @Override public FileVisitResult postVisitDirectory(Path path, IOException e) throws IOException {
                    return visitFile(path, null);
                }
            });
        Files.deleteIfExists(root);
    }

}
