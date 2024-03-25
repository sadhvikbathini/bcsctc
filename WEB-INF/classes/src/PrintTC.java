import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class PrintTC extends HttpServlet {
public PrintTC(){}
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");

PrintWriter out = response.getWriter();

String date= request.getParameter("date");
String no= request.getParameter("no");
String cno= request.getParameter("cno");
String rollno= request.getParameter("rollno");
String name= request.getParameter("name");
String fname= request.getParameter("fname");
String nation= request.getParameter("nation");
String caste= request.getParameter("caste");
String dob= request.getParameter("dob");
String admdate= request.getParameter("admdate");
String mycc= request.getParameter("mycc");
String dol= request.getParameter("dol");
String course= request.getParameter("course");
String branch= request.getParameter("branch");
String conduct= request.getParameter("conduct");
String idmarks= request.getParameter("idmarks");


  out.println("<html><title>Transfer Certificate</title>");
   out.println("<link rel= 'icon' href= '/bcsctc/Images/ku-college-logo.png' type= 'image/x-icon'>"); 
   out.println("<body onload='window.print()'>");
   out.println("<div style='border: double 5px #333333; padding: 7px;'>");
   out.println("<center>");
   out.println("<a href='/bcsctc'><img alt='LOGO' src='/bcsctc/Images/image-preview.jpg' style='max-width:100%;height:auto;' /></a>");
  out.println("<p><u><strong>TRANSFER CERTIFICATE</strong></u></p>");
  out.println("<strong>No. : </strong>"+no+"</p></center>");
  out.println("<p style='text-align:right'><strong>Date : </strong>"+date+"</p>");
 out.println("<table style='padding:0px 50px;'><tr>");
 out.println("<td><strong>Challan No.</strong></td>");
 out.println("<td> : </td><td>"+cno+"</td></tr><tr>");
 out.println("<td><strong>Registration No.</strong></td>");
 out.println("<td> : </td><td>"+rollno+"</td></tr><tr>");
 out.println("<td><strong>Name of the Student</strong></td>");
 out.println("<td> : </td><td>"+name+"</td></tr><tr>");
 out.println("<td><strong>Father's Name</strong></td>");
 out.println("<td> : </td><td>"+fname+"</td></tr><tr>");
 out.println("<td><strong>Nationality</strong></td>");
 out.println("<td> : </td><td>"+nation+"</td></tr><tr>");
 out.println("<td><strong>Category</strong></td>");
 out.println("<td> : </td><td>"+caste+"</td></tr><tr>");
 out.println("<td><strong>Date of Birth</strong></td>");
 out.println("<td> : </td><td>"+dob+"</td></tr><tr>");
 out.println("<td><strong>Date of Admission</strong></td>");
 out.println("<td> : </td><td>"+admdate+"</td></tr><tr>");
 out.println("<td><strong>Month & Year of Course Completion</strong></td>");
 out.println("<td> : </td><td>"+mycc+"</td></tr><tr>");
 out.println("<td><strong>Date of Leaving</strong></td>");
 out.println("<td> : </td><td>"+dol+"</td></tr><tr>");
 out.println("<td><strong>Course</strong></td>");
 out.println("<td> : </td><td>"+course+" ");
 out.println("( "+branch+" ) </td></tr><tr> ");
 out.println("<td><strong>Conduct</strong></td>");
 out.println("<td> : </td><td>"+conduct+"</td></tr><tr>");
 out.println("<td><strong>Identification Marks</strong></td>");
 out.println("<td> : </td><td>"+idmarks+"</td></tr>");
 out.println("</table>");
 out.println("<br><br><center>");
 out.println("<strong>Clerk&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Supdt.");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; A.R/D.R&nbsp; &nbsp; &nbsp;");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;PRINCIPAL</strong>");
 out.println("</center></div><br>");
 
   out.println("<div style='border: double 5px #333333; padding: 5px;'>");
   out.println("<strong>OFFICE COPY</strong><br>");
   out.println("<center>");
   out.println("<a href='/bcsctc'><img alt='LOGO' src='/bcsctc/Images/image-preview.jpg' style='max-width:100%;height:auto;' /></a>");
  out.println("<p><u><strong>TRANSFER CERTIFICATE</strong></u></p>");
 out.println("<p><strong>No. : </strong>"+no+"</p></center>");
  out.println("<p style='text-align:right'><strong>Date : </strong>"+date+"</p>");
 out.println("<table style='padding:0px 50px;'><tr>");
 out.println("<td><strong>Challan No.</strong></td>");
 out.println("<td> : </td><td>"+cno+"</td></tr><tr>");
 out.println("<td><strong>Registration No.</strong></td>");
 out.println("<td> : </td><td>"+rollno+"</td></tr><tr>");
 out.println("<td><strong>Name of the Student</strong></td>");
 out.println("<td> : </td><td>"+name+"</td></tr><tr>");
 out.println("<td><strong>Father's Name</strong></td>");
 out.println("<td> : </td><td>"+fname+"</td></tr><tr>");
 out.println("<td><strong>Nationality</strong></td>");
 out.println("<td> : </td><td>"+nation+"</td></tr><tr>");
 out.println("<td><strong>Category</strong></td>");
 out.println("<td> : </td><td>"+caste+"</td></tr><tr>");
 out.println("<td><strong>Date of Birth</strong></td>");
 out.println("<td> : </td><td>"+dob+"</td></tr><tr>");
 out.println("<td><strong>Date of Admission</strong></td>");
 out.println("<td> : </td><td>"+admdate+"</td></tr><tr>");
 out.println("<td><strong>Month & Year of Course Completion</strong></td>");
 out.println("<td> : </td><td>"+mycc+"</td></tr><tr>");
 out.println("<td><strong>Date of Leaving</strong></td>");
 out.println("<td> : </td><td>"+dol+"</td></tr><tr>");
 out.println("<td><strong>Course</strong></td>");
 out.println("<td> : </td><td>"+course+" ");
 out.println("( "+branch+" ) </td></tr><tr> ");
 out.println("<td><strong>Conduct</strong></td>");
 out.println("<td> : </td><td>"+conduct+"</td></tr><tr>");
 out.println("<td><strong>Identification Marks</strong></td>");
 out.println("<td> : </td><td>"+idmarks+"</td></tr>");
 out.println("</table>");
 out.println("<br><center>");
 out.println("<strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;PRINCIPAL</strong>");
 out.println("</center></div></body>");
 
  try{
  Connection con = DBUtil.getConnection();
  PreparedStatement pps=con.prepareStatement("select tcdate from student where rollno=?;");
  pps.setString(1,rollno);
  ResultSet rs = pps.executeQuery();
	rs.next();
  String bdate = rs.getString(1);
  if (bdate.equals("null")){
  	bdate = no + "/ " + date;
  }
  else{
  	bdate = bdate + " <br>&#13;&#10;" + no + "/ " + date;
  }
  PreparedStatement ps=con.prepareStatement("update student set tcdate=? where rollno=?");
  ps.setString(1,bdate);
  ps.setString(2,rollno);
  ps.executeUpdate();
  con.close();
  }catch(Exception e){
  System.out.println(e);
  }

 }
}
