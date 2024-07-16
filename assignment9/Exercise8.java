import java.util.HashMap;

class Grade{
    
    // instance variable of the class
    int A;
    int B;
    int C;
    int D;
    int F;

    // set amount of student per grade 
    void setGrade(int A, int B, int C, int D, int F){
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.F = F;
    }
    
    // get total number of student
    int getTotalStudent(){
        return A + B + C + D + F;
    }

    // get percentages of each grade
    HashMap<Character, Integer> getGradePercentage(){
        // retrieve the total amount of student
        int totalStudent = getTotalStudent();

        // store each grade percentages as a hashmap
        HashMap<Character, Integer> percentages = new HashMap<>();
        
        // calculate each grade's percentages based on amount of student per grade
        percentages.put('A', (A * 100) / totalStudent);
        percentages.put('B', (B * 100) / totalStudent);
        percentages.put('C', (C * 100) / totalStudent);
        percentages.put('D', (D * 100) / totalStudent);
        percentages.put('F', (F * 100) / totalStudent);

        return percentages; // return the hashmap
    }

    // draw bar graph based on percentages
    // each * is 2%
    void gradeDistribution(){

        // retrieve the hashmap
        HashMap<Character, Integer> percentages = getGradePercentage();
        
        // calculate amount of stars needed per grade
        // we retrieve the integer, turn it into a double to round it to the nearest integer 
        // and turn it back to int
        int barGraphA = (int)Math.round(percentages.get('A') / 2.0);
        int barGraphB = (int)Math.round(percentages.get('B') / 2.0);
        int barGraphC = (int)Math.round(percentages.get('C') / 2.0);
        int barGraphD = (int)Math.round(percentages.get('D') / 2.0);
        int barGraphF = (int)Math.round(percentages.get('F') / 2.0);
        
        // print out the percentage number increment by 10
        for(int percent = 0; percent <= 100; percent+=10){
            if(percent == 100){
                System.out.print(percent+"%");
            }
            else{
                System.out.print(percent+"   ");
            }  
        }
       
        System.out.println();

        // print out the line indicator of each percentage
        for(int indicator = 0; indicator <= 100; indicator+=10){

            // the very last percentage only has 3 space apart
            if(indicator == 90){
                System.out.print("|   ");
            }
            // other percentages is 4 space apart
            else{
                System.out.print("|    ");
            }
        }

        System.out.println();

        // print out 50 stars meaning 100 percent
        for(int stars = 0; stars < 50; stars++){
            System.out.print("*");
        }

        System.out.println();

        // print bar graph A
        for(int bar = 0; bar < barGraphA; bar++) System.out.print("*");
        System.out.println("A");
        // print bar graph B
        for(int bar = 0; bar < barGraphB; bar++) System.out.print("*");
        System.out.println("B");
        // print bar graph C
        for(int bar = 0; bar < barGraphC; bar++) System.out.print("*");
        System.out.println("C");
        // print bar graph D
        for(int bar = 0; bar < barGraphD; bar++) System.out.print("*");
        System.out.println("D");
        // print bar graph F
        for(int bar = 0; bar < barGraphF; bar++) System.out.print("*");
        System.out.println("F");
    }
}

public class Exercise8 {
    public static void main(String[] args) {

        // create object grade
        Grade grade = new Grade();
        // initialize instance variable of the object
        grade.setGrade(1, 4, 6, 2, 1);

        // print out number of student at every grade based on key
        for(Character key : grade.getGradePercentage().keySet()){
            System.out.println(key + ": " + grade.getGradePercentage().get(key) + "%");
        }

        // print out total number of students
        System.out.println("Total student: " + grade.getTotalStudent());

        // print out the bar graph
        grade.gradeDistribution();       
    }
}
