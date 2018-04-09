package org.rebecca.javabrains.StockAnalyser.resources;

import org.rebecca.javabrains.StockAnalyser.model.Company;
import org.rebecca.javabrains.StockAnalyser.services.CompanyService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/companies")
@Produces(MediaType.APPLICATION_JSON)
public class CompanyResource {
    private CompanyService companyService = new CompanyService();

    @GET
    @Path("/{companyID}")
    public Company getCompany(@PathParam("companyID") String company){
        return companyService.getCompanyByID(company);
    }
}
