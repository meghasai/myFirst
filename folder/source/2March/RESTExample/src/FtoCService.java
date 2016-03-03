/**
 * @author ry6d3
 *
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
 
@Path("/kgstolbs")
public class FtoCService {
 
	  @GET
	  @Produces("application/json")
	  public Response convertFtoC() throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		Double lbs = 98.24;
		Double kgs;
		kgs = (lbs)*2.2045; 
		jsonObject.put("F Value", lbs); 
		jsonObject.put("C Value", kgs);
 
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
 
	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		Double kgs;
		kgs =  (f)*2.2045; 
		jsonObject.put("kg Value", f); 
		jsonObject.put(" lbs Value", kgs);
 
		String result = "@Produces(\"application/json\") Output: \n\nkgs to lbs Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
  
	  public  long kgToLb(long kg){
		  
		  long lb= (long) (kg*2.2045);
		 return lb;  
		  
		  
	  }
	  
}