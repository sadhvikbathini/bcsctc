import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class FilterUpdate extends HttpServlet {
public FilterUpdate(){}
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();

String counts= request.getParameter("count");
int count= Integer.parseInt(counts);
String vals = request.getParameter("val");
int val= Integer.parseInt(vals);

// request.getParameter("ssc");
// request.getParameter("inter");
// request.getParameter("itc");
// request.getParameter("photos");


try{
 Connection con = DBUtil.getConnection();
int status=0;
for(int i=1;i<count+1;i++){
		if (val==1){
			 PreparedStatement ps=con.prepareStatement("update student set rollno=? where rollno=?");
			 ps.setString(1,request.getParameter("rollno"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==2){
			 PreparedStatement ps=con.prepareStatement("update student set name=? where rollno=?");
			 ps.setString(1,request.getParameter("name"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
			}
		if (val==3){
			 PreparedStatement ps=con.prepareStatement("update student set fname=? where rollno=?");
			 ps.setString(1,request.getParameter("fname"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==4){
			 PreparedStatement ps=con.prepareStatement("update student set mname=? where rollno=?");
			 ps.setString(1,request.getParameter("mname"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==5){
			 PreparedStatement ps=con.prepareStatement("update student set dob=? where rollno=?");
			 ps.setString(1,request.getParameter("dob"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==6){
			 PreparedStatement ps=con.prepareStatement("update student set pob=? where rollno=?");
			 ps.setString(1,request.getParameter("pob"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==7){
			 PreparedStatement ps=con.prepareStatement("update student set course=? where rollno=?");
			 ps.setString(1,request.getParameter("course"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==8){
			 PreparedStatement ps=con.prepareStatement("update student set branch=? where rollno=?");
			 ps.setString(1,request.getParameter("branch"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==9){
			 PreparedStatement ps=con.prepareStatement("update student set yos=? where rollno=?");
			 ps.setString(1,request.getParameter("yos"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==10){
			 PreparedStatement ps=con.prepareStatement("update student set gen=? where rollno=?");
			 ps.setString(1,request.getParameter("gen"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==11){
			 PreparedStatement ps=con.prepareStatement("update student set feereim=? where rollno=?");
			 ps.setString(1,request.getParameter("feereim"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==12){
			 PreparedStatement ps=con.prepareStatement("update student set caste=? where rollno=?");
			 ps.setString(1,request.getParameter("caste"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==13){
			 PreparedStatement ps=con.prepareStatement("update student set subcaste=? where rollno=?");
			 ps.setString(1,request.getParameter("subcaste"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==14){
			 PreparedStatement ps=con.prepareStatement("update student set casteno=? where rollno=?");
			 ps.setString(1,request.getParameter("casteno"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==15){
			 PreparedStatement ps=con.prepareStatement("update student set phone1=? where rollno=?");
			 ps.setString(1,request.getParameter("phone1"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==16){
			 PreparedStatement ps=con.prepareStatement("update student set phone2=? where rollno=?");
			 ps.setString(1,request.getParameter("phone2"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==17){
			 PreparedStatement ps=con.prepareStatement("update student set email=? where rollno=?");
			 ps.setString(1,request.getParameter("email"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==18){
			 PreparedStatement ps=con.prepareStatement("update student set address=? where rollno=?");
			 ps.setString(1,request.getParameter("address"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==19){
			 PreparedStatement ps=con.prepareStatement("update student set idmarks=? where rollno=?");
			 ps.setString(1,request.getParameter("idmarks"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==20){
			 PreparedStatement ps=con.prepareStatement("update student set aadharno=? where rollno=?");
			 ps.setString(1,request.getParameter("aadharno"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==21){
			 PreparedStatement ps=con.prepareStatement("update student set income=? where rollno=?");
			 ps.setString(1,request.getParameter("income"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==22){
			 PreparedStatement ps=con.prepareStatement("update student set rnk=? where rollno=?");
			 ps.setString(1,request.getParameter("rnk"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==23){
			 PreparedStatement ps=con.prepareStatement("update student set admdate=? where rollno=?");
			 ps.setString(1,request.getParameter("admdate"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==24){
			 PreparedStatement ps=con.prepareStatement("update student set tcdate=? where rollno=?");
			 ps.setString(1,request.getParameter("tcdate"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==25){
			 PreparedStatement ps=con.prepareStatement("update student set bcdate=? where rollno=?");
			 ps.setString(1,request.getParameter("bcdate"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==26){
			 PreparedStatement ps=con.prepareStatement("update student set scdate=? where rollno=?");
			 ps.setString(1,request.getParameter("scdate"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==27){
			 PreparedStatement ps=con.prepareStatement("update student set mcdate=? where rollno=?");
			 ps.setString(1,request.getParameter("mcdate"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
		if (val==28){
			 PreparedStatement ps=con.prepareStatement("update student set remarks=? where rollno=?");
			 ps.setString(1,request.getParameter("remarks"+i));
			 ps.setString(2,request.getParameter("rollno"+i));
			  status = ps.executeUpdate();
		}
}

 if(status>0){
 out.println("<center><h2>Updated Successfully</h2>");
 out.println("<br><br><form method='post' >");
 // out.println("  <input type='text' name='rollno' value='"+rollno+"' > ");
 // out.println("  <input type='submit' value='View Updated Details' formaction='Search' >");
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
