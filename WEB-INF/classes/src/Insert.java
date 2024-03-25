import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Insert extends HttpServlet {
public Insert(){}
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();

String rollno= request.getParameter("rollno");
String no = request.getParameter("no");
String admdate = request.getParameter("admdate");
String course = request.getParameter("course");
String branch = request.getParameter("branch");
String yos = request.getParameter("yos");
String name = request.getParameter("name");
String fname = request.getParameter("fname");
String mname = request.getParameter("mname");
String dob = request.getParameter("dob");
String pob = request.getParameter("pob");
String aadharno = request.getParameter("aadharno");
String caste = request.getParameter("caste");
String subcaste = request.getParameter("subcaste");
String income = request.getParameter("income");
String rnk = request.getParameter("rnk");
String casteno = request.getParameter("casteno");
String address = request.getParameter("address");
String phone1 = request.getParameter("phone1");
String phone2 = request.getParameter("phone2");
String email = request.getParameter("email");
String idmarks = request.getParameter("idmarks");
String qexam = request.getParameter("qexam");
String regdno = request.getParameter("regdno");
String myop = request.getParameter("myop");
String marks = request.getParameter("marks");
String college = request.getParameter("college");
String tempitcno = request.getParameter("tempitcno");
String tempitcdate = request.getParameter("tempitcdate");
String itcdate = tempitcno + "/" + tempitcdate ;
String remarks = request.getParameter("remarks");
// String tcdate = request.getParameter("tcdate");
// String bcdate = request.getParameter("bcdate");
// String scdate = request.getParameter("scdate");
//String mcdate = request.getParameter("mcdate");
String feereim = request.getParameter("feereim");
String gen = request.getParameter("gen");
String ssc = request.getParameter("ssc");
String inter = request.getParameter("inter");
String itc = request.getParameter("itc");
String photos = request.getParameter("photos");

try{
 Connection con = DBUtil.getConnection();
 PreparedStatement ps=con.prepareStatement("INSERT INTO student(rollno,no,admdate,course,branch,yos,name,fname,mname,dob,pob,aadharno,caste,subcaste,income,rnk,casteno,address,phone1,phone2,email,idmarks,qexam, regdno,myop,marks,college,itcdate,remarks,feereim,gen,ssc,inter,itc,photos) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
 ps.setString(1,rollno);
 ps.setString(2,no);
 ps.setString(3,admdate);
 ps.setString(4,course);
 ps.setString(5,branch);
 ps.setString(6,yos);
 ps.setString(7,name);
 ps.setString(8,fname);
 ps.setString(9,mname);
 ps.setString(10,dob);
 ps.setString(11,pob);
 ps.setString(12,aadharno);
 ps.setString(13,caste);
 ps.setString(14,subcaste);
 ps.setString(15,income);
 ps.setString(16,rnk);
 ps.setString(17,casteno);
 ps.setString(18,address);
 ps.setString(19,phone1);
 ps.setString(20,phone2);
 ps.setString(21,email);
 ps.setString(22,idmarks);
 ps.setString(23,qexam);
 ps.setString(24,regdno);
 ps.setString(25,myop);
 ps.setString(26,marks);
 ps.setString(27,college);
 ps.setString(28,itcdate);
 ps.setString(29,remarks);
// ps.setString(28,false);
 ps.setString(30,feereim);
 ps.setString(31,gen);
 ps.setString(32,ssc);
 ps.setString(33,inter);
 ps.setString(34,itc);
 ps.setString(35,photos);

 int status = ps.executeUpdate();
 
  out.println("<html><title>Insertion</title>");
   out.println("<link rel= 'icon' href= '/bcsctc/Images/logo.png' type= 'image/x-icon'>");
   out.println("<body style='background-color:#f5f5f5'>");

 if(status>0){
 out.println("<center><br><h2>Added Successfully</h2></center><br>");
 out.println("<center><form action='/bcsctc/addition.html'>");
 out.println("<input type='submit' value='Add Another Student' />");
 out.println("<br><br><input type='submit' value='Back' formaction='/bcsctc' >");
 out.println("</form>");
 }
 else{
 out.println("<center><h2> Error : Not able to add </h2>");
 out.println("<br><br><form><input type='button' value='Try Again' onclick='history.go(-1)'></form>");
 }
 out.println("</center></body></html>");
 con.close();
}catch(Exception e){
out.println("<center><h2>_ERROR_</h2><strong>Error</strong> :&nbsp;"+ e );
 out.println("<br><br><form><input type='button' value='Check & Try Again' onclick='history.go(-1)'>");
 out.println("<input type='submit' value='Home' formaction='/bcsctc'></form><br><br><br>");
 out.println("</center></body></html>");
}
}
}
