package laba3;

import java.util.Scanner;


public class Menu {
    public static void main(String[] args) {
        System.out.println("Пожалуйста, выберите вашу должность\nManager-Librarian-Reader");
        Scanner s = new Scanner(System.in);
        String person = s.nextLine();

        Library library = new Library();
        switch (person){
            case ("Manager"):
                Manager(library);
                break;
            case ("Librarian"):
                Librarian(library);
                break;
            case ("Reader"):
                Reader(library);
                break;
        }
    }
    public static void Manager(Library library) {

        Scanner s = new Scanner(System.in);
        String action;

        while (true) {
            System.out.println("\nПожалуйста, выберите действие:");
            System.out.println("1 - Добавить книгу\n" +
                    "2 - Удалить книгу\n" +
                    "3 - Сколько книг было взято читателями и сколько еще находится в библиотеке?\n" +
                    "4 - Сколько книг по конкретной теме?\n" +
                    "5 - Какие книги брал конкретный читатель?\n" +
                    "Введите 'выход', чтобы завершить");

            action = s.nextLine();

            if (action.equalsIgnoreCase("выход")) {
                System.out.println("Завершение работы.");
                break;
            }

            switch (action) {
                case "1":
                    System.out.println("Введите данные о книге, каждое на новой строке\n" +
                            "• идентификатор\n" +
                            "• имя\n" +
                            "• автор\n" +
                            "• издание\n" +
                            "• издатель\n" +
                            "• год издания\n" +
                            "• категория");

                    Book book = new Book();
                    book.setId(Integer.parseInt(s.nextLine()));
                    book.setTitle(s.nextLine());
                    book.setAuthor(s.nextLine());
                    book.setPublication(s.nextLine());
                    book.setPublisher(s.nextLine());
                    book.setYearOfPublication(Integer.parseInt(s.nextLine()));
                    book.setCategory(s.nextLine());

                    library.manager.addBook(library, book);
                    break;

                case "2":
                    System.out.println("Введите ID книги для удаления:");
                    library.manager.delBook(library, Integer.parseInt(s.nextLine()));
                    break;

                case "3":
                    library.manager.borrowedBooksAndBooksLeft(library);
                    break;

                case "4":
                    System.out.println("Введите категорию книги:");
                    library.manager.booksByCategory(library, s.nextLine());
                    break;

                case "5":
                    System.out.println("Введите ID читателя:");
                    library.manager.booksByReader(library, Integer.parseInt(s.nextLine()));
                    break;

                default:
                    System.out.println("Неверная команда. Пожалуйста, выберите действие снова.");
            }
        }
    }


    public static void Librarian(Library library) {
        Scanner s = new Scanner(System.in);
        String action;

        while (true) {
            System.out.println("Пожалуйста, выберите действие:");
            System.out.println("1 - Найти книгу\n" +
                    "2 - Выдать книгу\n" +
                    "3 - Принять возврат книги\n" +
                    "Введите 'выход', чтобы завершить");

            action = s.nextLine();

            if (action.equalsIgnoreCase("выход")) {
                System.out.println("Завершение работы.");
                break;
            }

            switch (action) {
                case "1":
                    System.out.println("Введите название книги:");
                    library.librarian.findBook(library, s.nextLine());
                    break;

                case "2":
                    System.out.println("Введите данные о читателе, каждое на новой строке\n" +
                            "• идентификатор\n" +
                            "• имя\n" +
                            "• фамилия\n" +
                            "• отчество\n" +
                            "• адрес");

                    Reader reader = new Reader();
                    reader.setId(Integer.parseInt(s.nextLine()));
                    reader.setFirstName(s.nextLine());
                    reader.setSurname(s.nextLine());
                    reader.setPatronymic(s.nextLine());
                    reader.setAddress(s.nextLine());

                    System.out.println("Введите название книги:");
                    library.librarian.giveBook(library, reader, s.nextLine());
                    break;

                case "3":
                    System.out.println("Введите ID читателя:");
                    int id = s.nextInt();

                    System.out.println("Введите название книги:");
                    library.librarian.takeBook(library, id, s.nextLine());
                    break;

                default:
                    System.out.println("Неверная команда. Пожалуйста, выберите действие снова.");
            }
        }
    }

    public static void Reader(Library library) {

        Scanner s = new Scanner(System.in);
        String action;

        while (true) {
            System.out.println("Пожалуйста, выберите действие:");
            System.out.println("1 - Выдать книгу\n" +
                    "2 - Принять возврат книги\n" +
                    "Введите 'выход', чтобы завершить");

            action = s.nextLine();

            if (action.equalsIgnoreCase("выход")) {
                System.out.println("Завершение работы.");
                break;
            }
            System.out.println("Введите ID читателя:");
            int id = Integer.parseInt(s.nextLine());

            if (library.findReaderByid(id) == null){
                System.out.println("Читатель не найден");
                break;
            }
            Reader reader = library.findReaderByid(id);

            switch (action) {
                case "1":
                    System.out.println("Введите название книги:");
                    reader.takeBook(library,s.nextLine(), library.librarian );
                    break;

                case "2":
                    System.out.println("Введите название книги:");
                    String name = s.nextLine();
                    reader.giveBook(library, name, library.librarian);
                    break;

                default:
                    System.out.println("Неверная команда. Пожалуйста, выберите действие снова.");
            }
        }
    }
}
