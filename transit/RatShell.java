/** Vorgabe zur Aufgabe a13.
 * Rechner fuer Brueche.
 * @version 2023-03-22
 * @param inout Liefert Eingaben und akzeptiert Ausgaben.
 */
public record RatShell(IO inout) {
    /** Wie viele offene Operatoren der Rechner zulaesst. */
    public static final int STACK_SIZE = 8;

    /** Hauptprogramm.
     * Fuert den Dialog ueber das Terminal.
     * @param args Kommandozeilenargumente: keine.
     */
    public static void main(String... args) {
        new RatShell(new SystemIO()).dialogLoop();
    }

    /** Dialogschleife.
     * Gibt fortlaufend den Stack der Brueche aus, liest ein Kommando und wendet es an.
     */
    @SuppressWarnings({"PMD.CyclomaticComplexity",
            "checkstyle:CyclomaticComplexity",
            "checkstyle:InnerAssignment"})
    public void dialogLoop() {
        // Operandenstack
        final Rational[] stack = new Rational[STACK_SIZE];
        int depth = 0;

        // Gemerkter Bruch oder null = noch keiner
        Rational memory = null;

        // Flag: weitermachen oder aufhoeren?
        boolean loop = true;
        while(loop) {
            // aktuellen Stack ausgeben
            for(int stackIndex = 0; stackIndex < depth; stackIndex++)
                inout().write("[%d] %s".formatted(stackIndex, stack[stackIndex].asText()));

            // TODO - Bei Problemen hier die Fehlermeldung ausgeben

            // Kommando lesen
            final String input = inout().read("> ");

            // Kommando ausfuehren
            switch(input) {
                case "+", "-", "*", "/" -> {
                    final Rational operandLeft = stack[depth - 1];
                    final Rational operandRight = stack[depth - 2];
                    final Rational result = switch(input.charAt(0)) {
                        case '+' -> operandRight.add(operandLeft);
                        case '-' -> operandRight.sub(operandLeft);
                        case '*' -> operandRight.mult(operandLeft);
                        case '/' -> operandRight.div(operandLeft);
                        default -> throw new AssertionError("cannot happen");
                    };
                    stack[depth - 2] = result;
                    depth--;
                }
                case "\\" -> stack[depth - 1] = stack[depth - 1].invert();
                case "#" -> stack[depth - 1] = stack[depth - 1].mult(new Rational(-1, 1));
                case "m" -> memory = stack[depth - 1];
                case "r" -> stack[depth++] = memory;
                case "x" -> loop = false;
                default -> {
                    final int colonAt = input.indexOf(':');
                    stack[depth++] = colonAt < 0?
                            new Rational(Integer.parseInt(input), 1):
                            new Rational(Integer.parseInt(input.substring(0, colonAt)),
                                         Integer.parseInt(input.substring(colonAt + 1)));
                }
            }
        }
    }
}
