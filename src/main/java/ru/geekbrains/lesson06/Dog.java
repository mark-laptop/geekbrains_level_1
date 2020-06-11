package ru.geekbrains.lesson06;

public class Dog extends SwimAnimal {

    private static int dogCount;

    public Dog(String name) {
        this(name, 0, 0.0,0);
    }

    public Dog(String name, int runCapacity, double jumpCapacity) {
        this(name, runCapacity, jumpCapacity, 0);
    }

    public Dog(String name, int runCapacity, double jumpCapacity, int swimCapacity) {
        super(name, runCapacity, jumpCapacity, swimCapacity);
        ++dogCount;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public String toString() {
        return getName();
    }
}
