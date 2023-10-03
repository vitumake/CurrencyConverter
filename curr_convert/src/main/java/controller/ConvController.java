package controller;

import model.CConv;
import model.ApiDataHandler;
import model.CCTable;
import view.ConvGui;
import java.util.ArrayList;
import dao.CurrencyDAO;
import entity.Currency;

// Controller class that handles the logic of the application.
// This class is responsible for handling user input and updating the view accordingly.

public class ConvController {

    private ConvGui gui;
    private CConv converter = new CConv();
    private CCTable table = new CCTable();
    private ApiDataHandler api = new ApiDataHandler();
    private CurrencyDAO dao = new CurrencyDAO();

    public ConvController(ConvGui gui) {
        this.gui = gui;
    }

    public Boolean updateRates() {
        
        ArrayList<Currency> currList = (ArrayList<Currency>) api.retrieveRates();
        Boolean resp = currList==null?false:true;
        if(resp) {
            for(Currency currency : currList) {
                dao.updateCurrencies(currency.getCode(), currency.getRate());
            }
            CCTable.updateTable();
        }
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
        return table.getISOArr();
    }

    public static void main(String[] args) {
        ConvGui.launch(ConvGui.class);
    }
}
