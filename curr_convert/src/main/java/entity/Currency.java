package entity;

public class Currency {
    private String code;
    private double rate;

    public Currency() {
    }

    public Currency(String code, double rate) {
        this.code = code;
        this.rate = rate;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCode() {
        return this.code;
    }

    public double getRate() {
        return this.rate;
    }
}