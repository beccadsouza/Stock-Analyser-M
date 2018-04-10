package org.rebecca.javabrains.StockAnalyser.services;

import org.rebecca.javabrains.StockAnalyser.database.DBconnection;
import org.rebecca.javabrains.StockAnalyser.model.Holding;
import org.rebecca.javabrains.StockAnalyser.model.HoldingDetailsCompany;
import org.rebecca.javabrains.StockAnalyser.model.HoldingDetailsInvestor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoldingService {
    private DBconnection jdbcConnection = new DBconnection();

    public List<HoldingDetailsInvestor> getHoldingDetailsByInvestor(String investorID){
        List<HoldingDetailsInvestor> list = new ArrayList<>();
        try{
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select 4/2");
            //ResultSet rs = ps.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public List<HoldingDetailsCompany> getHoldingDetailsByCompany(String companyID, long quarter){
        List<HoldingDetailsCompany> list = new ArrayList<>();
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
