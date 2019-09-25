package full;
import full.Createemp;



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

import org.json.simple.JSONArray;

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
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.search.Index;
import com.google.appengine.api.search.IndexSpec;
import com.google.appengine.api.search.Results;
import com.google.appengine.api.search.ScoredDocument;
import com.google.appengine.api.search.SearchServiceFactory;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;

import javax.jdo.datastore.*;

@WebServlet(
		name="Employee_get",
		urlPatterns= {"/employeeget"}
		)
public class Getempdetails extends HttpServlet {
	      private static final long serialVersionUID = 1L;
	      private String printProperties;
	      private String input;
	      private Filter propertyFilter;
	      private Filter propertyFilterId;
	      private Filter propertyFilterln;
	      private Filter propertyFilterem;
	      private PreparedQuery pq;
	      JSONArray jsArray = new JSONArray();
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    DatastoreService datastore=DatastoreServiceFactory.getDatastoreService();
	        input=request.getParameter("name");
	 if((input!=null)&&(!input.isEmpty())) 
	    {
		        PrintWriter out=response.getWriter();
		        IndexSpec indexSpec = IndexSpec.newBuilder().setName(input).build();
		        Index index = SearchServiceFactory.getSearchService().getIndex(indexSpec);

		  
                Query q=new Query("employee_Detail")
			    .setFilter(
			     CompositeFilterOperator.or(
                 new com.google.appengine.api.datastore.Query.FilterPredicate("fname", FilterOperator.EQUAL, input),
                 new com.google.appengine.api.datastore.Query.FilterPredicate("lname", FilterOperator.EQUAL, input),
                 new com.google.appengine.api.datastore.Query.FilterPredicate("email", FilterOperator.EQUAL, input)))
			     .addSort("join_date", Query.SortDirection.ASCENDING);	
		
                  pq= datastore.prepare(q);
    
       for(Entity res: pq.asIterable())
       {
			     jsArray.add(res);
		}
		//response.sendRedirect("json.jsp");
		//jsArray.toJSONString();
		
			     out.println(jsArray);
			     jsArray.clear();
		
	}
	 else {
		         PrintWriter out=response.getWriter();

		         out.println("Enter the details to fetch");
		         Getempdetails get=new Getempdetails();
	 }
}
	
	
}
/*String query=input;
	        Results<ScoredDocument> results = index.search(query);
	        for (ScoredDocument document :results) {
	           System.out.print("firstname:" + document.getOnlyField("fname").getText());
	            System.out.println("lastname:" + document.getOnlyField("lname").getText());
	          }*/
//Results<ScoredDocument> re=index.search(input);
//System.out.println(re);
//propertyFilter = new com.google.appengine.api.datastore.Query.FilterPredicate("fname", FilterOperator.EQUAL, input);
//q = new Query("employee Details").setFilter(propertyFilter);
		