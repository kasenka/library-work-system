package laba3;

public class Book {
    public int id;
    public String title;
    public String author;
    public String publication;
    public String publisher;
    public int yearOfPublication;
    public String category;

    public Book(int id, String title, String author, String publication, String publisher, int yearOfPublication, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.category = category;
    }

    public Book(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublication() { return publication; }
    public String getPublisher() { return publisher; }
    public int getYearOfPublication() { return yearOfPublication; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "Книга{" +
                "ID=" + id +
                ", Название='" + title + '\'' +
                ", Автор='" + author + '\'' +
                ", Издание='" + publication + '\'' +
                ", Издатель='" + publisher + '\'' +
                ", Год издания=" + yearOfPublication +
                ", Категория='" + category + '\'' +
                '}';
    }
}
