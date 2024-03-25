import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Update extends HttpServlet {
public Update(){}
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
String itcdate = request.getParameter("itcdate");
String remarks = request.getParameter("remarks");
String tcdate = request.getParameter("tcdate");
String bcdate = request.getParameter("bcdate");
String scdate = request.getParameter("scdate");
String mcdate = request.getParameter("mcdate");
String feereim = request.getParameter("feereim");
String gen = request.getParameter("gen");
String ssc = request.getParameter("ssc");
String inter = request.getParameter("inter");
String itc = request.getParameter("itc");
String photos = request.getParameter("photos");

try{
 Connection con = DBUtil.getConnection();
 PreparedStatement ps=con.prepareStatement("update student set rollno=?,no=?,admdate=?,yos=?,name=?,fname=?,mname=?,dob=?,pob=?,aadharno=?,caste=?,subcaste=?,income=?,rnk=?,casteno=?,address=?,phone1=?,phone2=?,email=?,idmarks=?,qexam=?,regdno=?,myop=?,marks=?,college=?,itcdate=?,remarks=?,course=?,branch=?,tcdate=?,bcdate=?,scdate=?,mcdate=?,feereim=?,gen=?,ssc=?,inter=?,itc=?,photos=?  where rollno=?");

  ps.setString(1,rollno);
  ps.setString(2,no);
  ps.setString(3,admdate);

  ps.setString(4,yos);
  ps.setString(5,name);
  ps.setString(6,fname);
  ps.setString(7,mname);
  ps.setString(8,dob);
  ps.setString(9,pob);
  ps.setString(10,aadharno);
  ps.setString(11,caste);
  ps.setString(12,subcaste);
  ps.setString(13,income);
  ps.setString(14,rnk);
  ps.setString(15,casteno);
  ps.setString(16,address);
  ps.setString(17,phone1);
  ps.setString(18,phone2);
  ps.setString(19,email);
  ps.setString(20,idmarks);
  ps.setString(21,qexam);
  ps.setString(22,regdno);
  ps.setString(23,myop);
  ps.setString(24,marks);
  ps.setString(25,college);
  ps.setString(26,itcdate);
  ps.setString(27,remarks);
  ps.setString(28,course);
  ps.setString(29,branch);
 // ps.setString(28,false);
  ps.setString(30,tcdate);
  ps.setString(31,bcdate);
  ps.setString(32,scdate);
  ps.setString(33,mcdate);
  ps.setString(34,feereim);
  ps.setString(35,gen);
  ps.setString(36,ssc);
  ps.setString(37,inter);
  ps.setString(38,itc);
  ps.setString(39,photos);
 ps.setString(40,rollno);

 int status = ps.executeUpdate();
 if(status>0){
 out.println("<center><h2>Updated Successfully</h2>");
 out.println("<br><br><form method='post' >");
 out.println("  <input type='text' name='rollno' value='"+rollno+"' > ");
 out.println("  <input type='submit' value='View Updated Details' formaction='Search' >");
 out.println("  <input type='submit' value='Back' formaction='/bcsctc' >"); 
 out.println("</form>");
 out.println("</center>");
 }
 else{
 out.println("<center><h2> Error : Not able to update </h2></center>");
 }
 con.close();
}catch(Exception e){
out.println("<center><h2>You are not in Database</h2><strong>Error</strong> :&nbsp;"+ e +"<br><br><a href='/bcsctc/addition.html'>ADD STUDENTS</a>");
}
}
}
