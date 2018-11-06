package model;

public class Category {
    private String name;
    private int min;
    private int max;

    public Category(String name, int min, int max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public String getMinName() {
        return min + " " + name(min);
    }

    public String name(int n) {
        return n == 1 ? name : (name + "s");
    }

    @Override
    public String toString() {
        return name;
    }
}
