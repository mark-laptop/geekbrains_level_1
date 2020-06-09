package ru.geekbrains.lesson06;

public class Main {

    public static void main(String[] args) {

        Animal[] animals = new Animal[4];

        Animal cat = new Cat("Barsik", 200,2);
        animals[0] = cat;

        SwimAnimal dog = new Dog("Spyke", 500,0.4, 10);
        animals[1] = dog;

        SwimAnimal horse = new Horse("Turbo", 1500, 3, 100);
        animals[2] = horse;

        Animal bird = new Bird("Twitty", 5, 0.1);
        animals[3] = bird;

        System.out.println("===============================================");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего животных которые умеют плавать: " + SwimAnimal.getSwimAnimalCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего лошадей: " + Horse.getHorseCount());
        System.out.println("Всего птиц: " + Bird.getBirdCount());
        System.out.println("===============================================");

        for (Animal animal : animals) {
            if (animal instanceof SwimAnimal) {
                ((SwimAnimal) animal).swim(100);
            }
            animal.run(100);
            animal.jump(100);
        }
    }
}
