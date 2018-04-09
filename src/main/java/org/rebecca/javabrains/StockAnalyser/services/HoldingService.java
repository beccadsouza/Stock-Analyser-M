package org.rebecca.javabrains.StockAnalyser.services;

import org.rebecca.javabrains.StockAnalyser.database.DBconnection;
import org.rebecca.javabrains.StockAnalyser.model.Holding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoldingService {
    private DBconnection jdbcConnection = new DBconnection();
    public List<Holding> getAllHoldings(){
        List<Holding> list = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select * from holding");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Holding(rs.getString("investor_id"),rs.getString("company_id"),
                        rs.getDouble("per_change"),rs.getDouble("change_shares"),
                        rs.getDouble("princ_amt"),
                        rs.getDouble("market_value"),rs.getInt("quarter_no")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Holding> getHoldingsByInvestor(String investorID){
        List<Holding> list = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select * from holding where investor_id = '"+investorID+"'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Holding(rs.getString("investor_id"),rs.getString("company_id"),
                        rs.getDouble("per_change"),rs.getDouble("change_shares"),
                        rs.getDouble("princ_amt"),
                        rs.getDouble("market_value"),rs.getInt("quarter_no")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Holding> getHoldingsByCompany(String companyID){
        List<Holding> list = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select * from holding where company_id = '"+companyID+"'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Holding(rs.getString("investor_id"),rs.getString("company_id"),
                        rs.getDouble("per_change"),rs.getDouble("change_shares"),
                        rs.getDouble("princ_amt"),
                        rs.getDouble("market_value"),rs.getInt("quarter_no")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
