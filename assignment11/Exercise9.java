import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Employee{
    // instance variable to initialize up object creation
    String id;
    String name;
    String gender;
    String salary;

    void addEmployee(){
        // arraylist to hold employee data to check if the ID already existed
        ArrayList<ArrayList<String>> employeeData = new ArrayList<>();
        String line; // use to read data line bby line
        Scanner input = new Scanner(System.in);
        System.out.print("\t\tEnter id: ");
        this.id = input.nextLine(); // store user input into object variable

        // this try block check whether is there a duplicates ID
        try {
            // create reader objects
            BufferedReader reader = new BufferedReader(new FileReader("Employee.txt"));

            // read data line by line and stores them in an temporary arraylist
            while((line = reader.readLine()) != null){
                ArrayList<String> temporaryEmployee = new ArrayList<>();
                String[] data = line.split(" "); // split the data by space
                for(String string : data){
                    // add the data into a temporary 1D arraylist
                    temporaryEmployee.add(string);
                }
                // add the arraylist to a 2d arraylist
                employeeData.add(temporaryEmployee);
            }
            reader.close(); // closes the object reader

            // check whether the id existed
            for (ArrayList<String> employee : employeeData) {
                if(employee.get(0).equals(id)){
                    System.out.println("\t\tID already exist");
                    return;
                }
            }

            // take more information
            System.out.print("\t\tEnter name: ");
            this.name = input.nextLine();
            System.out.print("\t\tEnter gender: ");
            this.gender = input.nextLine().toUpperCase();
            System.out.print("\t\tEnter salary: ");
            this.salary = input.nextLine();

            // create writer object
            FileWriter writer = new FileWriter("Employee.txt", true);
            
            // add each data with a spacing in between and a newline at the end
            writer.write(id + " ");
            writer.write(name + " ");
            writer.write(gender + " ");
            writer.write(salary + " \n");

            System.out.print("\033\143"); // clear terminal
            System.out.println("\t\tEmployee added successfully");
            
            writer.close(); // close writer

        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }

    void deleteEmployee(){

        Scanner input = new Scanner(System.in);
        System.out.print("\t\tEnter id to delete: ");
        String idDelete = input.nextLine(); // id to search for deletetion
        String line;
        // temporary 2d arraylist to store employee data to append them after deletetion
        ArrayList<ArrayList<String>> temporaryEmployeeData = new ArrayList<>();
        
        boolean found = false; // check if we found the ID
        
        try {
            // create object reader
            BufferedReader reader = new BufferedReader(new FileReader("Employee.txt"));

            // read data line by line and stores them into the 2d arraylist
            while((line = reader.readLine()) != null){
                String[] data = line.split(" ");
                ArrayList<String> temporaryEmployee = new ArrayList<>();
                for(String string : data){
                    temporaryEmployee.add(string);
                }
                temporaryEmployeeData.add(temporaryEmployee);
            }

            reader.close(); // closes the reader
        } 
        catch (Exception e) {
            System.out.println(e);
        }

        // loop through the arraylist and check whether the ID is found
        for (int i = 0; i < temporaryEmployeeData.size(); i++) {
            // if ID does exist we set the boolean to true, delete the data from the arraylist and break from the for-loop
            if(temporaryEmployeeData.get(i).get(0).equals(idDelete)){
                temporaryEmployeeData.remove(i);
                found = true;
                break;
            }
        }

        // if we found the ID we rewrite the data again but this time the deleted data wont get added
        if(found){
            try {
                FileWriter writer = new FileWriter("Employee.txt");
                for(ArrayList<String> employeeData: temporaryEmployeeData){
                        
                    for(int i = 0; i < employeeData.size(); i++){
                        writer.write(employeeData.get(i) + " ");
                    }
                    // new line after write 1 line
                    writer.write("\n");   
                }
                System.out.print("\033\143"); // clear terminal
                System.out.println("\t\tEmployee deleted successfully");
                writer.close(); // closes the writer
            } 
            catch (Exception e) {
                System.out.println(e);
            }
        }
        // if found still false then we didnt find any ID
        else{
            System.out.print("\033\143"); // clear terminal
            System.out.println("\t\tID not found!");
        }
    }

    void displayEmployee(){
        // A 2d arraylist to temporary store data to be display on to the console
        ArrayList<ArrayList<String>> employeeData = new ArrayList<>();
        
        String line; // use to get string of text line by line
        try {
            // create object reader
            BufferedReader reader = new BufferedReader(new FileReader("Employee.txt"));

            // reader the data and add them into the 2d arraylist
            while((line = reader.readLine()) != null){
                String[] data = line.split(" "); // split data by space
                ArrayList<String> temporaryEmployee = new ArrayList<>();
                for(String string : data){
                    temporaryEmployee.add(string);
                }
                employeeData.add(temporaryEmployee);
            }
            reader.close(); // closes the reader

            System.out.println("\n\t\t---------------------------------------------------");
            System.out.println("\t\t ID\tName\t\tGender\t\tSalary");
            System.out.println("\t\t---------------------------------------------------");

            // display all the data inside the 2D arraylist using for-each loop
            for (ArrayList<String> employee : employeeData) {
               
                System.out.print(String.format("\t\t %-8s", employee.get(0))); 
                System.out.print(String.format("%-10s",employee.get(1)));
                System.out.print(String.format("\t %-12s",employee.get(2)));
                System.out.print(String.format("\t %-12s",employee.get(3)));
                System.out.println();
            }

            System.out.println("\n\t\t---------------------------------------------------");
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }

    void searchEmployee(){
        // 2D array to store temporary data
        ArrayList<ArrayList<String>> employeeData = new ArrayList<>();
        
        String line; // yse to get text string line by line

        Scanner input = new Scanner(System.in);
        System.out.print("\t\tEnter id to search: ");
        String idSearch = input.nextLine();

        try {
            // create object reader
            BufferedReader reader = new BufferedReader(new FileReader("Employee.txt"));

            // read and store employee data line by line into the 2d arraylist
            while((line = reader.readLine()) != null){
                ArrayList<String> temporaryEmployee = new ArrayList<>();
                String[] data = line.split(" ");
                for(String string : data){
                    temporaryEmployee.add(string);
                }
                employeeData.add(temporaryEmployee);
            }

            reader.close(); // closes the reader

            // loop through the arraylist and check if the id matches the search id
            for (ArrayList<String> employee : employeeData) {
                if(employee.get(0).equals(idSearch)){
                    System.out.println("\n\t\t---------------------------------------------------");
                    System.out.println("\t\t ID\tName\t\tGender\t\tSalary");
                    System.out.println("\t\t---------------------------------------------------");
                    System.out.print(String.format("\t\t %-8s",employee.get(0))); 
                    System.out.print(String.format("%-10s",employee.get(1)));
                    System.out.print(String.format("\t %-12s",employee.get(2)));
                    System.out.print(String.format("\t %-12s",employee.get(3)));
                    System.out.println("\n\t\t---------------------------------------------------");
                    return; // if match we instantly return
                }
            }
            System.out.print("\033\143"); // clear terminal
            System.out.println("\t\tSearch not found!"); // after for-loop ended we assume that id is not found 
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class Exercise9 {
    public static void main(String[] args) {
        System.out.print("\033\143"); // clear terminal
        Employee employee = new Employee(); 
        Scanner input = new Scanner(System.in);

        // create a text file called Employee.txt
        File employeeFile = new File("Employee.txt");
        try {
            employeeFile.createNewFile();
            FileWriter writer = new FileWriter("Employee.txt");
            
            writer.write("1 Lucy F 300\n");
            writer.write("2 John M 400\n");
            writer.write("3 Alex M 500\n");
 
            writer.close(); // close writer

            while (true) {
                System.out.println("\n\t\tMenu:");
                System.out.println("\t\ta. Add a new employee");
                System.out.println("\t\tb. Delete employee by id");
                System.out.println("\t\tc. Search employee by id");
                System.out.println("\t\td. Display all employees");
                System.out.println("\t\te. Exit the program");
                System.out.print("\t\tEnter your choice: ");
                char choice = input.next().charAt(0);
    
                switch (choice) {
                    case 'a':
                        System.out.print("\033\143"); // clear terminal
                        employee.addEmployee();
                        break;
                    case 'b':
                        System.out.print("\033\143"); // clear terminal
                        employee.deleteEmployee();
                        break;
                    case 'c':
                        System.out.print("\033\143"); // clear terminal
                        employee.searchEmployee();
                        break;
                    case 'd':
                        System.out.print("\033\143"); // clear terminal
                        employee.displayEmployee();
                        break;
                    case 'e':
                        System.out.print("\033\143"); // clear terminal
                        System.out.println("\t\tExiting the program.");
                        System.exit(0); // terminate program
                    default:
                        System.out.print("\033\143"); // clear terminal
                        System.out.println("\t\tInvalid choice. Please try again.");
                }
            }
        } 
        catch (Exception e) {
            System.out.println(e);
        }

        input.close();
        
    }
}
