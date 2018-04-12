package org.rebecca.javabrains.StockAnalyser.resources;

import org.rebecca.javabrains.StockAnalyser.model.*;
import org.rebecca.javabrains.StockAnalyser.services.CompanyService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/company")
@Produces(MediaType.APPLICATION_JSON)
public class CompanyResource {
    private CompanyService companyService = new CompanyService();

    @GET
    @Path("/{companyID}")
    public Company getCompany(@PathParam("companyID") String companyID){
        return companyService.getCompanyByID(companyID);
    }
    @GET
    @Path("/quarters/{companyID}")
    public List<QuarterDetails> getQuarterDetails(@PathParam("companyID") String companyID){
        return companyService.getQuarterDetails(companyID);
    }
    @GET
    @Path("/consensus")
    public List<Consensus> getConsensus(){
        return companyService.getConsensus();
    }
    @GET
    @Path("/coldpicks")
    public List<Picks> getColdPicks(){
        return companyService.getColdPicks();
    }
    @GET
    @Path("/hotpicks")
    public List<Picks> getHotPicks(){
        return companyService.getHotPicks();
    }
    @GET
    @Path("/heatmaps")
    public List<HeatMap> getHeatMaps(){
        return companyService.getHeatMaps();
    }
    @GET
    @Path("/bargraph/{companyID}")
    public List<BarGraph> getBarGraph(@PathParam("companyID") String companyID){
        return companyService.getBarGraph(companyID);
    }
}
