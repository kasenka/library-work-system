package laba3;

public class Reader extends Person {

    public Reader(int Id, String firstName, String surname, String patronymic, String address) {
        super(Id, firstName, surname, patronymic, address);
    }
    public Reader(){

    }
    public int getId() { return Id; }
    public void setId(int id) { this.Id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }


    public void takeBook(Library library, String title, Librarian librarian){
        librarian.giveBook( library, this, title);
    }
    public void giveBook(Library library, String title, Librarian librarian){
        librarian.takeBook( library, Id, title);

    }
}
