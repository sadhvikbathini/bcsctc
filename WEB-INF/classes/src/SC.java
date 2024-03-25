import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SC extends HttpServlet {
public SC(){}
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String date= LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
String rollno= request.getParameter("rollno");

try{
 Connection con = DBUtil.getConnection();
 PreparedStatement ps=con.prepareStatement("select * from student where rollno=?;");
 ps.setString(1,rollno);
 ResultSet rs = ps.executeQuery();
 rs.next();
 out.println("<title>Study & Conduct Certificate</title>");
 out.println("<link rel= 'icon' href= '/bcsctc/Images/logo.png' type= 'image/x-icon'>");
 out.println("<body style='background-color:#f5f5f5'>");
 out.println("<form action='PrintSC' method='post'>");
 out.println("<center><a href='/bcsctc'><img alt='LOGO' src='/bcsctc/Images/image-preview.jpg' style='max-width:100%;height:auto;' /></a></center>");
 out.println("<br><p style='text-align:right'><strong>Date : </strong><input type='text' name='date' value="+date+" ></p>");
 out.println("<br><p><strong>No.</strong> : <input type='text' name='no' value='' ><br><br>");
// "+rs.getString(2)+"
 out.println("<p><strong>Payment Details</strong> : <input type='text' name='tranno' >&nbsp; &nbsp;");
 out.println("<strong>Date</strong> :<input type='text' name='trandate' value="+date+" > </p>");
 out.println("<p><strong>Amount</strong> :<input type='text' name='amount' value='100' ></p>");
 out.println("<center>");
 out.println("<p><u><strong>STUDY & CONDUCT CERTIFICATE</strong></u></p></center><p style='line-height: 25px;'>");
 out.println("This is to certify that Mr./Ms. <strong><input type='text' name='name' value='"+rs.getString(7)+"' ></strong> S/o.D/o <strong>");
 out.println("<input type='text' name='fname' value='"+rs.getString(8)+"' >&nbsp;</strong>bearing Roll Number : <strong><input type='text' name='rollno' value='"+rollno+"' >");
 out.println("</strong>is/was a bonafide student of <strong>this college during the academic year");
 out.println("<input type='text' name='acyear' value='"+rs.getString(6)+"' > </strong> studying/studied <strong><input type='text' name='course' value='"+rs.getString(4)+"' >");
   out.println("<select name='year' id='yearno'/>");
   out.println("<option value='IV'>IV</option>");
   out.println("<option value='III'>III</option>");
   out.println("<option value='II'>II</option>");
   out.println("<option value='I'>I</option>");
   out.println("</select> - Year ");
   out.println("<select name='sem' id='semno'/>");
   out.println("<option value='II'>II</option>");
   out.println("<option value='I'>I</option>");
  out.println("</select>");
//"+rs.getString(1)+" > - Year");
out.println(" - Semester </strong>");
//"+rs.getString(1)+" >- Semester </strong> 
out.println("with <strong><input type='text' name='branch' value='"+rs.getString(5)+"' ></strong> branch.");
 out.println("</p><center><br><br><br><br>");
 out.println("<strong>Clerk&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Supdt.");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; A.R/D.R&nbsp; &nbsp; &nbsp;");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;PRINCIPAL</strong>");
 out.println("<br><br><br><input type='submit' value='Generate & Print' />");
 out.println("<input type='button' value='Back' onclick='history.go(-1)'>");
 out.println("</center></form><body>");
 con.close();
}catch(Exception e){
out.println("<center><h2>You are not in Database</h2><strong>Error</strong> :&nbsp;"+ e );
 out.println("<br><br><form><input type='button' value='Search Again' onclick='history.go(-1)'>");
 out.println("<input type='submit' value='Custom Study & Conduct Certificate' formaction='/bcsctc/SC.html'>");
 out.println("<input type='submit' value='Add Students' formaction='/bcsctc/addition.html'></form><br><br><br>");
}
}
}
