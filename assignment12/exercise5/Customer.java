package exercise5;

class Customer extends Person{
    
    // private field that is unique to the specific class
    private int customerID;
    private String address;
    private String phoneNumber;

    // child default constructor use to initialize the variabl
    // super() is used to call the parent default constructor to initialize the parent variable
    Customer(String name, int age, String gender, int customerID, String address, String phoneNumber){
        super(name, age, gender); // use to call the overridden parent constrcutor
        this.customerID = customerID;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // getter method use to retrieved the variable data
    int getCustomerID(){
        return customerID;
    }

    // setter method use to modify the variable data
    void setCustomerID(int customerID){
        this.customerID = customerID;
    }

    String getAddress(){
        return address;
    }

    void setAddress(String address){
        this.address = address;
    }

    String getPhoneNumber(){
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
}
