import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")
public class Search extends HttpServlet {
public Search(){}
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String rollno= request.getParameter("rollno");
try{
 Class.forName("com.mysql.jdbc.Driver");
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oshp","root","password");
 Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
 ResultSet rs = st.executeQuery("select * from upiids where num="+rollno+";");
 rs.first();
 out.println("<br><form method='post'>");
 out.println("<center><strong>Roll Number</strong> : <input type='text' name='rollno' value=" +rs.getString(1)+ ">");
 out.println("<br><br><input type='submit' value='Edit' formaction='Edit'/></form></center>");
 con.close();
}catch(Exception e){
out.println("<center><h2>You are not in Database</h2><strong>Error</strong> :&nbsp;"+ e );
out.println("<br><br><a href='http://localhost:8080/bcsctc/addition.html'>Click Here to Register</a>");
}
}
}
