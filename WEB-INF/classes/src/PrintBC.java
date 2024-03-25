import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")

public class PrintBC extends HttpServlet {
public PrintBC(){}
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String date= request.getParameter("date");
String no= request.getParameter("no");
String tranno= request.getParameter("tranno");
String trandate= request.getParameter("trandate");
String amount= request.getParameter("amount");
String name= request.getParameter("name");
String fname= request.getParameter("fname");
String rollno= request.getParameter("rollno");
String acyear= request.getParameter("acyear");
String course= request.getParameter("course");
String year= request.getParameter("year");
String sem= request.getParameter("sem");
String branch= request.getParameter("branch");

    out.println("<html><title>Bonafide Certificate</title>");
    out.println("<link rel= 'icon' href= '/bcsctc/Images/logo.png' type= 'image/x-icon'>");
    out.println("<body onload='window.print()'>");
     out.println("<div style='border: double 5px #333333; padding: 10px;'>");
    out.println("<center>");
    out.println("<a href='/bcsctc'><img alt='LOGO' src='/bcsctc/Images/image-preview.jpg' style='max-width:100%;height:auto;' /></a></center>");
 out.println("<br><p style='text-align:right'><strong>Date : </strong>"+date+"</p>");
 out.println("<p><strong>No.</strong> : "+no+"<br>");
 out.println("<p><strong>Payment Details</strong> :" +tranno+"&nbsp; &nbsp;");
 out.println("<strong>Date</strong> :" +trandate+"</p>");
 out.println("<p><strong>Amount</strong> :" +amount+"</p>");
 out.println("<center>");
 out.println("<p><u><strong>BONAFIDE CERTIFICATE</strong></u></p></center>");
 out.println("<p style='line-height: 25px;'>This is to certify that Mr./Ms. <strong>"+name+"</strong> S/o.D/o <strong>");
 out.println(""+fname+"&nbsp;</strong>bearing Roll Number : <strong>");
 out.println(""+rollno+" </strong>is/was a bonafide student of <strong>this college during the academic year");
 out.println(""+acyear+" </strong> studying/studied <strong>"+course+"&nbsp;"+year+" - Year");
 out.println(""+sem+" - Semester </strong> with <strong>"+branch+"</strong> branch.</p>");
 out.println("<br><br>");
 out.println("<center><strong>Clerk&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Supdt.");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; A.R/D.R&nbsp; &nbsp; &nbsp;");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;PRINCIPAL</strong>");
 out.println("</center></div><br>");

     out.println("<div style='border: double 5px #333333; padding: 10px;'>");
    out.println("<strong>OFFICE COPY</strong><br><center>");
    out.println("<a href='/bcsctc'><img alt='LOGO' src='/bcsctc/Images/image-preview.jpg' style='max-width:100%;height:auto;' /></a></center>");
 out.println("<br><p style='text-align:right'><strong>Date : </strong>"+date+"</p>");
 out.println("<p><strong>No.</strong> : "+no+"<br>");
 out.println("<p><strong>Payment Details</strong> :" +tranno+"&nbsp; &nbsp;");
 out.println("<strong>Date</strong> :" +trandate+"</p>");
 out.println("<p><strong>Amount</strong> :" +amount+"</p>");
 out.println("<center>");
 out.println("<p><u><strong>BONAFIDE CERTIFICATE</strong></u></p></center>");
 out.println("<p style='line-height: 25px;'>This is to certify that Mr./Ms. <strong>"+name+"</strong> S/o.D/o <strong>");
 out.println(""+fname+"&nbsp;</strong>bearing Roll Number : <strong>");
 out.println(""+rollno+" </strong>is/was a bonafide student of <strong>this college during the academic year");
 out.println(""+acyear+" </strong> studying/studied <strong>"+course+"&nbsp;"+year+" - Year");
 out.println(""+sem+" - Semester </strong> with <strong>"+branch+"</strong> branch.</p>");
 out.println("<br><br>");
 out.println("<center><strong>Clerk&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Supdt.");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; A.R/D.R&nbsp; &nbsp; &nbsp;");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;PRINCIPAL</strong>");
 out.println("</center></div></body>");

 try{
 Connection con = DBUtil.getConnection();
   PreparedStatement pps=con.prepareStatement("select bcdate from student where rollno=?;");
   pps.setString(1,rollno);
   ResultSet rs = pps.executeQuery();
 	rs.next();
   String bdate = rs.getString(1);
   if (bdate.equals("null")){
   	bdate = no + "/ " + date;
   }
   else{
   	bdate = bdate + " <br>&#13;&#10;" + no + "/ " +date;
   }
 PreparedStatement ps=con.prepareStatement("update student set bcdate=? where rollno=?");
 ps.setString(1,bdate);
 ps.setString(2,rollno);
 ps.executeUpdate();
 con.close();
 }catch(Exception e){
 System.out.println(e);
 }
}
}
