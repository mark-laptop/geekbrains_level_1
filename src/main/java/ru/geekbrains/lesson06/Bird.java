package ru.geekbrains.lesson06;

public class Bird extends Animal {

    private static int birdCount;

    public Bird(String name) {
        this(name, 0, 0.0);
    }

    public Bird(String name, int runCapacity, double jumpCapacity) {
        super(name, runCapacity, jumpCapacity);
        ++birdCount;
    }

    public static int getBirdCount() {
        return birdCount;
    }

    @Override
    public String toString() {
        return getName();
    }

}
