import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TC extends HttpServlet {
public TC(){}
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String date= LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
String rollno= request.getParameter("rollno");
String dupli = request.getParameter("dupli");

try{
 Connection con = DBUtil.getConnection();
 PreparedStatement ps=con.prepareStatement("select * from student where rollno=?;");
 ps.setString(1,rollno);
 ResultSet rs = ps.executeQuery();
 rs.next();

 out.println("<title>Transfer Certificate</title>");
 out.println("<link rel= 'icon' href= '/bcsctc/Images/logo.png' type= 'image/x-icon'>");
 out.println("<body style='background-color:#f5f5f5'>");
 out.println("<form action='PrintTC' method='post'>");
 out.println("<center><a href='/bcsctc'><img alt='LOGO' src='/bcsctc/Images/image-preview.jpg' style='max-width:100%;height:auto;' /></a>");
 out.println("<p><u><strong>TRANSFER CERTIFICATE</strong></u></p><br>");
 
// ----- TC CONDITION & Another TC Generation--------
// Condition for dupli tc, when a nullpointerexception or everytime we come from index.html the dupli is given false
// but when we come from the same TC then the dupli is give true and 'or logic' is used to if satement tcdate||dupli
 if (dupli == null){
 	dupli = "False";
 }
 String tcdate = "null";
 if(tcdate.equals(rs.getString(30)) || dupli.equals("True") ) {
//-------------------------------

 out.println("<p style='text-align:'left'><strong>No. : </strong><input type='text' value='' name='no' /></p>");
 //"+rs.getString(2)+"
 out.println("<p style='text-align:right'><strong>Date : </strong><input type='text' value='"+date+"' name='date' /></p><br>");
 out.println("<table><tr>");
 out.println("<td><strong>Challan No. : </strong></td>");
 out.println("<td><input type='text' name='cno'/></td></tr><tr>");
 out.println("<td><strong>Registration No. : </strong></td>");
 out.println("<td><input type='text' value='"+rs.getString(1)+"' name='rollno' /></td></tr><tr>");
 out.println("<td><strong>Name of the Student : </strong></td>");
 out.println("<td><input type='text' value='"+rs.getString(7)+"' name='name'/></td></tr><tr>");
 out.println("<td><strong>Fathers Name : </strong></td>");
 out.println("<td><input type='text' value='"+rs.getString(8)+"' name='fname'/></td></tr><tr>");
 out.println("<td><strong>Nationality : </strong></td>");
 out.println("<td><input type='text' value='' name='nation'/></td></tr><tr>");
 out.println("<td><strong>Category : </strong></td>");
 out.println("<td><input type='text' value='"+rs.getString(13)+"' name='caste'/></td></tr><tr>");
 out.println("<td><strong>Date of Birth : </strong></td>");
 out.println("<td><input type='text' value='"+rs.getString(10)+"' placeholder='DD-MM-YYYY' name='dob'/></td></tr><tr>");
 out.println("<td><strong>Date of Admission</strong></td>");
 out.println("<td> : <input type='text' placeholder='DD-MM-YYYY' value='"+rs.getString(3)+"' name='admdate'/></td></tr><tr>");
 out.println("<td><strong>Month&Year of Course Completion : </strong></td>");
 out.println("<td><input type='text' placeholder='MM-YYYY' name='mycc'/></td></tr><tr>");
 out.println("<td><strong>Date of Leaving : </strong></td>");
 out.println("<td><input type='text' placeholder='DD-MM-YYYY' name='dol'/></td></tr><tr>");
 out.println("<td><strong>Course : </strong></td>");
 out.println("<td><input type='text' value='"+rs.getString(4)+"' name='course'/></td>");
 out.println("<td><input type='text' value='"+rs.getString(5)+"' name='branch'/></td></tr><tr>");
 out.println("<td><strong>Conduct : </strong></td>");
 out.println("<td><input type='text' value='Satisfactory' name='conduct'/></td></tr><tr>");
 out.println("<td><strong>Identification Marks : </strong></td>");
 out.println("<td><input type='text' value='"+rs.getString(22)+"' name='idmarks'/></td></tr>");
 out.println("</table>");
 out.println("<br><br><br><br>");
 out.println("<strong>Clerk&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Supdt.");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; A.R/D.R&nbsp; &nbsp; &nbsp;");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;PRINCIPAL</strong>");
 out.println("<br><br><br><input type='submit' value='Generate & Print' />");
 out.println("<input type='button' value='Back' onclick='history.go(-1)'>"); 
 out.println("</center></form><body>");

//--------TC CONDITION----------
}else{
	out.println("--- <em> TRANSFER CERTIFICATE(S) WAS ALREADY ISSUED ON ---<br><strong>"+ rs.getString(30)+"</strong></em> ");
	out.println("<br><form method='post'>");
	out.println("<input type='hidden' value='"+rollno+"' name='rollno' />");
  out.println("<input type='hidden' value='True' name='dupli' />");
	out.println("<br><br><input type='submit' value='Get Another Transfer Certificate' formaction='TC' ></form>");
	out.println("</center><body>");
}
//--------------------------------
 con.close();
}catch(Exception e){
out.println("<center><h2>You are not in Database</h2><strong>Error</strong> :&nbsp;"+ e );
 out.println("<br><br><form><input type='button' value='Search Again' onclick='history.go(-1)'>");
 out.println("<input type='submit' value='Custom Transfer Certificate' formaction='/bcsctc/TC.html'>");
 out.println("<input type='submit' value='Add Students' formaction='/bcsctc/addition.html'></form><br><br><br>");
}
}
}
