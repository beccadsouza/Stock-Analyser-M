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

    public List<HeatMap> getHeatMaps(){
        List<HeatMap> list = new ArrayList<>();
        try{
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select c.name, sum(h.market_value)\n" +
                    "from holding as h inner join company c on h.company_id = c.company_id\n" +
                    "group by c.name order by sum(h.market_value) desc;");
            ResultSet rs = ps.executeQuery();
            HeatMap heatMap;
            while(rs.next()){
                heatMap = new HeatMap(rs.getString(1),rs.getDouble(2));
                list.add(heatMap);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

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
                    "on h.company_id = c.company_id where h.quarter_no = 3\n" +
                    "group by c.company_id,c.name,c.sector,c.ticker\n" +
                    "having sum(h.change_shares) >0\n" +
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
                    "on h.company_id = c.company_id where h.quarter_no = 3\n" +
                    "group by c.company_id,c.name,c.sector,c.ticker\n" +
                    "having sum(h.change_shares)<1000\n" +
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
                    "  where h.market_value = (select max(market_value) from holding where company_id = c.company_id)),h.company_id\n" +
                    "from company as c\n" +
                    "inner join holding as h \n" +
                    "on h.company_id = c.company_id where h.quarter_no = 3\n" +
                    "group by c.company_id,c.name,c.ticker,c.sector\n" +
                    "order by s1 desc; ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                consensus.add(new Consensus(rs.getString(7),rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getLong(4),rs.getString(6),rs.getDouble(5)));
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
            PreparedStatement ps = connection.prepareStatement("select h.quarter_no,sum(h.market_value) from holding as h inner join company as c on h.company_id = c.company_id where c.company_id = '"+companyID+"' group by h.quarter_no");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new QuarterDetails(rs.getLong(1),rs.getDouble(2)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public List<BarGraph> getBarGraph(String companyID){
        List<BarGraph> barGraphs = new ArrayList<>();
        try {
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select i.investor_id,\n" +
                    "  (select sum(h.market_value) from holding where quarter_no=1 and investor_id=i.investor_id and company_id = h.company_id) as Q1,\n" +
                    "  (select sum(h.market_value) from holding where quarter_no=2 and investor_id=i.investor_id and company_id = h.company_id) as Q2,\n" +
                    "  (select sum(h.market_value) from holding where quarter_no=3 and investor_id=i.investor_id and company_id = h.company_id) as Q3,\n" +
                    "  (select sum(h.market_value) from holding where quarter_no=4 and investor_id=i.investor_id and company_id = h.company_id) as Q4\n" +
                    "from holding as h\n" +
                    "inner join investor as i\n" +
                    "on i.investor_id = h.investor_id\n" +
                    "where h.company_id = '"+companyID+"'\n" +
                    "group by i.investor_id; ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                barGraphs.add(new BarGraph(rs.getString(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return barGraphs;
    }
}
