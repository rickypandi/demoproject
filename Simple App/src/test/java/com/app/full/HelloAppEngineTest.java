package com.app.full;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class HelloAppEngineTest {

  @Test
  public void test() throws IOException {
    MockHttpServletResponse response = new MockHttpServletResponse();
    new HelloAppEngine().doGet(null,response);
    /*
    DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
	  Entity user1=new Entity("employee Details","rajesh@gmail.com");
	  user1.setProperty("name", "rajesh");
	  user1.setProperty("emp id", "1001");
	  user1.setProperty("mob num","8838433974");
	  ds.put(user1);	  
*/
    Assert.assertEquals("text/plain", response.getContentType());
    Assert.assertEquals("UTF-8", response.getCharacterEncoding());
    Assert.assertEquals("Hello App Engine!\r\n", response.getWriterContent().toString());
  }
}
