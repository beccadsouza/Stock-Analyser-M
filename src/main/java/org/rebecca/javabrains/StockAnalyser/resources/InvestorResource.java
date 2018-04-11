package org.rebecca.javabrains.StockAnalyser.resources;

import org.rebecca.javabrains.StockAnalyser.model.Investor;
import org.rebecca.javabrains.StockAnalyser.model.QuarterDetails;
import org.rebecca.javabrains.StockAnalyser.model.Scoreboard;
import org.rebecca.javabrains.StockAnalyser.model.SectorDetails;
import org.rebecca.javabrains.StockAnalyser.services.InvestorService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/investors")
@Produces(MediaType.APPLICATION_JSON)


public class InvestorResource {
    private InvestorService investorService = new InvestorService();
    @GET
    @Path("/portfolio/{investorID}")
    public Investor getInvestor(@PathParam("investorID") String investorID) {
        return investorService.getInvestorByID(investorID);
    }
    @GET
    @Path("/scoreboard")
    public List<Scoreboard> getScoreBoard(){
        return investorService.getScoreBoard();
    }

    @GET
    @Path("/sectors/{investorID}")
    public List<SectorDetails> getSectorDetails(@PathParam("investorID") String investorID){
        return investorService.getSectorDetails(investorID);
    }
    @GET
    @Path("/quarters/{investorID}")
    public List<QuarterDetails> getQuarterDetails(@PathParam("investorID") String investorID){
        return investorService.getQuarterDetails(investorID);
    }
}
