package com.app.full;

import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    name = "employee detail",
    urlPatterns = {"/employee"}
)
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	 DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
	  String input = request.getParameter("email");
	 Entity user=new Entity("employee Details","ricky1@gmail.com");
	  user.setProperty("fname","pandi");
	  user.setProperty("name", "ricky");
	  user.setProperty("email", "ok@mail.com");
	  user.setProperty("emp id", "1004");
	  user.setProperty("mob num","9003180778");
	  //ds.put(user);
	  Entity employee1=null;
	  Key k = KeyFactory.createKey("employee Details",input);
	  System.out.println(k);
	  PrintWriter out=response.getWriter();
		try {
			employee1 = ds.get(k);
			out.println("The Details Matched with Your Input is "+"\n"+employee1);
		} catch (EntityNotFoundException e) {
			out.println("No such Record Found");
		}
		
		System.out.println(employee1);

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
  }
}


