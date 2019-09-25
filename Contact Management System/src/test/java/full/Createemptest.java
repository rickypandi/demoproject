package full;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class Createemptest extends Mockito{
	HttpServletRequest request;
	HttpServletResponse response;
	PrintWriter writer;
	StringWriter stringWriter;
	
	@Before
	public void Set_test() throws IOException{
		request = mock(HttpServletRequest.class);       
        response = mock(HttpServletResponse.class);
       /* stringWriter = new StringWriter();
        writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);*/

	}
	@Test(expected=NullPointerException.class)
	public void fname_test() throws IOException{   
        when(request.getParameter("fname")).thenReturn("pandikumar");
        when(request.getParameter("lname")).thenReturn("nagarajan");
        when(request.getParameter("email")).thenReturn("pandi@gmail.com");
        when(request.getParameter("joindate")).thenReturn("23-03-2017");
        stringWriter = new StringWriter();
        writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

       
        new Createemp().doPost(request, response);

        verify(request, atLeast(1)).getParameter("fname");
        verify(request, atLeast(1)).getParameter("lname");
        verify(request, atLeast(1)).getParameter("email");
        verify(request, atLeast(1)).getParameter("joindate");

        writer.flush();
        assertTrue(stringWriter.toString().contentEquals("pandikumar"));
        assertTrue(stringWriter.toString().contains("nagarajan"));
        assertTrue(stringWriter.toString().contains("pandi@gmail.com"));
        assertTrue(stringWriter.toString().contains("23-03-2017"));
    }
	}