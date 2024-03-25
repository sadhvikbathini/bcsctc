import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class FilterEdit extends HttpServlet {
public FilterEdit(){}
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();

String course= request.getParameter("course");
String branch = request.getParameter("branch");
String yos = request.getParameter("yos");
String caste = request.getParameter("caste");
String feereim = request.getParameter("feereim");
String gen = request.getParameter("gen");

String vals= request.getParameter("val");

try{
  Connection con = DBUtil.getConnection();

  out.println("<html><title>Student Details</title>");
   out.println("<link rel= 'icon' href= '/bcsctc/Images/logo.png' type= 'image/x-icon'>");
   out.println("<body style='background-color:#f5f5f5'>");
   out.println("<center>");
   out.println("<a href='/bcsctc'><img alt='LOGO' src='/bcsctc/Images/image-preview.jpg' style='max-width:100%;height:auto;' /></a></center>");


   out.println("<br><p style='text-align:right'><input placeholder='Find . . . ' size='15' id='searchText'><button onclick='search()'>Find</button>");
   out.println("<script>");
		out.println("function search() {");
   out.println("var searchText = document.getElementById('searchText').value;");
   out.println("var found = window.find(searchText);");
	out.println("}");
	out.println("</script>");
	out.println("<div class='searchText'>");

	out.println("<head>");
	out.println("<style>");
	out.println("table {");
	out.println("border-collapse: collapse;");
	out.println("width: 100%;");
	out.println("}");
	out.println("th, td {");
	out.println("text-align: left;");
	out.println("padding: 8px;");
	out.println("border: 1px solid black;");
	out.println("}");
	out.println("th {");
	out.println("background-color: #dddddd;");
	out.println("}");
	out.println("</style>");
	out.println("</head>");

		out.println("<br><table>");
	  out.println("<form method='post'>");
	  out.println("<input type='hidden' value='"+vals+"' name='val' />");
	  out.println("<tr>");

int val= Integer.parseInt(vals);

	for(int i=1;i<val;i++){
	  out.println("<td></td>");
	  }
    out.println("<td><input type='submit' value='Update & Save' formaction='FilterUpdate'/> &nbsp;&nbsp; <input type='button' value='Cancel' onclick='history.go(-1)'></td>");
  out.println("</tr>");

			  out.println("<tr>");
				out.println("<th>Roll Number</th>");
				out.println("<th>Name</th>");
				out.println("<th>Father Name</th>");
				out.println("<th>Mother Name</th>");
				out.println("<th>Date Of Birth</th>");
				out.println("<th>Place Of Birth</th>");
				out.println("<th>Course</th>");
				out.println("<th>Branch</th>");
				out.println("<th>Year of Study</th>");
				out.println("<th>Gender</th>");
				out.println("<th>Fee Reim.</th>");
				out.println("<th>Caste</th>");
				out.println("<th>SubCaste</th>");
				out.println("<th>Caste Sl.No</th>");
				out.println("<th>Student's Mobile No.</th>");
				out.println("<th>Guardian's Mobile No.</th>");
				out.println("<th>Email Address</th>");
				out.println("<th>Address</th>");
				out.println("<th>Identification Marks</th>");
				out.println("<th>Aadhar No.</th>");
				out.println("<th>Annual Income</th>");
				out.println("<th>Rank</th>");
				out.println("<th>Date of Joining</th>");
//qualifing exam details not given
				out.println("<th>TC Issued on</th>");
				out.println("<th>Bonafide Issued on</th>");
				out.println("<th>Conduct Issued on</th>");
				out.println("<th>Migration Issued on</th>");
				out.println("<th>Remarks</th>");
			out.println("</tr>");

String clause=" True";
if (!course.equals("null")){
	clause = clause + " AND course='" + course +"'";
}
if (!branch.equals("null")){
	clause = clause + " AND branch='" + branch+"'";
}
if (!yos.equals("null")){
	clause = clause + " AND yos='" + yos+"'";
}
if (!gen.equals("null")){
	clause = clause + " AND gen='" + gen+"'";
}
if (!feereim.equals("null")){
	clause = clause + " AND feereim='" + feereim+"'";
}
if (!caste.equals("null")){
	clause = clause + " AND caste='" + caste+"'";
}
 PreparedStatement ps=con.prepareStatement("select * from student where "+clause+" ;");
 //ps.setString(1,clause);
 ResultSet rs = ps.executeQuery();
 int i=1;
 while(rs.next()){

		out.println("<tr>");
		out.println("<input type='hidden' value='"+rs.getString(1)+"' name='rollno"+i+"' />");
		if (val==1){
		  out.println("<td><input type='text' value='"+rs.getString(1)+"' name='rollno"+i+"' /></td>");
		  }else{
			out.println("<td>"+rs.getString(1)+"</td>");
			}
		if (val==2){
			out.println("<td><input type='text' value='"+rs.getString(7)+"' name='name"+i+"' /></td>");
			}else{
			out.println("<td>"+rs.getString(7)+"</td>");
			}
		if (val==3){
			out.println("<td><input type='text' value='"+rs.getString(8)+"' name='fname"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(8)+"</td>");
		  }
		if (val==4){
			out.println("<td><input type='text' value='"+rs.getString(9)+"' name='mname"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(9)+"</td>");
			}
		if (val==5){
			out.println("<td><input type='text' value='"+rs.getString(10)+"' name='dob"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(10)+"</td>");
			}
		if (val==6){
			out.println("<td><input type='text' value='"+rs.getString(11)+"' name='pob"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(11)+"</td>");
			}
		if (val==7){
			out.println("<td><input type='text' value='"+rs.getString(4)+"' name='course"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(4)+"</td>");
			}
		if (val==8){
			out.println("<td><input type='text' value='"+rs.getString(5)+"' name='branch"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(5)+"</td>");
			}
		if (val==9){
			out.println("<td><input type='text' value='"+rs.getString(6)+"' name='yos"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(6)+"</td>");
			}
		if (val==10){
			out.println("<td><input type='text' value='"+rs.getString(35)+"' name='gen"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(35)+"</td>");
			}
		if (val==11){
			out.println("<td><input type='text' value='"+rs.getString(34)+"' name='feereim"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(34)+"</td>");
			}
		if (val==12){
			out.println("<td><input type='text' value='"+rs.getString(13)+"' name='caste"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(13)+"</td>");
			}
		if (val==13){
			out.println("<td><input type='text' value='"+rs.getString(14)+"' name='subcaste"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(14)+"</td>");
			}
		if (val==14){
			out.println("<td><input type='text' value='"+rs.getString(17)+"' name='casteno"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(17)+"</td>");
			}
		if (val==15){
			out.println("<td><input type='text' value='"+rs.getString(19)+"' name='phone1"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(19)+"</td>");
			}
		if (val==16){
			out.println("<td><input type='text' value='"+rs.getString(20)+"' name='phone2"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(20)+"</td>");
			}
		if (val==17){
			out.println("<td><input type='text' value='"+rs.getString(21)+"' name='email"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(21)+"</td>");
			}
		if (val==18){
			out.println("<td><input type='text' value='"+rs.getString(18)+"' name='address"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(18)+"</td>");
			}
		if (val==19){
			out.println("<td><input type='text' value='"+rs.getString(22)+"' name='idmarks"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(22)+"</td>");
			}
		if (val==20){
			out.println("<td><input type='text' value='"+rs.getString(12)+"' name='aadharno"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(12)+"</td>");
			}
		if (val==21){
			out.println("<td><input type='text' value='"+rs.getString(15)+"' name='income"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(15)+"</td>");
			}
		if (val==22){
			out.println("<td><input type='text' value='"+rs.getString(16)+"' name='rnk"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(16)+"</td>");
			}
		if (val==23){
			out.println("<td><input type='text' value='"+rs.getString(3)+"' name='admdate"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(3)+"</td>");
			}
		if (val==24){
			out.println("<td><input type='text' value='"+rs.getString(30)+"' name='tcdate"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(30)+"</td>");
			}
		if (val==25){
			out.println("<td><input type='text' value='"+rs.getString(31)+"' name='bcdate"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(31)+"</td>");
			}
		if (val==26){
			out.println("<td><input type='text' value='"+rs.getString(32)+"' name='scdate"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(32)+"</td>");
			}
		if (val==27){
			out.println("<td><input type='text' value='"+rs.getString(33)+"' name='mcdate"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(33)+"</td>");
			}
		if (val==28){
			out.println("<td><input type='text' value='"+rs.getString(29)+"' name='remarks"+i+"' /></td>");
		}else{
			out.println("<td>"+rs.getString(29)+"</td>");
			}
		out.println("</tr>");
 i++;
 }
 
out.println("</table>");

  PreparedStatement c=con.prepareStatement("select count(rollno) from student where "+clause+" ;");
  //c.setString(1,clause);
  ResultSet cs = c.executeQuery();
  cs.next();
 out.println("<br><br><center><em><strong> Total </strong> : "+cs.getString(1)+" Students</em><br><br>");


out.println("<input type='hidden' value='"+cs.getString(1)+"' name='count' />");
out.println("</form>");


out.println("</div>");
  out.println("<style>");
  out.println(".footer {");
   out.println(" position: ;");
   out.println(" font-size:8px;");
  out.println("  left: 0;");
 out.println("   bottom: 0;");
 out.println("   width: 100%;");
 out.println("   background-color:#ededed;");
 out.println("   color: black;");
 out.println("   text-align: center;");
 out.println(" }");
 out.println(" </style>");
 out.println(" <div class='footer'>");
 out.println("   <p>Copyright 2023 &copy; Developed by Team Kaboom</p>");
 out.println("</div>");
 out.println("</body></html>");
 con.close();
}catch(Exception e){
out.println("<center><h2>You are not in Database</h2><strong>Error</strong> :&nbsp;"+ e );
 out.println("<br><br><form><input type='button' value='Search Again' onclick='history.go(-1)'>");
 out.println("<input type='submit' value='Add Students' formaction='/bcsctc/addition.html'></form><br><br><br>");
}
}
}
