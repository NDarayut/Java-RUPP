import java.util.HashMap;
import java.util.Scanner;

class Score{
    
    // instance variable to store data of each objects
    double mathScore;
    double phyScore;
    double chemScore;

    // constructor storing each initialization arguments
    // into the variable
    Score(double mathScore, double phyScore, double chemScore){
        this.mathScore = mathScore;
        this.phyScore = phyScore;
        this.chemScore = chemScore;
    }

    // method to get the total score of student
    double getTotal(){
        return mathScore + phyScore + chemScore;
    }
}

class Student{
    
    // instance variable to store each data of student
    Integer id;
    String name;
    Score score; // is a method

    // constructor to storing each initialization into the instance variable
    Student(Integer id, String name, Score score){
        this.id = id;
        this.name = name;
        this.score = score;
    }

    // Return a student object 
    static Student readStudent(){
        Scanner input = new Scanner(System.in);
        System.out.print("\t\tEnter id: ");
        Integer id = input.nextInt(); // store as Integer because we use it in hashmap

        input.nextLine(); // Clear buffer

        System.out.print("\t\tEnter name: ");
        String name = input.nextLine();

        System.out.print("\t\tEnter math score: ");
        double mathScores = input.nextDouble();
   
        System.out.print("\t\tEnter physic score: ");
        double physicScores = input.nextDouble();
   
        System.out.print("\t\tEnter chemistry score: ");
        double chemistryScores = input.nextDouble();
        
        // initialize a score object for the student
        Score score = new Score(mathScores, physicScores, chemistryScores);

        // initialize a student object using id, name and the score object
        Student student = new Student(id, name, score);

        return student; // return the object to get added into the hashmap
    }
}

public class Exercise5 {

    // method to store menu option
    static void displayMenu(){
        System.out.println("\n\n\t\t---------------------------");
        System.out.println("\t\t\tOptions");
        System.out.println("\t\t---------------------------");
        System.out.println("\t\ta. Add new student");
        System.out.println("\t\tb. Delete student by id");
        System.out.println("\t\tc. Search student by id");
        System.out.println("\t\td. Display all students");
        System.out.println("\t\te. Exit program");
    }

    // method to display students according to Id
    static void displayStudent(HashMap<Integer, Student> students, Integer key){
        
        System.out.print("\n\t\t " + key);
        System.out.printf("\t%-8s", students.get(key).name); // access the object through key and access the name
        System.out.printf("%.1f", students.get(key).score.mathScore);
        System.out.printf("\t%.1f", students.get(key).score.phyScore);
        System.out.printf("\t   %-8.1f", students.get(key).score.chemScore);
        System.out.printf("\t%-8.1f", students.get(key).score.getTotal());
    }

