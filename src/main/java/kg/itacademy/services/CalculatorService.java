package kg.itacademy.services;
import kg.itacademy.model.Data;
import kg.itacademy.model.Result;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

// URI:
// contextPath/servletPath/categories
@Path("/calculate")
public class CalculatorService {
    @Path("/{num1}&{action}&{num2}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Result calculate(@PathParam("num1") Integer num1,@PathParam("action") String action, @PathParam("num2") Integer num2 ) {
        double result = 0;
        boolean isSuccess = true;
        String errorMessage = "";
        switch (action){
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "division": result = (double)num1 / num2; break;
            default: isSuccess = false; errorMessage = "Invalid input";
        }
        return new Result(isSuccess,errorMessage, new Data("" + num1 + " " + action + " " + num2, result));
    }
}
