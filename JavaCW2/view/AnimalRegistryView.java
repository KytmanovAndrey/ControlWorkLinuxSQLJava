package view;

import model.Animal;
import service.AnimalRegistryService;

import java.time.LocalDate;
import java.util.Scanner;

public class AnimalRegistryView {
    private final AnimalRegistryService animalRegistryService;

    public AnimalRegistryView(AnimalRegistryService animalRegistryService) {
        this.animalRegistryService = animalRegistryService;
    }

    public void showUI() {
        Scanner scanner = new Scanner(System.in, "ibm866");
        String cmd = "";
        while (!cmd.equals("6")) {
            System.out.println("\nМеню:\n" +
                    "1. Добавить новое животное в реестр\n" +
                    "2. Вывести список команд, которые может выполнять выбранное животное\n" +
                    "3. Обучить животное командам\n" +
                    "4. Вывести список животных по дате рождения\n" +
                    "5. Вывести на экран общее количество созданных животных выбранного типа\n" +
                    "6. Выход\n" +
                    "Введите номер операции: ");
            cmd = scanner.next();
            switch (cmd) {
                case "1":
                    LocalDate dateOfBirth = null;
                    System.out.println("Введите имя животного: ");
                    String name = scanner.next();
                    System.out.println("Введите дату рождения животного (YYYY-MM-DD): ");
                    boolean flag = true;
                    while (flag) {
                        try {
                            dateOfBirth = LocalDate.parse(scanner.next());
                            flag = false;
                        } catch (Exception e) {
                            System.out.println("Ошибка. Введите дату рождения животного в формате YYYY-MM-DD: ");
                        }
                    }
                    System.out.println("Введите тип животного (Dog, Cat, Hamster, Horse, Camel, Donkey): ");
                    String type = scanner.next();
                    while (!type.equals("Dog") && !type.equals("Cat") && !type.equals("Hamster") &&
                            !type.equals("Horse") && !type.equals("Camel") && !type.equals("Donkey")  ) {
                        System.out.println("Некорректный ввод, проверьте регистр букв");
                        System.out.print("Введите тип животного (Dog, Cat, Hamster, Horse, Camel, Donkey): ");
                        type = scanner.next();
                    }
                    animalRegistryService.createAnimal(name, type, dateOfBirth);
                    break;
                case "2":
                    for (Animal animal : animalRegistryService.getAnimals() ) {
                        System.out.println(animal);
                    }
                    System.out.println("Введите id животного: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Некорректный ввод");
                        System.out.print("Введите id животного: ");
                        scanner.next();
                    }
                    int id = scanner.nextInt();
                    for (Animal animal : animalRegistryService.getAnimals() ) {
                        if (animal.getId() == id) {
                            System.out.println(animal.getCommands());
                        }
                    }
                    break;
                case "3":
                    for (Animal animal : animalRegistryService.getAnimals() ) {
                        System.out.println(animal);
                    }
                    System.out.println("\nВведите id животного: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Некорректный ввод");
                        System.out.print("Введите id животного: ");
                        scanner.next();
                    }
                    int id2 = scanner.nextInt();
                    System.out.print("Введите все команды животного: ");
                    for (Animal animal : animalRegistryService.getAnimals() ) {
                        if (animal.getId() == id2) {
                            animal.setCommands(scanner.next());
                        }
                    }
                    break;
                case "4":
                    LocalDate dateOfBirth2 = null;
                    System.out.println("Введите дату рождения животного (YYYY-MM-DD): ");
                    boolean flag2 = true;
                    while (flag2) {
                        try {
                            dateOfBirth2 = LocalDate.parse(scanner.next());
                            flag2 = false;
                        } catch (Exception e) {
                            System.out.println("Ошибка. Введите дату рождения животного в формате YYYY-MM-DD: ");
                        }
                    }
                    for (Animal animal : animalRegistryService.getAnimals() ) {
                        if (animal.getDateOfBirth().equals(dateOfBirth2)) {
                            System.out.println(animal);
                        }
                    }
                    break;
                case "5":
                    int count = 0;
                    System.out.println("Введите тип животного (Dog, Cat, Hamster, Horse, Camel, Donkey): ");
                    String type2 = scanner.next();
                    for (Animal animal : animalRegistryService.getAnimals() ) {
                        if (animal.getType().equals(type2)) {
                            System.out.println(animal);
                            count ++;
                        }
                    }
                    System.out.println("Общее количество найденных животных: " + count);
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
        }
    }
}
