package exercise6;

public class RuppLibrary extends Library{
    
    // private field to ensure no other class can access it
    private Integer id;
    private String title;
    private String author;
    private Boolean checkedOut;
    private Boolean returnedBook;

    RuppLibrary(){
        System.out.println("This is RUPP library");
    }

    void addBook(Integer id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
        this.checkedOut = false;
        this.returnedBook = true;
        System.out.println("Book added!");
    }

    void removeBook(Integer id){
        if(this.id == id){
            this.id = null;
            this.title = null;
            this.author = null;
            this.checkedOut = null;
            this.returnedBook = null;

            System.out.println("Book removed");
            return;
        }
        else{
            System.out.println("Incorrect ID");
        }
        
    }

    void generateReport(){
        System.out.println("Book's title: " + title);
        System.out.println("Book's author: " + author);
        System.out.println("Book's ID: " + id);
        System.out.println("Checkout: " + checkedOut);
        System.out.println("Return: " + returnedBook);
    }

    // getter and setter method
    Boolean getCheckedOut(){
        return checkedOut;
    }

    void setCheckedOut(Boolean checkedOut){
        this.checkedOut = checkedOut;
    }

    Integer getBookID(){
        return id;
    }

    void setBookID(Integer id){
        this.id = id;
    }

    String getBookTitle(){
        return title;
    }

    void setBookTitle(String title){
        this.title = title;
    }

    String getBookAuthor(){
        return author;
    }

    void setBookAuthor(String author){
        this.author = author;
    }

    Boolean getReturnedBook(){
        return returnedBook;
    }

    void setReturnedBook(Boolean returnedBook){
        this.returnedBook = returnedBook;
    }
}
