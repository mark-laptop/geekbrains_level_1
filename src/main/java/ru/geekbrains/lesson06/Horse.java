package ru.geekbrains.lesson06;

public class Horse extends SwimAnimal {

    private static int horseCount;

    public Horse(String name) {
        this(name, 0, 0.0, 0);
    }

    public Horse(String name, int runCapacity, double jumpCapacity) {
        this(name, runCapacity, jumpCapacity, 0);
    }

    public Horse(String name, int runCapacity, double jumpCapacity, int swimCapacity) {
        super(name, runCapacity, jumpCapacity, swimCapacity);
        ++horseCount;
    }

    public static int getHorseCount() {
        return horseCount;
    }

    @Override
    public String toString() {
        return getName();
    }
}
