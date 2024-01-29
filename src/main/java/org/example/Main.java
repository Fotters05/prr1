package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Здравствуйте!");

        System.out.println("Выберите программу:");
        System.out.println("1. Ввод персональных данных");
        System.out.println("2. Расчет площади и периметра");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                inputPersonalData(scanner);
                break;
            case 2:
                calculateAreaAndPerimeter(scanner);
                break;
            default:
                System.out.println("Некорректный выбор программы.");
        }

        scanner.close();
    }

    private static void inputPersonalData(Scanner scanner) {
        System.out.print("Введите ваше имя: ");
        String firstName = scanner.next();

        System.out.print("Введите вашу фамилию: ");
        String lastName = scanner.next();

        System.out.print("Введите дату рождения (в формате ГГГГ-ММ-ДД): ");
        String birthDateString = scanner.next();
        LocalDate birthDate = LocalDate.parse(birthDateString, DateTimeFormatter.ISO_DATE);

        LocalDate currentDate = LocalDate.now();
        int age = currentDate.minusYears(birthDate.getYear()).getYear();

        System.out.println("Ваши персональные данные:");
        System.out.printf("Имя: %s\n", firstName);
        System.out.printf("Фамилия: %s\n", lastName);
        System.out.printf("Возраст: %d лет\n", age);

        if (age >= 18) {
            System.out.println("Вам 18 или >");
        } else {
            System.out.println("Вам < 18");
        }
    }

    private static void calculateAreaAndPerimeter(Scanner scanner) {
        System.out.print("Введите длину прямоугольника: ");
        double length = scanner.nextDouble();

        System.out.print("Введите ширину прямоугольника: ");
        double width = scanner.nextDouble();

        double area = length * width;
        double perimeter = 2 * (length + width);

        System.out.printf("Площадь прямоугольника: %.2f\n", area);
        System.out.printf("Периметр прямоугольника: %.2f\n", perimeter);
    }
}
