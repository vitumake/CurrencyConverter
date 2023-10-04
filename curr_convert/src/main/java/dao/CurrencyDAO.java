package dao;

import entity.Currency;
import datasource.DbConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDAO {
    
    private static Connection conn = DbConn.getInstance();
   
    public List<Currency> getCurrencies() {
        String sql = "SELECT * FROM currency";
        List<Currency> currencies = new ArrayList<Currency>();

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Currency currency = new Currency();
                currency.setCode(rs.getString("isocode"));
                currency.setRate(rs.getDouble("rate"));
                currencies.add(currency);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return currencies;
    }

    public void updateCurrencies(String isocode, double rate) {
        String sql = "REPLACE INTO currency (isocode, rate) VALUES (?, ?)";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, isocode);
            stmt.setDouble(2, rate);
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
