package com.app.full;

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



@WebServlet(
    name = "employee detail",
    urlPatterns = {"/employee"}
)
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  DatastoreService ds;
	  ds=DatastoreServiceFactory.getDatastoreService();
	  Entity user=new Entity("employee Details","1");
	  user.setProperty("name", "ricky");
	  user.setProperty("emp id", "ricky@gmail.com");
	  user.setProperty("mob num","9003180778");
	  ds.put(user);
	  Entity user2=new Entity("employee Details","2");
	  user2.setProperty("name", "rajesh");
	  user2.setProperty("emp id", "rajesh@gmail.com");
	  user2.setProperty("mob num","8838433974");
	  ds.put(user2);
	  


    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
  }
   public  void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
	
		PrintWriter out=response.getWriter();
		out.println("pandikumar");
		
	}
    

  }
