import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int totalPoints = 0;
         for(Point pt:s.getPoints()){
             totalPoints = totalPoints + 1;
             
         }
        // Put code here
        return totalPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        int p = getNumPoints(s);
        double length = getPerimeter(s);
        return length/p;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double longest = 0.0;
        Point prev = s.getLastPoint();
        for(Point curr:s.getPoints()){
            double length = prev.distance(curr);
            prev = curr;
            if(length > longest) longest = length;
            
        }
        return longest;
    }

    public double getLargestX(Shape s) {
        double largestX = 0.0;
        for(Point curr:s.getPoints()){
            double x = curr.getX();
            if(x > largestX) largestX = x; 
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeterOfShape = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double peri = getPerimeter(s);
            
            if(peri > largestPerimeterOfShape) largestPerimeterOfShape = peri;
        }
        return largestPerimeterOfShape;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;
        // replace this code
        double largestPerimeterOfShape = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double peri = getPerimeter(s);
            
            if(peri > largestPerimeterOfShape){
                largestPerimeterOfShape = peri;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int noOfPoints = getNumPoints(s);
        double avgLength = getAverageLength(s);
        double largestSideLength = getLargestSide(s);
        System.out.println("perimeter = " + length);
        System.out.println("Points length = " + noOfPoints);
        System.out.println("avg length = " + avgLength);
        System.out.println("largest side length = " + largestSideLength);
        System.out.println("largest x = " + getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("largest perimeter from Multiple files "+getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("File name of largest Perimeter:  "+getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        //pr.testFileWithLargestPerimeter();
    }
}
