
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
	public void service(HttpServletRequest request, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Test</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("request.getRequestURI():"+request.getRequestURI());
		out.println("<br />");
		out.println("request.getRequestURL().toString():"+request.getRequestURL().toString());
		out.println("<br />");
		out.println("request.getPathInfo():"+request.getPathInfo());		
		out.println("<br />");
		out.println("request.getPathTranslated():"+request.getPathTranslated());
		out.println("<br />");
		out.println("request.getServletPath():"+request.getServletPath());
		out.println("<br />");
		out.println("request.getQueryString():"+request.getQueryString());
		out.println("<br />");
        out.println("request.getRemoteAddr():"+request.getRemoteAddr());
        out.println("<br />");
		for(Object k:request.getParameterMap().keySet()){
			String str = (String)k;
			out.println("parameter "+str+":"+request.getParameter(str));
			out.println("<br />");
		}
		java.util.Enumeration emu = request.getHeaderNames();
		while(emu.hasMoreElements()){
			String str2 = (String) emu.nextElement();
			out.println("header "+str2+":"+request.getHeader(str2));
			out.println("<br />");
		}
		out.println("</body>");	 
		out.println("</html>");
	}   	
	
	
}