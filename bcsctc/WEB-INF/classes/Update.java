import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Update extends HttpServlet {
public Update(){}
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String rollno= request.getParameter("rollno");
String name="Helloworld";
try{
 Class.forName("com.mysql.jdbc.Driver");
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oshp","root","password");
 PreparedStatement ps=con.prepareStatement("update examplell set name=? where name=?");
 ps.setString(1,name);
 ps.setString(2,rollno);
 int status = ps.executeUpdate();
 if(status>0){
 out.println("<center><h2>Updated Successfully</h2></center>");
 }
 else{
 out.println("<center><h2> Error : Not able to update </h2></center>");
 }
 con.close();
}catch(Exception e){
out.println("<center><h2>You are not in Database</h2><strong>Error</strong> :&nbsp;"+ e +"<br><br><a href='http://localhost:8080/bcsctc/addition.html'>Click Here to Register</a>");
}
}
}
