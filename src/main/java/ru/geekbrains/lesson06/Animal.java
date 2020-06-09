package ru.geekbrains.lesson06;

public abstract class Animal {

    private static int animalCount;
    private int runCapacity;
    private double jumpCapacity;
    private String name;

    public Animal(String name) {
        this(name, 0, 0.0);
    }

    public Animal(String name, int runCapacity, double jumpCapacity) {
        this.name = name;
        this.runCapacity = runCapacity;
        this.jumpCapacity = jumpCapacity;
        ++animalCount;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public int getRunCapacity() {
        return runCapacity;
    }

    public double getJumpCapacity() {
        return jumpCapacity;
    }

    public void setRunCapacity(int runCapacity) {
        this.runCapacity = runCapacity;
    }

    public void setJumpCapacity(double jumpCapacity) {
        this.jumpCapacity = jumpCapacity;
    }

    public String getName() {
        return name;
    }

    public void run(int runCapacity) {
        if (runCapacity <= this.getRunCapacity())
            System.out.println(this + " пробежал: " + runCapacity + " м.");
        else
            System.out.println(this + " не смог пробежать: " + runCapacity + " м.");
    }

    public void jump(int jumpCapacity) {
        if (jumpCapacity <= this.getJumpCapacity())
            System.out.println(this + " прыгнул: " + jumpCapacity + " м.");
        else
            System.out.println(this + " не смог прыгнуть на : " + jumpCapacity + " м.");
    }
}
