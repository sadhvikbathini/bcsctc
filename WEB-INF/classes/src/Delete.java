import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Delete extends HttpServlet {
public Delete(){}
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String rollno= request.getParameter("rollno");
try{
 Connection con = DBUtil.getConnection();
 PreparedStatement ps=con.prepareStatement("delete from student where rollno=?;");
 ps.setString(1,rollno);
 int status = ps.executeUpdate();

 out.println("<html><title>Deletion</title>");
 out.println("<link rel= 'icon' href= '/bcsctc/Images/logo.png' type= 'image/x-icon'>");
 out.println("<body style='background-color:#f5f5f5'><center>");

 if(status>0){
 out.println("<br><h2> Deleted from the Database </h2>");
 out.println("<form action='/bcsctc'><input type='submit' value='Delete More' /></form>");
 }
 else{
 out.println("<h2> Error : Not able to Delete </h2>");
 out.println("<form action='/bcsctc'><input type='button' value='Back' onclick='history.go(-1)'></form>");
 }
 out.println("</center></body></html>");
 con.close();
}catch(Exception e){
out.println("<center><h2>You are not in Database</h2><strong>Error</strong> :&nbsp;"+ e +"<br><br><a href='/bcsctc/addition.html'>ADD STUDENTS To Delete</a>");
}
}
}
