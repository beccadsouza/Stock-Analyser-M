package org.rebecca.javabrains.StockAnalyser.resources;

import org.rebecca.javabrains.StockAnalyser.model.Holding;
import org.rebecca.javabrains.StockAnalyser.services.HoldingService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/holdings")
@Produces(MediaType.APPLICATION_JSON)
public class HoldingResource {
    HoldingService holdingService = new HoldingService();

    @GET
    public List<Holding> getHoldings(@QueryParam("company") String company,@QueryParam("investor") String investor){
        if(company!=null)
            return holdingService.getHoldingsByCompany(company);
        if(investor!=null)
            return holdingService.getHoldingsByInvestor(investor);
        return holdingService.getAllHoldings();
    }
}
