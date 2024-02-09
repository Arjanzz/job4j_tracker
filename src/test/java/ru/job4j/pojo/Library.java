package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 464);
        Book onTheSoul = new Book("On the Soul", 406);
        Book ethics = new Book("Ethics", 402);
        Book dataScience = new Book("Data Science", 220);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = onTheSoul;
        books[2] = ethics;
        books[3] = dataScience;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPage() + " pages");
        }
        System.out.println();

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPage() + " pages");
        }
        System.out.println();

        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println("Search book: " + book.getName());
                break;
            }
        }
    }
}