    public static void main(String[] args){

        System.out.print("\033\143"); // clear terminal
        Scanner input = new Scanner(System.in); // Scanner object

        // Create 3 score object for 3 students
        Score student1Score = new Score(99.9, 89.9, 90);
        Score student2Score = new Score(98.9, 85.9, 99);
        Score student3Score = new Score(95.9, 99.9, 85);
        // Create 3 students object with the student score object as one of its parameters
        Student student1 = new Student(1, "Serey",student1Score);
        Student student2 = new Student(2, "Sak",student2Score);
        Student student3 = new Student(3, "Seth",student3Score);

        HashMap<Integer, Student> students = new HashMap<>(); // Create hashmap with object as value

        // input all the object into the hashmap
        students.put(student1.id, student1);
        students.put(student2.id, student2);
        students.put(student3.id, student3);

        // user input store as char to reduce memory usage
        char userOption;

        // run as long as user dont enter 'e'
        do { 
            displayMenu(); // display the menu option
            System.out.print("\n\t\tEnter option: ");
            userOption = input.next().charAt(0); // store user input as char
            
            switch(userOption){

                // Add new student
                case 'a' -> {
                    
                    // ask user to enter student info, they can choose to enter again or exit if met with an error
                    while(true){
                        System.out.print("\033\143"); // clear terminal
                        Student temporaryStudent = Student.readStudent(); // return a student object

                        // Add student to list if id doesnt exist and is positive integer
                        if((!students.containsKey(temporaryStudent.id)) && (temporaryStudent.id > 0)){
                            students.put(temporaryStudent.id, temporaryStudent); // add the object to a hashmap
                            System.out.print("\033\143"); // clear terminal
                            System.out.println("\n\t\tStudent successfully added!");
                            break; // break out of while loop
                        }

                        // Id already exist ask user to retry or go back to menu
                        else{
                            System.out.println("\n\t\tInvalid ID. ID must be unique and positive integer");
                            System.out.print("\t\ta. Retry \n\t\tb. Back");
                            System.out.print("\n\t\tEnter: ");
                            userOption = input.next().charAt(0);
                            if(userOption == 'b'){
                                System.out.print("\033\143"); // clear terminal
                                break; // break out of the while loop
                            }
                        }
                    }
                }

                // delete student 
                case 'b' -> {
                    // while loop to keep asking for user id to delete
                    while(true){
                        System.out.print("\033\143"); // clear terminal
                        System.out.print("\t\tEnter student id to delete: ");
                        Integer deleteId = input.nextInt(); // user input id
                        input.nextLine(); // clear buffer 

                        // delete the student when ID is found
                        if(students.containsKey(deleteId)){
                            students.remove(deleteId);
                            System.out.print("\033\143"); // clear terminal
                            System.out.println("\t\tDelete success full");
                            break;
                        }

                        // ask if they wanna retry or go back to menu if id not found
                        else{
                            System.out.print("\t\tInvalid ID!");
                            System.out.print("\n\t\ta. Retry \n\t\tb. Back");
                            System.out.print("\n\t\tEnter: ");
                            userOption = input.next().charAt(0);
                            if(userOption == 'b'){
                                System.out.print("\033\143"); // clear terminal
                                break; // break out of the while loop
                            }
                        }
                    } 
                }

                // search student
                case 'c' -> {
                    // find available id, if not, ask user to retry or go back to menu
                    while(true){
                        System.out.print("\033\143"); // clear terminal
                        System.out.print("\t\tEnter student id to search: ");
                        Integer studentId = input.nextInt();

                        // print students information if id is found
                        if(students.containsKey(studentId)){
                            System.out.print("\033\143"); // clear terminal
                            System.out.println("\t\t-----------------------------------------------------");
                            System.out.print("\t\t ID\tName\tMath\tPhysics\t   Chemistry\tTotal");
                            System.out.print("\n\t\t-----------------------------------------------------");
                            displayStudent(students, studentId);
                            break; // break from while loop
                        }

                        // tell the user id is not found, and ask if they wanna retry or exit
                        else{
                            System.out.print("\t\tSearch not found!");
                            System.out.print("\n\t\ta. Retry \n\t\tb. Back");
                            System.out.print("\n\t\tEnter: ");
                            userOption = input.next().charAt(0);
                            if(userOption == 'b'){
                                System.out.print("\033\143"); // clear terminal
                                break; // break out of the while loop
                            }
                        }
                    }  
                }

                // display all students
                case 'd' -> {
                    System.out.print("\033\143"); // clear terminal
                    System.out.println("\t\t-----------------------------------------------------");
                    System.out.print("\t\t ID\tName\tMath\tPhysics\t   Chemistry\tTotal");
                    System.out.print("\n\t\t-----------------------------------------------------");

                    // iteratively get the key from students hashmap
                    // and print every students information
                    for(Integer key: students.keySet()){
                        displayStudent(students, key);
                    }
                    System.out.println("\n\t\t-----------------------------------------------------");
                    }
                   
                // if user enter anything other than the display option
                default -> {
                    System.out.print("\033\143"); // clear terminal
                    System.out.println("\t\tInvalid option!");
                }
            }
        } while (userOption != 'e'); 

        input.close();
        System.out.print("\033\143"); // clear terminal
        System.out.println("\t\tExit complete");
        input.close();
        System.exit(0);
    }
}
