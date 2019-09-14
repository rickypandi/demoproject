 package com.appengine.cloud;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@WebServlet(
    name = "Hello USer",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet{

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException{
	  DatastoreService ds;
	  ds=DatastoreServiceFactory.getDatastoreService();
	  //entity without identifier
	  Entity e=new Entity("Employee");
	  e.setProperty("Name","pandikumar");
	  e.setProperty("emp Id","1004");
	  ds.put(e);
	  //entity with identifier
	  Entity user=new Entity("emp","01");
	  user.setProperty("name", "ricky");
	  user.setProperty("emp id", "1005");
	  ds.put(user);
	  
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    
    response.getWriter().print("welcome to FULL CREATIVE!\r\n");
    response.getWriter().print("HI pandi!\r\n");
    

  }
}