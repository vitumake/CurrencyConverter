package model;

import java.util.ArrayList;
import dao.CurrencyDAO;
import entity.Currency;

public class CCTable {
    private static ArrayList<Currency> currencies = new ArrayList<Currency>();
    private static CurrencyDAO dao = new CurrencyDAO();

    public CCTable() {
        updateTable();
    }

    public static void updateTable() {
        CCTable.currencies = (ArrayList<Currency>) dao.getCurrencies();
    }

    public double getRate(String code) {
        for(Currency currency : CCTable.currencies) {
            if(currency.getCode().equals(code)) {
                return currency.getRate();
            }
        }
        return 0;
    }

    public String[] getISOArr() {
        String[] codes = new String[CCTable.currencies.size()];
        for(int i=0; i<CCTable.currencies.size(); i++) {
            codes[i] = CCTable.currencies.get(i).getCode();
        }
        return codes;
    }
}
