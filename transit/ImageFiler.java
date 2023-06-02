import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.IntStream;

/**
 * @version 2023-06-01
 */
public record ImageFiler(String filenameFormat, ColorMap colorMap) {
    private final static Path imageDir = Path.of(System.getProperty("java.io.tmpdir"));

    public void save(int index,  int[][] loops) throws IOException {
        int height = loops[0].length;
        int width = loops.length;
        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        IntStream.range(0, width)
                .forEach(x -> IntStream.range(0, height)
                        .forEach(y -> image.setRGB(x, y, colorMap.map(loops[x][y]))));
        ImageIO.write(image, "png", imageDir.resolve(filenameFormat.formatted(index)).toFile());
   }
}
