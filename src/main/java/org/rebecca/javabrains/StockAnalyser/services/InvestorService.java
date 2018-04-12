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
                investor = new Investor(rs.getString(1),rs.getString(2),
                         rs.getString(3), rs.getString(4)
                        ,rs.getString(5),rs.getString(6), rs.getString(7),
                        rs.getDouble(8));
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
            PreparedStatement ps = connection.prepareStatement("select i.investor_id,i.name,i.city,i.state,sum(h.market_value),\n" +
                    "(select company_id from holding where investor_id = h.investor_id and market_value = max(h.market_value))\n" +
                    "from investor as i inner join holding as h\n" +
                    "where i.investor_id = h.investor_id and h.quarter_no = 4\n" +
                    "group by i.investor_id,i.name,i.city,i.state order by sum(h.market_value) desc");
            ResultSet rs = ps.executeQuery();
            long rank = 0;
            while (rs.next()){
                list.add(new Scoreboard(rs.getString(1),++rank,rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getDouble(5),rs.getString(6)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<SectorDetails> getSectorDetails(String investorID){
        List<SectorDetails> list = new ArrayList<>();
        try{
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select t.sector, sum(t.market_value) from\n" +
                    "(select * from holding natural join company) as t\n" +
                    "where t.investor_id = '"+investorID+"'\n" +
                    "group by t.sector;");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                list.add(new SectorDetails(rs.getString(1),rs.getDouble(2)));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<QuarterDetails> getQuarterDetails(String investorID){
        List<QuarterDetails> list = new ArrayList<>();
        try{
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps = connection.prepareStatement("select h.quarter_no,sum(h.market_value)\n" +
                    "from holding as h\n" +
                    "  inner join investor as i\n" +
                    "  on h.investor_id = i.investor_id\n" +
                    "where i.investor_id  = '"+investorID+"'\n" +
                    "group by h.quarter_no;");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                list.add(new QuarterDetails(rs.getLong(1),rs.getDouble(2)));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
