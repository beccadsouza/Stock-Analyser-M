package org.rebecca.javabrains.StockAnalyser.resources;

import org.rebecca.javabrains.StockAnalyser.model.Investor;
import org.rebecca.javabrains.StockAnalyser.services.InvestorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/investors")
@Produces(MediaType.APPLICATION_JSON)

public class InvestorResource {
    private InvestorService investorService = new InvestorService();
    @GET
    @Path("/{investorID}")
    public Investor getInvestor(@PathParam("investorID") String investorID) {
        return investorService.getInvestorByID(investorID);
    }
    @GET
    public List<Investor> getInvestors(@QueryParam("top") int top, @QueryParam("company") String company){
        if(top!=0)
            return investorService.getTopInvestors(top);
        if(!company.equals(""))
            return investorService.getInvestorsByCompany(company);
        return investorService.getAllInvestors();
    }
}
