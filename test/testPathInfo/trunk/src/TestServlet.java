
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: TestServlet
 *
 * @web.servlet
 *   name="TestServlet"
 *   display-name="TestServlet" 
 *
 * @web.servlet-mapping
 *   url-pattern="/*"
 *  
 */
 public class TestServlet extends javax.servlet.http.HttpServlet {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = -514345712229720561L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Test</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("req.getRequestURI():"+req.getRequestURI());
		out.println("<br />");
		out.println("req.getRequestURL().toString():"+req.getRequestURL().toString());
		out.println("<br />");
		out.println("req.getPathInfo():"+req.getPathInfo());		
		out.println("<br />");
		out.println("req.getPathTranslated():"+req.getPathTranslated());
		out.println("<br />");
		out.println("req.getServletPath():"+req.getServletPath());
		out.println("<br />");
		out.println("req.getQueryString():"+req.getQueryString());
		out.println("<br />");
		for(Object k:req.getParameterMap().keySet()){
			String s = (String)k;
		out.println("parameter "+s+":"+req.getParameter(s));
		out.println("<br />");
		}
		out.println("</body>");	 
		out.println("</html>");
	}   	
	
	
}