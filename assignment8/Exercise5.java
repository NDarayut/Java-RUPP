import java.util.HashMap;
import java.util.Scanner;

class Exercise5{

    static void displayEmployee(HashMap<Integer, Object> id){
        System.out.print("\033\143"); // clear terminal
        System.out.println("\t\t---------------------------------------------------");
        System.out.println("\t\t ID\tName\t\tSalary\t\tDepartment");
        System.out.println("\t\t---------------------------------------------------");
        // keySet() return a set of all keys
        for (Integer employeeId : id.keySet()) {
            // the retrieved value is stored in a temporary hashmap, each value correlates to a specific employee
            HashMap<String, Object> employee = (HashMap<String, Object>) id.get(employeeId); // casting the retrived value to Hashmap object
            System.out.print(String.format("\t\t %-8d", employeeId)); // allocate space of 8
            System.out.print(String.format("%-12s", employee.get("name"))); // allocate space of 12
            System.out.print(String.format("\t%-10s", employee.get("salary"))); // allocate space of 10
            System.out.print(String.format("\t%-12s", employee.get("department"))); // allocate space of 12
            System.out.println();
        }
        System.out.println("\t\t---------------------------------------------------");
    }

    static void addNewEmployee(HashMap<Integer, Object> id){
        System.out.print("\033\143"); // clear terminal
        Integer newId; // temporary variable to store new employee id
        String newName; // temporary variable to store new employee name
        Integer newSalary; // temporary variable to store new employee salary
        String newDepartment; // temporary variable to store new employee department
  
        Scanner input = new Scanner(System.in); // create a scanner object

        System.out.print("\t\tEnter new employee ID: ");
        newId = input.nextInt(); 
        
        // check if the hashmap already contained that ID
        if (!id.containsKey(newId)){
            System.out.print("\t\tEnter new employee name: ");
            newName = input.next();

            System.out.print("\t\tEnter new employee salary: ");
            newSalary = input.nextInt();

            System.out.print("\t\tEnter new employee department: ");
            newDepartment = input.next();

            // create a temporary hashmap that stores all the information
            HashMap<String, Object> newEmployee = new HashMap<>();
            newEmployee.put("name", newName);
            newEmployee.put("salary", newSalary);
            newEmployee.put("department", newDepartment);

            // add the temporary hashmap to the main ID hashmap
            id.put(newId, newEmployee);
            System.out.print("\033\143"); // clear terminal
            System.out.println("\t\tSuccessfully added!");
        }
        // execute this if the ID is already occupied
        else{
            System.out.println("\n\t\tID already existed!");
        }   
    }

    static void removeEmployee(HashMap<Integer, Object> id){
        System.out.print("\033\143"); // clear terminal
        Integer delete; // variable to store ID of hashmap that will be deleted

        Scanner input = new Scanner(System.in); // create scanner object
        System.out.print("\n\t\tDelete employee by ID: ");

        delete = input.nextInt();

        // check whether the ID existed or not
        if(id.containsKey(delete)){
            id.remove(delete);
            System.out.println("\n\t\tSuccessfully removed!");
        }
        // execute if user enter non existing ID
        else{
            System.out.println("\n\t\tID doesn't exit!");
        }
    }

