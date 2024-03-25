import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ip extends HttpServlet {
public Ip(){}
protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
try {

	InetAddress localHost = InetAddress.getLocalHost();
	String localIPAddress = localHost.getHostAddress();

 	out.println("<html><body style='background-color:#f5f5f5'>");
	out.println("<em>"+localIPAddress+":6969/bcsctc</em>");
 	out.println("</body></html>");
} catch (UnknownHostException e) {
            e.printStackTrace();
        }
}
}
