package com.app.full;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

public class Createemptest {
	Createemp create=new Createemp();
	Getempdetails get=new Getempdetails(); 

  @Test
  public void first_name() throws IOException{
	  String fnameactual;
	  String fnameExpected ="saksjjkdkasdkaskda";
           assertEquals(fnameExpected,fnameactual);
  }
  @Test
  public void last_name(){
	  
	  String lnameactual=null;
	  String lnameExpected=create.lname;
	  assertEquals(lnameExpected,lnameactual);
  }
  @Test
 public void email_id() {
	  String email_idactual=null;
	  String email_idExpected=create.emailid;
	  assertEquals(email_idExpected,email_idactual);
  }
  @Test
  public void UUID() {
	  java.util.UUID uuid_actual=create.uuid;
	  String uuid_expected=create.pkey;
	  assertEquals(uuid_expected,uuid_actual);
  }
  @Test
  public void create_entity() {
	  String Entity_actual=null;
	  Entity Entity_expected=create.user;
	  assertEquals(Entity_expected,Entity_actual);
  }
  @Test
  public void create_key(){
	  Key actual_key=null;
	  Key Expected_key=create.key;
	  assertEquals(Expected_key,actual_key);
  }
	  
}
