package exercise5;

// abstract class act as a base code for other subclasses.
// we do not use abstract class to instantiate an object
abstract class Person {
    // Private field to avoid other class from accessing it directly
    private String name;
    private int age;
    private String gender;

    // default constructor to initialize the class's variable
    // This default constructor will be called using the super() keyword to give value to the private variable
    Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // getter method to access the class private variable
    String getName(){
        return name;
    }

    // setter method to modify the class private variable
    void setName(String name){
        this.name = name;
    }

    int getAge(){
        return age;
    }

    void setAge(int age){
        this.age = age;
    }

    String getGender(){
        return gender;
    }
     
    void setGender(String gender){
        this.gender = gender;
    }
}
