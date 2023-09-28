package controller;

import model.CConv;
import model.CCTable;
import view.ConvGui;

// Controller class that handles the logic of the application.
// This class is responsible for handling user input and updating the view accordingly.

public class ConvController {

    private ConvGui gui;
    private CConv converter = new CConv();
    private CCTable table = new CCTable();

    public ConvController(ConvGui gui) {
        this.gui = gui;
    }

    public Boolean updateRates() {
        Boolean resp = table.updateRates();
        System.out.println(resp?"Rates updated.":"Rates not updated.");
        return resp;
    }

    public void convert(String to, double amount, String from) {
        if(to==null||from==null||Double.isNaN(amount))
            gui.updateResult(0.0);
        else
            gui.updateResult(converter.convert(from, amount, to));
    }

    public String[] getCurrencies() {
        return table.getCurrencies();
    }

    public static void main(String[] args) {
        ConvGui.launch(ConvGui.class);
    }
}
