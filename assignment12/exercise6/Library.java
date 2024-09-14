package exercise6;

// abstract library class is used as a blueprint or base for other subclasses
abstract class Library {

    abstract void addBook(Integer id, String title, String author);

    abstract void removeBook(Integer id);

    abstract void generateReport();

    // getter and setter method
    abstract Integer getBookID();

    abstract void setBookID(Integer id);

    abstract String getBookTitle();

    abstract void setBookTitle(String title);

    abstract String getBookAuthor();

    abstract void setBookAuthor(String author);

    abstract Boolean getCheckedOut();

    abstract void setCheckedOut(Boolean CheckedOut);

    abstract Boolean getReturnedBook();

    abstract void setReturnedBook(Boolean returnedBook);


}
