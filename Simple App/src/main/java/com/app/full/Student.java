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
		name="/Student detail",
		urlPatterns= {"/Student"}
		)
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Student() {
        super();
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("Student Record is empty");
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatastoreService dr=DatastoreServiceFactory.getDatastoreService();
		  Entity us=new Entity("Student details","2");
		  us.setProperty("Name", "Rahul");
		  us.setProperty("emp id", "rahul@gmail.com");
		  us.setProperty("mob num","9003180778");
		  dr.put(us);
		  response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
	}

}
