package laba3;

public abstract class Person {
    protected int Id;
    protected String firstName;
    protected String surname;
    protected String patronymic;
    protected String address;

    public Person(int Id, String firstName, String surname, String patronymic, String address) {
        this.Id = Id;
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
    }

    public Person(){

    }
}
