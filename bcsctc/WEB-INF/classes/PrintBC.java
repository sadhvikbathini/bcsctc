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
String tranno= request.getParameter("tranno");
String trandate= request.getParameter("trandate");
String amount= request.getParameter("amount");
String name= request.getParameter("name");
String fname= request.getParameter("fname");
String rollno= request.getParameter("rollno");
String acyear= request.getParameter("acyear");
String year= request.getParameter("year");
String sem= request.getParameter("sem");
String branch= request.getParameter("branch");

 out.println("<body onload='window.print()'>");
 out.println("<center><img alt='KUCET' src='http://localhost:8080/bcsctc/Images/image-preview.jpg' style='height:118px; width:889px' /></center>");
 out.println("<br><p style='text-align:right'><strong>Date : </strong>"+date+"</p>");
 out.println("<br><br><br><br>");
 out.println("<p><strong>Payment Details</strong> :" +tranno+"&nbsp; &nbsp;");
 out.println("<strong>Date</strong> :" +trandate+"</p>");
 out.println("<p><strong>Amount</strong> :" +amount+"</p>");
 out.println("<center>");
 out.println("<p><u><strong>BONAFIDE CERTIFICATE</strong></u></p>");
 out.println("This is to certify that Mr./Ms. <strong>"+name+"</strong> S/o.D/o <strong>");
 out.println(""+fname+"&nbsp;</strong>bearing Roll Number : <strong>");
 out.println(""+rollno+" </strong>is/was a bonafide student of <strong>this college during the academic year");
 out.println(""+acyear+" </strong> studying/studied <strong>B.Tech"+year+" - Year");
 out.println(""+sem+"- Semester </strong> with <strong>"+branch+"</strong> branch.");
 out.println("<br><br><br><br><br><br>");
 out.println("<strong>Clerk&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Supdt.");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; A.R/D.R&nbsp; &nbsp; &nbsp;");
 out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;PRINCIPAL</strong>");
 out.println("</center><body>");
}
}
