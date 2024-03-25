import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Count extends HttpServlet {
public Count(){}
protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
try{
 Connection con = DBUtil.getConnection();
 Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
 ResultSet rs = st.executeQuery("select count(rollno) from student;");
 rs.first();
 out.println("<html><body style='background-color:#f5f5f5'>");
 out.println("<em> Total : "+rs.getString(1)+" Students</em>");
 out.println("</body></html>");
 con.close();
}catch(Exception e){
out.println(e);
}
}
}
