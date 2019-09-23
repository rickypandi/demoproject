package com.app.full;

import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.PrintWriter;
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
    name = "Employee_Details",
    urlPatterns = {"/employeecreate"}
)
public class Createemp extends HttpServlet {
	public DatastoreService datastore;
	public Entity user;
	public String fname;
	public String lname;
	public String emailid;
	public UUID uuid;
	public String pkey;
	public Key key;
	
  
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  datastore=DatastoreServiceFactory.getDatastoreService();
	 //String user_input=request.getParameter("email");
       fname=request.getParameter("fname");
	   lname=request.getParameter("lname");
	   emailid=request.getParameter("email");
	  
	UUID uuid=UUID.randomUUID();
	   pkey=uuid.toString();
	  user=new Entity("employee Details",pkey);
	 user.setProperty("emp_id",pkey);
	  user.setProperty("fname",fname);
	  user.setProperty("lname", lname);
	  user.setProperty("email", emailid);
	 datastore.put(user);
	  PrintWriter out=response.getWriter();
	  key=KeyFactory.createKey("employee Details",pkey);

	  out.println("Data inserted Succesfully");
	  response.setContentType("text/plain");
	  response.setCharacterEncoding("UTF-8");
  }
}
	  
	  //Query que=new Query("employee Details");
	  //PreparedQuery pq=ds.prepare(que);
	  /*try {
	   Entity employee1=null;
			employee1=ds.get(k);
			System.out.println(employee1);
		} catch (EntityNotFoundException e) {
			System.out.println("Data not found");
		}*/
	  //to create 2 or more entity
	  /* Entity e1=new Entity("emp1");
	  Entity e2=new Entity("emp2");
	  Entity e3=new Entity("emp3");
	   List<Entity> e4= Arrays.asList(e1,e2,e3);
	   */
	  /* Key k = KeyFactory.createKey("employee Details",input);

	   
	  
	  
	  
	  System.out.println(k);
	  PrintWriter out=response.getWriter();
		try {
			employee1 = ds.get(k);
			out.println("The Details Matched with Your Input is "+"\n"+employee1);
		} catch (EntityNotFoundException e) {
			out.println("No such Record Found");
		}
		
		System.out.println(employee1);*/



