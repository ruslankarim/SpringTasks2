package model;

public class Car {
    private String name;
    private int series;
    private int number;

    public Car(String name, int series, int number) {
        this.name = name;
        this.series = series;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
