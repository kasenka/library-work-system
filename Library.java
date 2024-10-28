package laba3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    public static List<Book> books = new ArrayList<>();
    public static List<Reader> readers = new ArrayList<>();
    public static Map<Book,Integer> borrowedBooks = new HashMap<>();
    Librarian librarian = new Librarian(1,"Daria","Kopova","Mihailovna","Piter");
    Manager manager = new Manager(1, "Maria", "Kotova", "Mihailovna", "Piter");



    static {
        books.add(new Book(1, "Effective Java", "Joshua Bloch", "Addison-Wesley", "Pearson", 2008, "Programming"));
        books.add(new Book(2, "Clean Code", "Robert C. Martin", "Prentice Hall", "Pearson", 2008, "Software Development"));
        books.add(new Book(3, "Design Patterns", "Erich Gamma", "Addison-Wesley", "Pearson", 1994, "Software Engineering"));
        books.add(new Book(4, "Refactoring", "Martin Fowler", "Addison-Wesley", "Pearson", 1999, "Software Development"));
        books.add(new Book(5, "The Pragmatic Programmer", "Andrew Hunt", "Addison-Wesley", "Pearson", 1999, "Programming"));

        readers.add(new Reader(1, "John", "Doe", "Michael", "123 Elm Street"));
        readers.add(new Reader(2, "Jane", "Smith", "Ann", "456 Oak Avenue"));
        readers.add(new Reader(3, "James", "Brown", "Patrick", "789 Pine Road"));
        readers.add(new Reader(4, "Emily", "Davis", "Marie", "101 Maple Boulevard"));
        readers.add(new Reader(5, "Michael", "Johnson", "Edward", "202 Cedar Drive"));
    }
    public Reader findReaderByid(int id){
        return readers.stream()
                .filter(reader -> reader.Id == id)
                .findAny()
                .orElse(null);
    }
    //-------------MANAGER-------------

    public static void addBook(Book book){
        books.add(book);
    }
    public static void delBook(int id){
        books.removeIf(book -> book.getId() == id);
    }
    public static void borrowedBooksAndBooksLeft(){
        int borrowed = borrowedBooks.keySet().size();
        int left = books.size() - borrowed;
        System.out.println("Borrowed Books - " + borrowed + "\nBooks Left - " + left);;
    }
    public static void booksByCategory(String category){
        int count = 0;
        for (Book book :books){
            if (book.category.equals(category)){
                count +=1;
                System.out.println(book.toString());
            }
        } System.out.println(count);
    }
    public static void booksByReader(int id){
        for(Book book: borrowedBooks.keySet()){
            if (borrowedBooks.get(book) == id){
                System.out.println(book.toString());
            }
        }
    }

    //-------------LIBRARIAN-------------

    public static boolean findBook(String title){
        for (Book book :books) {
            if (book.title.equals(title) && !borrowedBooks.keySet().contains(book)) {
                System.out.println("Книга в наличии");
                return true;
            }
        }
        System.out.println("Книга не в наличии");
        return false;
    }
    public static void giveBook(Reader reader,String title){
        if (findBook(title)){
            System.out.println("Вы взяли книгу " + title+"\n");
            for (Book book :books) {
                if (book.title.equals(title)) {
                    borrowedBooks.put(book, reader.Id);
                }
            }
        }
    }

    public static void takeBook(int id,String title){
        Book book = borrowedBooks.keySet().stream()
                .filter(b -> b.getTitle().equals(title))
                .findAny()
                .orElse(null);
        if (book != null && borrowedBooks.get(book) == id){
            System.out.println("Вы вернули книгу " + book.title+"\n");
            borrowedBooks.remove(book);
        }
        else{
            System.out.println("Вы не брали данную книгу\n");
        }
    }

}
