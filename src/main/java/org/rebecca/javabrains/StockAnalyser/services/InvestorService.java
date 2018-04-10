package org.rebecca.javabrains.StockAnalyser.services;

import org.rebecca.javabrains.StockAnalyser.database.DBconnection;
import org.rebecca.javabrains.StockAnalyser.model.Investor;
import org.rebecca.javabrains.StockAnalyser.model.QuarterDetails;
import org.rebecca.javabrains.StockAnalyser.model.Scoreboard;
import org.rebecca.javabrains.StockAnalyser.model.SectorDetails;

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

    public List<Scoreboard> getScoreBoard(){
        List<Scoreboard> list = new ArrayList<>();
        try{
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select 4/2");
            //ResultSet rs = ps.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<SectorDetails> getSectorDetails(String investorID){
        List<SectorDetails> list = new ArrayList<>();
        try{
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select 4/2");
            //ResultSet rs = ps.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<QuarterDetails> getQuarterDetails(String investorID){
        List<QuarterDetails> list = new ArrayList<>();
        try{
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select 4/2");
            //ResultSet rs = ps.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
