package laba3;

public class Librarian extends Person {

    public Librarian(int Id, String firstName, String surname, String patronymic, String address) {
        super(Id, firstName, surname, patronymic, address);
    }

    public void findBook(Library library, String title){
        library.findBook(title);
    }
    public void giveBook(Library library, Reader reader, String title){
        library.giveBook(reader,title);
    }

    public void takeBook(Library library, int id, String title){
        library.takeBook(id,title);
    }

}
