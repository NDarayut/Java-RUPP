package exercise6;

class Program {
    public static void main(String[] args) {
        RuppLibrary library1 = new RuppLibrary();
        RuppLibrary library2 = new RuppLibrary();

        library1.addBook(0, "Song of Achilles", "Mac Miller");

        library2.addBook(1, "Sun Tzu: Art of War", "Sun Tzu");

        library2.removeBook(1);

        System.out.println("Book from library 1: " + library1.getBookTitle());
        System.out.println("Book from library 2: " + library2.getBookTitle());

    }
}
