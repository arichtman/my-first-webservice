import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.google.gson.*;

class MyBean {
	private String heading;
	private String paragraph;
	MyBean()
	{
		
	}
	
	public String getText()
	{
		return "<h1>" + this.heading + "</h1>\r\n<p>" + this.paragraph + "</p>";
	}
}


// Extend HttpServlet class
public class HelloWorld extends HttpServlet {
 
   private String message;

   public void init() throws ServletException {
      // Do required initialization
      message = "Hello World";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");
      String test = request.getParameter("test");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
	  
	  
	  BufferedReader reader = request.getReader();
	  if(reader.ready() == true)
	  {
		Gson gson = new Gson();
		MyBean myBean = gson.fromJson(reader, MyBean.class);
		out.println(myBean.getText());
	  }
   }
   
   public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
			doGet(request, response);
	 }

   public void destroy() {
      // do nothing.
   }
}