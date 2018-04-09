package org.rebecca.javabrains.StockAnalyser.services;

import org.rebecca.javabrains.StockAnalyser.database.DBconnection;
import org.rebecca.javabrains.StockAnalyser.model.Company;
import org.rebecca.javabrains.StockAnalyser.model.Picks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyService {
    private DBconnection jdbcConnection = new DBconnection();

    public Company getCompanyByID(String companyID){
        Company company = new Company();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select * from company "+ "where company_id = '"+companyID+"'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                company = new Company(rs.getString("description"),rs.getString("sector"),
                        rs.getString("address"),rs.getString("name"),rs.getString("company_id"),
                        rs.getString("city"),rs.getString("state"),rs.getString("ticker"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    public List<Picks> getHotpicks(){
        List<Picks> hotpicks = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select 4/2 ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                hotpicks.add(new Picks());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  hotpicks;
    }
    public List<Picks> getColdpicks(){
        List<Picks> coldpicks = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select 4/2 ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                coldpicks.add(new Picks());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  coldpicks;
    }
    public List<Picks> getConsensus(){
        List<Picks> consensus = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select 4/2 ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                consensus.add(new Picks());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  consensus;
    }
}
