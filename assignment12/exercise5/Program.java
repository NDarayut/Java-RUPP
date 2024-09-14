package exercise5;

public class Program {
    public static void main(String[] args) {
        Customer customer = new Customer("Daly", 26, "Female", 1, "RUPP, Phnom Penh", "09758829292");
        Employee employee = new Employee("John", 25, "Male", 1, "Executive", 2500.25);

        // using getter method to retrieved data
        System.out.println("Customer name: " + customer.getName());
        System.out.println("Customer age: " + customer.getAge());
        System.out.println("Customer gender: " + customer.getGender());
        System.out.println("Customer ID: " + customer.getCustomerID());
        System.out.println("Customer address: " + customer.getAddress());
        System.out.println("Customer phone number: " + customer.getPhoneNumber());

        System.out.println();

        System.out.println("Employee name: " + employee.getName());
        System.out.println("Employee age: " + employee.getAge());
        System.out.println("Employee gender: " + employee.getGender());
        System.out.println("Employee ID: " + employee.getEmployeeID());
        System.out.println("Employee title: " + employee.getJobTitle());
        System.out.println("Employee salary: " + employee.getSalary());

        System.out.println();
        
        // use setter method to modify existing data
        customer.setAge(28); // modify age using getter
        System.out.println("Customer age after modification: " + customer.getAge());
        employee.setJobTitle("CEO");
        System.out.println("Employee title after modification: " + employee.getJobTitle());
        
    }
}
