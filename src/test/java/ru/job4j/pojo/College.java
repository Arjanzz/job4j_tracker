package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Vladimir");
        student.setMiddleName("Vladimirovich");
        student.setLastName("Putin");
        String s = System.lineSeparator();

        System.out.println("Имя: " + student.getFirstName() + s + "Отчество: " + student.getMiddleName()
                + s
                + "Фамилия: " + student.getLastName());
    }
}
