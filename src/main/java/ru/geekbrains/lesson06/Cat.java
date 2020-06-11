package ru.geekbrains.lesson06;

public class Cat extends Animal {

    private static int catCount;

    public Cat(String name) {
        this(name, 0, 0.0);
    }

    public Cat(String name, int runCapacity, double jumpCapacity) {
        super(name, runCapacity, jumpCapacity);
        ++catCount;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public String toString() {
        return getName();
    }
}
