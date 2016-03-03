/**
 * @author ry6d3
 *
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/lbstokgs")
public class CtoFService {
	@GET
	@Produces("application/xml")
	public String convertCtoF() {
 
		Double lbs;
		Double kgs = 36.8;
		lbs = 0.453592*kgs;
 
		String result = "@Produces(\"application/xml\") Output: \n\nlbs to kgs Converter Output: \n\n" + lbs;
		return "<ctofservice>" + "<lbs>" + kgs + "</lbs>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}
 
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String convertCtoFfromInput(@PathParam("c") Double c) {
		Double lbs;
		Double kgs = c;
		lbs = kgs*0.453592;
 
		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + lbs;
		return "<lbstokgsservice>" + "<lbs>" + kgs + "</lbs>" + "<lbstokgsoutput>" + result + "</lbstokgsoutput>" + "</lbstokgsservice>";
	}
	public  long LbToKg(long lb){
		  
		  long kg= (long) (lb*0.453592);
		 return kg;  
		  
		  
	  }
}