    static void updateEmployee(HashMap<Integer, Object> id){
        // temporary variable to store information about updated employee
        Integer updateID;
        String updatedName;
        Integer updatedSalary;
        String updatedDepartment;

        Scanner input = new Scanner(System.in); // create scanner object
        displayEmployee(id); // display the table
        System.out.print("\t\tEnter employee ID to update: ");

        updateID = input.nextInt(); // store employee ID that needed to be updated

        // check if the ID is valid
        if(id.containsKey(updateID)){
            System.out.print("\033\143"); // clear terminal
            // print out that specific employee information
            System.out.println("\n\t\t---------------------------------------------------");
            System.out.println("\t\t ID\tName\t\tSalary\t\tDepartment");
            System.out.println("\t\t---------------------------------------------------");
            System.out.print("\t\t "+ updateID);
            System.out.print("\t"+((HashMap<String, Object>) id.get(updateID)).get("name"));
            System.out.print("\t"+((HashMap<String, Object>) id.get(updateID)).get("salary"));
            System.out.print("\t\t"+((HashMap<String, Object>) id.get(updateID)).get("department"));

            System.out.print("\n\t\tName: ");
            input.nextLine(); // Clear the buffer by consuming the newline character
            updatedName = input.nextLine(); // take updated name
            System.out.print("\t\tSalary: ");
            updatedSalary = input.nextInt(); // take updated salary
            System.out.print("\t\tDepartment: ");
            input.nextLine(); // Clear the buffer by consuming the newline character
            updatedDepartment = input.nextLine(); // take updated department

            // creating a temporary hashmap that stores the updated employee information
            HashMap<String, Object> updatedEmployee = new HashMap<>();
            
            /* 
                all the "if" statement check if the user enter any changes, and the "else" statement will execute 
                if the user enter new changes.
            */
            if(updatedName.length() == 0){
                // retrieved the information from the original hashmap and store it in the temporary hashmap
                updatedEmployee.put("name", ((HashMap<String, Object>) id.get(updateID)).get("name"));
            }
            else{
                // directly stores user changes in the temporary hashmap
                updatedEmployee.put("name", updatedName);
            }
            if(updatedSalary.toString().length() == 0){
                
                updatedEmployee.put("salary", ((HashMap<String, Object>) id.get(updateID)).get("salary"));
            }
            else{
                updatedEmployee.put("salary", updatedSalary);
            }
            if(updatedDepartment.length() == 0){
                updatedEmployee.put("department", ((HashMap<String, Object>) id.get(updateID)).get("department"));
            }
            else{
                updatedEmployee.put("department", updatedDepartment);
            }
            // replace the specified ID information with the updated information
            id.replace(updateID, updatedEmployee);
            System.out.print("\033\143"); // clear terminal
            System.out.println("\n\t\tSuccessfully updated!");
        }
        // execute if the user input is invalid
        else{
            System.out.print("\033\143"); // clear terminal
            System.out.println("\n\t\tEmployee doesn't exist!");  
        }
    }

    static void searchEmployee(HashMap<Integer, Object> id){
        System.out.print("\033\143"); // clear terminal
        Integer searchID; // variable to store ID to be search

        Scanner input = new Scanner(System.in); // create scanner object
        System.out.print("\t\tEnter employee ID to search: ");

        searchID = input.nextInt();

        // check if the ID is valid
        if(id.containsKey(searchID)){
            System.out.println("\n\t\t---------------------------------------------------");
            System.out.println("\t\t ID\tName\t\tSalary\t\tDepartment");
            System.out.println("\t\t---------------------------------------------------");
            System.out.print(String.format("\t\t %-8d", searchID)); 
            System.out.print(String.format("%-10s",((HashMap<String, Object>) id.get(searchID)).get("name")));
            System.out.print(String.format("\t %-12s",((HashMap<String, Object>) id.get(searchID)).get("salary")));
            System.out.print(String.format("\t %-12s",((HashMap<String, Object>) id.get(searchID)).get("department")));
        }
        // execute if the ID is invalid
        else{
            System.out.println("\t\tEmployee not found!");
        }    
    }

    public static void main(String[] args) {

        System.out.print("\033\143"); // clear terminal
        Scanner input = new Scanner(System.in); // create scanner object
        char userInput; // take user input as a single character

        // first employee detail
        HashMap<String, Object> employee1 = new HashMap<>();
        employee1.put("name", "Chan Dara");
        employee1.put("salary", 800);
        employee1.put("department", "ITE");

        // second employee detail
        HashMap<String, Object> employee2 = new HashMap<>();
        employee2.put("name", "Sok Sophea");
        employee2.put("salary", 900);
        employee2.put("department", "BioE");

        // third employee detail
        HashMap<String, Object> employee3 = new HashMap<>();
        employee3.put("name", "Keo Tola");
        employee3.put("salary", 500);
        employee3.put("department", "TEE");

        // store all employee detail in a main hashmap
        HashMap<Integer, Object> id = new HashMap<>();
        id.put(1, employee1);
        id.put(2, employee2);
        id.put(3, employee3);

        do{
            System.out.println("\n\t\ta. Display all employees");
            System.out.println("\t\tb. Add a new employee");
            System.out.println("\t\tc. Delete employee by ID");
            System.out.println("\t\td. Update employee by ID");
            System.out.println("\t\te. Search employee by ID");
            System.out.println("\t\tf. Exit the program");
            System.out.print("\n\t\tEnter: ");
            
            // take user input as a char
            userInput = input.next().charAt(0);

            // switch case to check condition
            switch(userInput){
                case 'a': 
                        displayEmployee(id);
                        break;
                case 'b':
                        addNewEmployee(id);
                        break;
                case 'c':
                        removeEmployee(id);
                        break;
                case 'd':
                        updateEmployee(id);
                        break;
                case 'e':
                        searchEmployee(id);
                        break;
                default:
                        System.out.println("\t\tInvalid option!");
                        break;
            }

        }while(userInput != 'f'); // will continue to run as long as user didnt input 'f'

        input.close(); // close scanner
    }
}