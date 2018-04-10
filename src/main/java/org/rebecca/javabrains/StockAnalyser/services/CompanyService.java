package org.rebecca.javabrains.StockAnalyser.services;

import org.rebecca.javabrains.StockAnalyser.database.DBconnection;
import org.rebecca.javabrains.StockAnalyser.model.*;

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

    public List<Picks> getHotPicks(){
        List<Picks> hotpicks = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select c.company_id,c.name,c.sector,c.ticker,count(h.investor_id) as s1,sum(h.market_value) as s2,sum(h.princ_amt) as s3,sum(h.change_shares) as s4,\n" +
                    "  (select i.name from investor as i inner join holding as h on h.investor_id = i.investor_id\n" +
                    "  where h.market_value = (select max(market_value) from holding where company_id = c.company_id)) \n" +
                    "from company as c\n" +
                    "inner join holding as h\n" +
                    "on h.company_id = c.company_id\n" +
                    "where h.change_shares >0\n" +
                    "group by c.company_id,c.name,c.sector,c.ticker\n" +
                    "order by s4 desc;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                hotpicks.add(new Picks(rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(3),
                        rs.getLong(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getString(9)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  hotpicks;
    }
    public List<Picks> getColdPicks(){
        List<Picks> coldpicks = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select c.company_id,c.name,c.sector,c.ticker,count(h.investor_id) as s1,sum(h.market_value) as s2,sum(h.princ_amt) as s3,sum(h.change_shares) as s4,\n" +
                    "  (select i.name from investor as i inner join holding as h on h.investor_id = i.investor_id\n" +
                    "  where h.market_value = (select max(market_value) from holding where company_id = c.company_id)) \n" +
                    "from company as c\n" +
                    "inner join holding as h\n" +
                    "on h.company_id = c.company_id\n" +
                    "where h.change_shares <0\n" +
                    "group by c.company_id,c.name,c.sector,c.ticker\n" +
                    "order by s4;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                coldpicks.add(new Picks(rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(3),
                        rs.getLong(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getString(9)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coldpicks;
    }
    public List<Consensus> getConsensus(){
        List<Consensus> consensus = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select c.name,c.ticker,c.sector,count(h.investor_id) as s1,sum(h.market_value) as s2,\n" +
                    "  (select i.name from investor as i inner join holding as h on h.investor_id = i.investor_id\n" +
                    "  where h.market_value = (select max(market_value) from holding where company_id = c.company_id))\n" +
                    "from company as c\n" +
                    "inner join holding as h\n" +
                    "on h.company_id = c.company_id\n" +
                    "group by c.company_id,c.name,c.ticker,c.sector\n" +
                    "order by s1 desc; ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                consensus.add(new Consensus(rs.getString(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(6),rs.getDouble(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consensus;
    }
    public List<QuarterDetails> getQuarterDetails(String companyID){
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
    public List<BarGraph> getBarGraph(){
        List<BarGraph> barGraphs = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select 4/2 ");
            //ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return barGraphs;
    }
}
