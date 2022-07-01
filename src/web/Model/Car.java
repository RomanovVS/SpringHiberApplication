package web.Model;

public class Car {
    private String model;
    private String series;
    private int year;

    public Car(String model, String series, int year) {
        this.model = model;
        this.series = series;
        this.year = year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public String getSeries() {
        return series;
    }

    public int getYear() {
        return year;
    }
}
