
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


@WebServlet("/display1")
public class address extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public address() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("check the post method");
		PrintWriter var=response.getWriter();
		response.setContentType("text/plain");
		MongoClientURI uri  = new MongoClientURI("mongodb://<amulya111>:<amulya121>@ds033297.mlab.com:33297/ase"); 
	    MongoClient client = new MongoClient(uri);
	    DB db = client.getDB(uri.getDatabase());
	    System.out.println("Sysy"+db.getName());
	    DBCollection users = db.getCollection("ase");
	    //Adding new code..................................................
	    BasicDBObject query = new BasicDBObject();
	    BasicDBObject field = new BasicDBObject();
	    field.put("name", "Madison");
	    DBCursor cursor = db.getCollection("ase").find(query,field);
	    var.println("all the cities list");
	    int i=1;
	    while (cursor.hasNext()) {
	        BasicDBObject obj = (BasicDBObject) cursor.next();
	        System.out.println("Country "+obj.getString("name"));
	        var.println(i+""+""+obj.getString("cityname"));
	        i++;
	        
	      
	    }
	    
		System.out.println("checking the condition");
	}
	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse response)
			throws ServletException, IOException {
		super.doOptions(arg0, response);

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, HEAD, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");
	}

}
