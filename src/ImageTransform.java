import java.util.Scanner;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Image.PixelFormat;

public class ImageTransform {

    public static Image lighten(Image srcImage) {

        float[] pixels = srcImage.toFloatArray(PixelFormat.RGB);
        for (int i = 0; i < pixels.length; i++){ //c style loop (sets index to 0, advances through the array until it reaches the length of the array)
            pixels[i] *= 1.5;

        }

        return new Image((int) srcImage.getWidth(), (int) srcImage.getHeight(), pixels, PixelFormat.RGB);
    }


    public static Image greenShift(Image srcImage) {
        float[] pixels = srcImage.toFloatArray(PixelFormat.RGB);
        for (int i = 1; i < pixels.length; i+=3){ 
            pixels[i] += 0.25;

        }

        return new Image((int) srcImage.getWidth(), (int) srcImage.getHeight(), pixels, PixelFormat.RGB);

    }

    public static Image invert(Image srcImage) {
        // TODO: Task 3

        throw new UnsupportedOperationException("Method not yet defined");
    }

    public static void main(String[] args) {
        Image srcImage = new Image("mscs-shield.png"); //Image
    
        Scanner scan = new Scanner(System.in);
        System.out.println("How would you like to transform your image?");
        System.out.println("1. Lighten");
        System.out.println("2. Green Shift");
        System.out.println("3. Invert");

        System.out.print("> ");
        int choice = scan.nextInt();

        Image transformed = switch(choice) {
            default -> srcImage; // If no matching choice, display original image
            case 1 -> lighten(srcImage);
            case 2 -> greenShift(srcImage);
            case 3 -> invert(srcImage);
        };

        CanvasWindow canvas = new CanvasWindow("img", 500, 500);
        canvas.add(transformed);
        transformed.setCenter(canvas.getCenter());

        scan.close();
    }
    
}
