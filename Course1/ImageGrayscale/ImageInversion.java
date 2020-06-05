
import edu.duke.*;
import java.io.File;

public class ImageInversion {
    public ImageResource makeInversion(ImageResource inImage) {
        //I made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        //for each pixel in outImage
        for(Pixel pixel:outImage.pixels()){
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
            pixel.setRed(255-inPixel.getRed());
            //set pixel's green to average
            pixel.setGreen(255-inPixel.getGreen());
            //set pixel's blue to average
            pixel.setBlue(255-inPixel.getBlue());
        }
        //outImage is your answer
        return outImage;
    }
    
    public void doSave(){
        DirectoryResource dr =new DirectoryResource();
        for(File f:dr.selectedFiles()){
            ImageResource Oimage = new ImageResource(f);
            ImageResource image = makeInversion(Oimage);
            String fname = Oimage.getFileName();
            String newName ="inverted-"+fname;
            image.setFileName(newName);
            System.out.println(newName);
            image.save();
            image.draw();
        }
    }
}
