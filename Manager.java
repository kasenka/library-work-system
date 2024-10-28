package laba3;

public class Manager extends Person{

    public Manager(int Id, String firstName, String surname, String patronymic, String address){
        super(Id, firstName, surname, patronymic, address);
    }
    public void addBook(Library library, Book book){
        library.addBook(book);
    }

    public void delBook(Library library,int id){
        library.delBook(id);
    }
    public void borrowedBooksAndBooksLeft(Library library){
        library.borrowedBooksAndBooksLeft();
    }
    public void booksByCategory(Library library, String category){
        library.booksByCategory(category);
    }
    public void booksByReader(Library library, int id){
        library.booksByReader(id);
    }
}
