package com.app.full;
import com.app.full.Createemp;


import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.Details;
import com.google.api.services.discovery.Discovery.Apis.List;
import com.google.appengine.api.datastore.DatastoreAttributes;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.PropertyContainer;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;


import javax.jdo.datastore.*;

@WebServlet(
		name="Employee_get",
		urlPatterns= {"/employeeget"}
		)
public class Getempdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String printProperties;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatastoreService datastore=DatastoreServiceFactory.getDatastoreService();
		String input=request.getParameter("name");
		PrintWriter out=response.getWriter();
		
		Filter propertyFilter = new com.google.appengine.api.datastore.Query.FilterPredicate("fname", FilterOperator.EQUAL, input);
		Query q = new Query("employee Details").setFilter(propertyFilter);
		PreparedQuery pq= datastore.prepare(q);
		for(Entity res: pq.asIterable()) {
			printProperties=(String) res.getProperty("fname");
			out.println("\n"+"FirstName: "+printProperties);
			printProperties=(String) res.getProperty("lname");
			out.println("\n"+"LastName: "+printProperties);
			printProperties=(String) res.getProperty("email");
			out.println("\n"+"Email: "+printProperties);
		}
		}
}
		