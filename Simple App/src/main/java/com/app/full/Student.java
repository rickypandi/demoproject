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
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@WebServlet(
		name="Student detail",
		urlPatterns= {"/Student"}
		)
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Student() {
        super();
    }
	/*public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("Student Record is empty");
		
	}*/
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatastoreService dr=DatastoreServiceFactory.getDatastoreService();
		String input=request.getParameter("email");
		  Entity us=new Entity("Student details","rahul1@gmail.com");
		  us.setProperty("Name", "Rahul");
		  us.setProperty("dept", "CSE");
		  us.setProperty("mob num","9003180778");
		  //dr.put(us);
		  Entity Student1=null;
		  PrintWriter out=response.getWriter();
		  Key k = KeyFactory.createKey("Student details",input);
		  try {
			Student1=dr.get(k);
			out.println("The details which matches the record"+"\n"+Student1);
			} catch (EntityNotFoundException e) {
			out.println("No such record found");
			}
		  response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
	}

}
