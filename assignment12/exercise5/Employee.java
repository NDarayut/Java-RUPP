package exercise5;

class Employee extends Person{
    // private field that is unique to the class
    private int employeeID;
    private String  jobTitle;
    private double salary;

    // By default, the child default constructor override the parent constructor
    // child default constructor use with parent default constructor to instantiate "name", "age", and "gender" variable
    // and other variable of the child class.
    Employee(String name, int age, String gender, int employeeID, String jobTitle, double salary){
        super(name, age, gender); // use to call the overridden parent constrcutor
        this.employeeID = employeeID;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }
    
    // getter method to retrieved data from the private variable
    int getEmployeeID(){
        return employeeID;
    }

    // setter method use to modify data in the private variable
    void setEmployeeID(int employeeID){
        this.employeeID = employeeID;
    }

    String getJobTitle(){
        return jobTitle;
    }

    void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }

    double getSalary(){
        return salary;
    }

    void setSalary(double salary){
        this.salary = salary;
    }
}
