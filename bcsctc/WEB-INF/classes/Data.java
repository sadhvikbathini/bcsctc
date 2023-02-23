import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Data extends HttpServlet{
public void doGet(HttpServletRequest r, HttpServletResponse rs) throws IOException, ServletException{
rs.setContentType("text/html");
PrintWriter out = rs.getWriter();
out.println("THIS ISMYYYYYYYYYYYYYYYYYYYYYYYYYYYYY SQL MYSQL DATABASE");
//Class.forName("com.mysql.jdbc.Driver");
try{
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oshp","root","password");
Statement st = conn.createStatement();
ResultSet rel = st.executeQuery("Select * from upiids");
out.println("<table border = 5>");
while(rel.next()){
 out.println("<tr><td>"+rel.getString(1)+"</td><tr>");
}
out.println("</table>");
out.close();
rel.close();
conn.close();
}catch(Exception e){
out.println(e);
}
}
}
