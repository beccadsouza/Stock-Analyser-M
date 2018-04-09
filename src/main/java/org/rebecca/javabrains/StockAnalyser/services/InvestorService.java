package org.rebecca.javabrains.StockAnalyser.services;

import org.rebecca.javabrains.StockAnalyser.database.DBconnection;
import org.rebecca.javabrains.StockAnalyser.model.Investor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvestorService {
    private DBconnection  jdbcConnection = new DBconnection();
    public Investor getInvestorByID(String investorID){
        Investor investor = new Investor();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select * from investor "+ "where investor_id = '"+investorID+"'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                investor = new Investor(rs.getString("description"),rs.getString("address"),
                        rs.getInt("no_clients"), rs.getString("type"), rs.getString("state")
                        ,rs.getString("city"),rs.getString("name"), rs.getString("investor_id"),
                        rs.getString("registration"),rs.getDouble("holding_conc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return investor;
    }

    public List<Investor> getTopInvestors(int top){
        List<Investor> list = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement
                    ("select * from investor order by holding_conc limit "+top+"");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Investor(rs.getString("description"),rs.getString("address"),
                        rs.getInt("no_clients"), rs.getString("type"), rs.getString("state")
                        ,rs.getString("city"),rs.getString("name"), rs.getString("investor_id"),
                        rs.getString("registration"),rs.getDouble("holding_conc")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Investor> getInvestorsByCompany(String companyName){
        List<Investor> list = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select * from investor as i inner join holding as h on i.investor_id = h.investor_id inner join company as c on c.company_id = h.company_id where c.name = '"+companyName+"'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Investor(rs.getString("description"),rs.getString("address"),
                        rs.getInt("no_clients"), rs.getString("type"), rs.getString("state")
                        ,rs.getString("city"),rs.getString("name"), rs.getString("investor_id"),
                        rs.getString("registration"),rs.getDouble("holding_conc")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Investor> getAllInvestors(){
        List<Investor> list = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select * from investor");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Investor(rs.getString("description"),rs.getString("address"),
                        rs.getInt("no_clients"), rs.getString("type"), rs.getString("state")
                        ,rs.getString("city"),rs.getString("name"), rs.getString("investor_id"),
                        rs.getString("registration"),rs.getDouble("holding_conc")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
