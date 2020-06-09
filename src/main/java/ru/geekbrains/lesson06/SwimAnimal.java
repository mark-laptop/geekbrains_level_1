package ru.geekbrains.lesson06;

public abstract class SwimAnimal extends Animal {

    private static int swimAnimalCount;
    private int swimCapacity;

    public SwimAnimal(String name) {
        this(name, 0,0.0, 0);
    }

    public SwimAnimal(String name, int runCapacity, double jumpCapacity) {
        this(name, runCapacity,jumpCapacity, 0);
    }

    public SwimAnimal(String name, int runCapacity, double jumpCapacity, int swimCapacity) {
        super(name, runCapacity, jumpCapacity);
        this.swimCapacity = swimCapacity;
        ++swimAnimalCount;
    }

    public static int getSwimAnimalCount() {
        return swimAnimalCount;
    }

    public int getSwimCapacity() {
        return swimCapacity;
    }

    public void setSwimCapacity(int swimCapacity) {
        this.swimCapacity = swimCapacity;
    }

    public void swim(int swimCapacity) {
        if (swimCapacity <= this.getSwimCapacity())
            System.out.println(this + " проплыл: " + swimCapacity + " м.");
        else
            System.out.println(this + " не смог проплыть на : " + swimCapacity + " м.");
    }
}
