import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Register extends HttpServlet {
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String rollno= request.getParameter("rollno");
if ( rollno == "5656"){
out.println("<center>Roll Number : </center>" + rollno);}
else{
try{
 Class.forName("com.mysql.jdbc.Driver");
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oshp","root","password");
 Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
 ResultSet rs = st.executeQuery("select * from upiids where num="+rollno+";");

}catch(Exception e){}
response.sendRedirect("http://localhost:8080/bcsctc/addition.html");
}
}
}
