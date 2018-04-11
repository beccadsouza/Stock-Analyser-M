package org.rebecca.javabrains.StockAnalyser.resources;

import org.rebecca.javabrains.StockAnalyser.model.HoldingDetailsCompany;
import org.rebecca.javabrains.StockAnalyser.model.HoldingDetailsInvestor;
import org.rebecca.javabrains.StockAnalyser.services.HoldingService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/holdings")
@Produces(MediaType.APPLICATION_JSON)
public class HoldingResource {
    private HoldingService holdingService = new HoldingService();

    @GET
    @Path("/{investorID}")
    public List<HoldingDetailsInvestor> getHoldingDetailsByInvestor(@PathParam("investorID") String investorID){
        return holdingService.getHoldingDetailsByInvestor(investorID);
    }

    @GET
    public List<HoldingDetailsCompany> getHoldingDetailsByCompany(@QueryParam("company") String companyID,
                                                                  @QueryParam("quarter") long quarter){
        return holdingService.getHoldingDetailsByCompany(companyID,quarter);
    }
}
