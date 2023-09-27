package model;

// Class that handles conversion of currencies.
// Due to data being collected from the NBP API, the conversion is done by first converting the currency to PLN and then to the desired currency.

public class CConv {
    private CCTable table = new CCTable();

    public double convert(String to, double amount, String from) {
        double pln = amount / table.getRate(from);
        return pln * table.getRate(to);
    }
}
