package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Vladimir");
        student.setMiddleName("Vladimirovich");
        student.setLastName("Putin");

        System.out.println("Имя: " + student.getFirstName() + "\nОтчество: " + student.getMiddleName()
                + "\nФамилия: " + student.getLastName());
    }
}
