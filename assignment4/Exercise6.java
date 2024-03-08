import java.lang.Math; // Import math class

public class Exercise6 {
    public static void main(String[] args) {

        //Initialize array to store all the points
        double[][] points = {{ -1, 0 }, 
                            { -1, -1 }, 
                            { 4, 1 }, 
                            { 2, 0.5 }, 
                            { 3.5, 2 }, 
                            { 3, 1.5 }, 
                            { -1.5, 4 }, 
                            { 5.5, 4 }};

        // Initialize necessary variable
        double farthestDistance = 0;
        double distance = 0;
        double[][] result = new double[2][2];

        // Loop from 0 to 6 index 
        for(int i = 0; i < points.length-1; i++) {
            // Loop from i + 1 to 7 index 
            for(int j = i + 1; j < points.length; j++) {

                // Calculate distance between one point to every other point
                distance = Math.sqrt(Math.pow(points[j][0] - points[i][0], 2) + Math.pow(points[j][1] - points[i][1], 2));

                // if the calcutaed distance is bigger
                // than the farthest distance, we swap them
                if(distance > farthestDistance){
                    farthestDistance = distance;
                    // Store the farthest points to another
                    // array
                    result[0][0] = points[i][0]; 
                    result[0][1] = points[i][1];
                    result[1][0] = points[j][0];
                    result[1][1] = points[j][1];
                }
            }
        }

        // Print distance and the farthest points
        System.out.println("Farthest distance is " + String.format("%.3f",farthestDistance));
        System.out.println("Point 1: (" + result[0][0] + ", " + result[0][1] + ")" );
        System.out.println("Point 2: (" + result[1][0] + ", " + result[1][1] + ")" );
    }
}
