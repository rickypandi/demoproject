package full;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.server.spi.auth.common.User;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.cloud.Date;

@WebServlet(
    name = "Employee_Detail",
    urlPatterns = {"/employeecreate"}
)
 public class Createemp extends HttpServlet {
	        private static final long serialVersionUID = 1L;
	        HttpServletRequest request;
	        HttpServletRequest response;
	        private String fname;
	        private String lname;
	        private String emailid;
	        private String pkey;
			private String joindate;

 public void setEmailid(String emailid) 
          {
	          this.emailid = emailid;
          }
 public void setJoindate(String joindate) 
          {
	        this.joindate = joindate;
	      }

 public void setFname(String fname)
           {
				this.fname = fname;
			}

 public void setLname(String lname) 
           {
				this.lname = lname;
			}
 public String getPkey() 
            {
				UUID uuid=UUID.randomUUID();
				pkey = uuid.toString();
                 return pkey;
			}
 public void setPkey(String pkey) 
           {
		   this.pkey = pkey;
			}
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	     setFname( request.getParameter("fname"));
	     setLname(request.getParameter("lname"));
	     setEmailid(request.getParameter("email"));
	     setJoindate(request.getParameter("joindate"));
	     setPkey(getPkey());
	     
          if((fname!=null && lname!=null && emailid!=null && joindate!=null) && (!fname.isEmpty() 
		 && !lname.isEmpty() && !emailid.isEmpty() && !joindate.isEmpty())) 
    {
		   DatastoreService datastore=DatastoreServiceFactory.getDatastoreService();
		   Entity user=new Entity("employee_Detail",pkey);
		   
		   user.setProperty("emp_id",pkey);
		   user.setProperty("join_date",joindate);
		   user.setProperty("fname",fname);
		   user.setProperty("lname", lname);
		   user.setProperty("email", emailid);
		   datastore.put(user);
		   Key key=KeyFactory.createKey("employee Details",pkey);
		   PrintWriter out=response.getWriter();
		   out.println("Data inserted Succesfully");
	}
	     else
	 {
           PrintWriter em=response.getWriter();		 
		   em.println("Fill all the fields");
	 }
	     //response.setContentType("text/plain");
	     //response.setCharacterEncoding("UTF-8");
  }
}












/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();
	   joindate=dtf.format(now);*/
	  
	  


