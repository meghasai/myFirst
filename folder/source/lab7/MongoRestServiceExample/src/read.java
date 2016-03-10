

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/abc")
public class read extends HttpServlet {
	Double latit;
	Double longit;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public read() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			System.out.println("checking ...!!!!");
		System.out.println("is it ok?");
		PrintWriter wanttodisplayr=response.getWriter();
		response.setContentType("text/plain");
		String s=request.getParameter("username");
		
		JSONObject jobj=new JSONObject();
		jobj=getDetails2(s);
		wanttodisplayr.println("Country:"+jobj.getString("name"));
		wanttodisplayr.println("City Name:"+jobj.getString("cityname"));
		wanttodisplayr.println("Temperature:"+jobj.getDouble("Temp"));
				
		wanttodisplayr.println("Humidity: "+jobj.getDouble("Hum"));
		wanttodisplayr.println("");
		wanttodisplayr.println("");
		MongoClientURI mgul  = new MongoClientURI("mongodb://<amulya>:<amulya>@ds033297.mlab.com:33297/ase"); 
	    MongoClient details = new MongoClient(mgul);
	    DB db = details.getDB(mgul.getDatabase());
	    DBCollection detailsq = db.getCollection("asc");
	    String toinsert=jobj.toString();
	 // To insert data...................................................
		 	DBObject detailaobjects = (DBObject)JSON.parse(toinsert);
	  detailsq.insert(detailaobjects);
	  wanttodisplayr.println("Above Details are added successfully to the MONGODB");
	  
		}
		catch(Exception e)
		{
			
		}
		}
	public static String callURL(String myURL) {
		System.out.println("Requeted URL:" + myURL);
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if(bufferedReader!=null)
				{
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
		} 
 

		
		return sb.toString();
				}
	public JSONObject getDetails1(String s) throws JSONException
	{

		 String getIRL="http://maps.googleapis.com/maps/api/geocode/json?address="+s+"&sensor=true";
		 //System.out.println();
		 JSONObject jsonObject=new JSONObject(callURL(getIRL));
			JSONArray jsonArray= jsonObject.getJSONArray("results");
			JSONObject loc=jsonArray.getJSONObject(0).getJSONObject("geometry");
			JSONObject location=loc.getJSONObject("location");
			Double lat=location.getDouble("lat");
			latit=lat;
			Double lon=location.getDouble("lng");
			longit=lon;
			System.out.println(lat.toString()+lon.toString());
		String cityname=jsonArray.getJSONObject(0).getString("formatted_address");
		JSONObject sample=new JSONObject();
		sample.put("city", cityname);
		sample.put("lat",lat);
		sample.put("lon", lon);
		//System.out.println(cityname);
		return sample;
	}
	public JSONObject getDetails2(String city) throws JSONException
	{
		String url="http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=fe8bd79a2a1b8bf2f7abcc7bb4314b91";
		//System.out.println(callURL(url));
		JSONObject sample=new JSONObject(callURL(url));
		JSONArray weather=sample.getJSONArray("weather");
		String s=weather.getJSONObject(0).getString("description");
		JSONObject main=sample.getJSONObject("main");
		System.out.println("inside getdetails 2..................");
		Double temp=main.getDouble("temp");
		Double temp_min=main.getDouble("temp_min");
		Double temp_max=main.getDouble("temp_max");
		Double humidity=main.getDouble("humidity");
		System.out.println("'Before country................");
		//code addded newly.............................................
		JSONObject main1=sample.getJSONObject("sys");
		String country=main1.getString("country");
		System.out.println("Details country........"+country);
		String cityname=sample.getString("name");
		
		System.out.println("city name------------"+cityname);
		//System.out.println(temp.toString()+temp_min.toString()+temp_max.toString()+humidity.toString());
		JSONObject x=new JSONObject();
		x.put("desc", s);
		x.put("Temp", temp);
		x.put("Temp_min", temp_min);
		x.put("Temp_max", temp_max);
		x.put("Hum", humidity);
		x.put("name", country);
		x.put("cityname", cityname);
		System.out.println(x.toString());
		return x;
	}
	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(arg0, response);

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, HEAD, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");
	}
}