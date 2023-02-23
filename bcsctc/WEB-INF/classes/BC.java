import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class BC extends HttpServlet {
public BC(){}
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String date= LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
String rollno= request.getParameter("rollno");

try{
 Class.forName("com.mysql.jdbc.Driver");
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oshp","root","password");
 Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
 ResultSet rs = st.executeQuery("select * from upiids where num="+rollno+";");
 rs.first();
 out.println("<title>Bonafide Certificate</title>");
 out.println("<link rel= 'icon' href= 'http://localhost:8080/bcsctc/Images/ku-college-logo.png' type= 'image/x-icon'>");
 out.println("<body style='background-color:#f5f5f5'>");
 out.println("<form action='PrintBC' method='post'>");
 out.println("<center><img alt='KUCET' src='http://localhost:8080/bcsctc/Images/image-preview.jpg' style='height:118px; width:889px' /></center>");
 out.println("<br><p style='text-align:right'><strong>Date : </strong><input type='text' name='transno' value="+date+" ></p>");
 out.println("<br><br><br><br>");
 out.println("<p><strong>Payment Details</strong> : <input type='text' name='transno' value="+rs.getString(1)+" >&nbsp; &nbsp;");
 out.println("<strong>Date</strong> :<input type='text' name='trandate' value="+date+" > </p>");
 out.println("<p><strong>Amount</strong> :<input type='text' name='tranno' value='100' ></p>");
 out.println("<center>");
 out.println("<p><u><strong>BONAFIDE CERTIFICATE</strong></u></p>");
 out.println("This is to certify that Mr./Ms. <strong><input type='text' name='name' value="+rs.getString(1)+" ></strong> S/o.D/o <strong>");
 out.println("<input type='text' name='name' value="+rs.getString(1)+" >&nbsp;</strong>bearing Roll Number : <strong><input type='text' name='rollno' value="+rollno+" >");
 out.println("<input type='text' name='fname' value="+rs.getString(1)+" ></strong>is/was a bonafide student of <strong>this college during the academic year");
 out.println("<input type='text' name='acyear' value="+rs.getString(1)+" > </strong> studying/studied <strong>B.Tech<input type='text' name='year' value="+rs.getString(1)+" > - Year");
 out.println("<input type='text' name='sem' value="+rs.getString(1)+" >- Semester </strong> with <strong><input type='text' name='branch' value="+rs.getString(1)+" ></strong> branch.");
 out.println("<br><br><br><br><br><br>");
 out.println("<strong>Clerk&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Supdt.");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; A.R/D.R&nbsp; &nbsp; &nbsp;");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;PRINCIPAL</strong>");
 out.println("<br><br><br><input type='submit' value='Generate & Print' />");
 out.println("</center></form><body>");
 con.close();
}catch(Exception e){
out.println("<center><h2>You are not in Database</h2><strong>Error</strong> :&nbsp;"+ e );
out.println("<br><br><a href='http://localhost:8080/bcsctc/addition.html'>Click Here to Register</a>");
}
}
}
