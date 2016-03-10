
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
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * Servlet implementation class Update_Data
 */
@WebServlet("/update1")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String place=request.getParameter("city");
		String weathers=request.getParameter("climate");
		PrintWriter todisplay=response.getWriter();
		response.setContentType("text/plain");
		MongoClientURI mgcl  = new MongoClientURI("mongodb://<amulya>:<amulya>@ds033297.mlab.com:33297/ase"); 
	    MongoClient abcdsss = new MongoClient(mgcl);
	    DB dataamulya = abcdsss.getDB(mgcl.getDatabase());
	    
	    DBCollection abcd = dataamulya.getCollection("asc");
	   
	    BasicDBObject bascobj = new BasicDBObject();
	
	    bascobj.append("$set", new BasicDBObject().append("description", weathers));
		
		BasicDBObject searchQuery = new BasicDBObject().append("cityname", place);

	    abcd.update(searchQuery, bascobj);
		
	}

}
