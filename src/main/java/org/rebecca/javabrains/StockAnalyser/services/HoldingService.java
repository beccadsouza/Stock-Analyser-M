package org.rebecca.javabrains.StockAnalyser.services;

import org.rebecca.javabrains.StockAnalyser.database.DBconnection;
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
            double totalMarketValue = 0.0;
            HoldingDetailsInvestor holdingDetailsInvestor;
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps1 = connection.prepareStatement(
                    "select c.company_id,c.name,c.ticker,c.sector,h.princ_amt,h.market_value,h.quarter_no,h.per_change,h.change_shares from holding as h inner join company as c on c.company_id = h.company_id where h.investor_id = '"+investorID+"' order by quarter_no desc;\n");
            ResultSet rs1 = ps1.executeQuery();
            PreparedStatement ps2 = connection.prepareStatement("select sum(market_value) from holding where investor_id='"+investorID+"';");
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next())
                totalMarketValue = rs2.getDouble(1);
            while (rs1.next()){
                holdingDetailsInvestor = new HoldingDetailsInvestor(rs1.getString(1),
                        rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getDouble(5),
                        rs1.getDouble(6),rs1.getLong(7),rs1.getDouble(8),rs1.getDouble(9),0);
                holdingDetailsInvestor.setPerPortfolio(holdingDetailsInvestor.getMarketValue()/totalMarketValue);
                list.add(holdingDetailsInvestor);
                System.out.println(holdingDetailsInvestor);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public List<HoldingDetailsCompany> getHoldingDetailsByCompany(String companyID, long quarter){
        List<HoldingDetailsCompany> list = new ArrayList<>();
        try{
            Connection connection = jdbcConnection.getConnnection();
            PreparedStatement ps1 = connection.prepareStatement("select i.investor_id,i.name,i.city,i.state,h.princ_amt,h.market_value,h.per_change,h.change_shares\n" +
                    "from investor as i\n" +
                    "inner join holding as h\n" +
                    "on h.investor_id = i.investor_id\n" +
                    "where h.company_id ='"+companyID+"' and quarter_no='"+quarter+"';");
            ResultSet rs1 = ps1.executeQuery();
            PreparedStatement ps2 = connection.prepareStatement("select sum(market_value) from holding where company_id='"+companyID+"' and quarter_no='"+quarter+"';");
            ResultSet rs2 = ps2.executeQuery();
            double totalMarketValue =0.0;
            if(rs2.next())
                totalMarketValue = rs2.getDouble(1);
            while(rs1.next()){
                HoldingDetailsCompany holdingDetailsCompany = new HoldingDetailsCompany(rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getDouble(5),
                        rs1.getDouble(6),rs1.getDouble(7),rs1.getDouble(8),0);
                holdingDetailsCompany.setPerPortfolio(holdingDetailsCompany.getMarketValue()/totalMarketValue);
                list.add(holdingDetailsCompany);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}