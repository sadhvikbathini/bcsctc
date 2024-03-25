import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class PrintFilter extends HttpServlet {
public PrintFilter(){}
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();

String course= request.getParameter("course");
String branch = request.getParameter("branch");
String yos = request.getParameter("yos");
String caste = request.getParameter("caste");
String feereim = request.getParameter("feereim");
String gen = request.getParameter("gen");

try{
  Connection con = DBUtil.getConnection();

  out.println("<html><title>Student Details</title>");
   out.println("<link rel= 'icon' href= '/bcsctc/Images/logo.png' type= 'image/x-icon'>");
   out.println("<body style='background-color:#f5f5f5'>");
   out.println("<center>");
   out.println("<a href='/bcsctc'><img alt='LOGO' src='/bcsctc/Images/image-preview.jpg' style='max-width:100%;height:auto;' /></a></center>");

if (request.getParameter("select1")==null){
   out.println("<form method='post'><p style='text-align:right'>");
	out.println("<input type='hidden' value='"+course+"' name='course' />");
	out.println("<input type='hidden' value='"+branch+"' name='branch' />");
	out.println("<input type='hidden' value='"+yos+"' name='yos' />");
	out.println("<input type='hidden' value='"+feereim+"' name='feereim' />");
	out.println("<input type='hidden' value='"+gen+"' name='gen' />");
	out.println("<input type='hidden' value='"+caste+"' name='caste' />");
  out.println(" <input type='submit' value='Configure Table' formaction='PrintFilter' />");
  out.println(" <input type='button' value='Back' onclick='history.go(-1)'>");
}else{
	   out.println("<p style='text-align:right'><input placeholder='Find . . . ' size='15' id='searchText'><button onclick='search()'>Find</button>");
	out.println("<button onclick='window.print()'>Print Table</button>");
}
   out.println("</p>");
   out.println("<script>");
		out.println("function search() {");
   out.println("var searchText = document.getElementById('searchText').value;");
   out.println("var found = window.find(searchText);");
	out.println("}");
	out.println("</script>");
	out.println("<div class='searchText'>");

if (!course.equals("null")){
			out.println("<strong>Course</strong>: "+course+" <br> ");
}
if (!branch.equals("null")){
			out.println("<strong>Branch</strong>: "+branch+" <br> ");
}
if (!yos.equals("null")){
			out.println("<strong>Year of Study</strong> : "+yos+" <br> ");
}
if (!gen.equals("null")){
			out.println("<strong>Gender</strong>: "+gen+" <br> ");
}
if (!feereim.equals("null")){
			out.println("<strong>Fee Reimbursement </strong> : "+feereim+" <br> ");
}
if (!caste.equals("null")){
			out.println("<strong>Caste</strong> : "+caste+" <br> ");
}

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

if (request.getParameter("select1")==null){
	for(int i=1;i<34;i++){
			  out.println("<tr><th><center>");
			  out.println("<select name='select"+i+"' id='yearno'/>");
				out.println("<option value='null'>Select Column</option>");
				out.println("<option value='Roll Number'>Roll Number</option>");
				out.println("<option value='Name'>Name</option>");
				out.println("<option value='Father Name'>Father Name</option>");
				out.println("<option value='Mother Name'>Mother Name</option>");
				out.println("<option value='Date Of Birth'>Date Of Birth</option>");
				out.println("<option value='Place Of Birth'>Place Of Birth</option>");
				out.println("<option value='Course'>Course</option>");
				out.println("<option value='Branch'>Branch</option>");
				out.println("<option value='Year of Study'>Year of Study</option>");
				out.println("<option value='Gender'>Gender</option>");
				out.println("<option value='Fee Reim.'>Fee Reim.</option>");
				out.println("<option value='Caste'>Caste</option>");
				out.println("<option value='SubCaste'>SubCaste</option>");
				out.println("<option value='Caste Sl.No'>Caste Sl.No</option>");
				out.println("<option value='Students Mobile No.'>Students Mobile No.</option>");
				out.println("<option value='Guardians Mobile No.'>Guardians Mobile No.</option>");
				out.println("<option value='Email Address'>Email Address</option>");
				out.println("<option value='Address'>Address</option>");
				out.println("<option value='Identification Marks'>Identification Marks</option>");
				out.println("<option value='Aadhar No.'>Aadhar No.</option>");
				out.println("<option value='Annual Income'>Annual Income</option>");
				out.println("<option value='Rank'>Rank</option>");
				out.println("<option value='Date of Joining'>Date of Joining</option>");
				out.println("<option value='TC Issued on'>TC Issued on</option>");
				out.println("<option value='Bonafide Issued on'>Bonafide Issued on</option>");
				out.println("<option value='Conduct Issued on'>Conduct Issued on</option>");
				out.println("<option value='Migration Issued on'>Migration Issued on</option>");
				out.println("<option value='Remarks'>Remarks</option>");
				out.println("<option value='SSC Certificate Submitted'>SSC Certificate Submitted</option>");
				out.println("<option value='Previous years Certificate Submitted'>Previous years Certificate Submitted</option>");
				out.println("<option value='Previous years TC Submitted'>Previous years TC Submitted</option>");
				out.println("<option value='Photos Submitted'>Photos Submitted</option>");
				out.println("</select></center>");
			out.println("</th></tr>");
	}
	out.println("</form>");
}else{

for(int i=1;i<34;i++){
if (!(request.getParameter("select"+i)).equals("null")){
		out.println("<th>"+request.getParameter("select"+i)+"</th>");
	}
}

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
 while(rs.next()){
 out.println("<tr>");
for(int i=1;i<34;i++){
if (!(request.getParameter("select"+i)).equals("null")){
	if ((request.getParameter("select"+i)).equals("Roll Number")){
			out.println("<td>"+rs.getString(1)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Name")){
			out.println("<td>"+rs.getString(7)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Father Name")){
			out.println("<td>"+rs.getString(8)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Mother Name")){
			out.println("<td>"+rs.getString(9)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Date Of Birth")){
			out.println("<td>"+rs.getString(10)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Place Of Birth")){
			out.println("<td>"+rs.getString(11)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Course")){
			out.println("<td>"+rs.getString(4)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Branch")){
			out.println("<td>"+rs.getString(5)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Year of Study")){
			out.println("<td>"+rs.getString(6)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Gender")){
			out.println("<td>"+rs.getString(35)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Fee Reim.")){
			out.println("<td>"+rs.getString(34)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Caste")){
			out.println("<td>"+rs.getString(13)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("SubCaste")){
			out.println("<td>"+rs.getString(14)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Caste Sl.No")){
			out.println("<td>"+rs.getString(17)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Students Mobile No.")){
			out.println("<td>"+rs.getString(19)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Guardians Mobile No.")){
			out.println("<td>"+rs.getString(20)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Email Address")){
			out.println("<td>"+rs.getString(21)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Address")){
			out.println("<td>"+rs.getString(18)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Identification Marks")){
			out.println("<td>"+rs.getString(22)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Aadhar No")){
			out.println("<td>"+rs.getString(12)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Annual Income")){
			out.println("<td>"+rs.getString(15)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Rank")){
			out.println("<td>"+rs.getString(16)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Date of Joining")){
			out.println("<td>"+rs.getString(3)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("TC Issued on")){
			out.println("<td>"+rs.getString(30)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Bonafide Issued on")){
			out.println("<td>"+rs.getString(31)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Conduct Issued on")){
			out.println("<td>"+rs.getString(32)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Migration Issued on")){
			out.println("<td>"+rs.getString(33)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Remarks")){
			out.println("<td>"+rs.getString(29)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("SSC Certificate Submitted")){
			out.println("<td>"+rs.getString(36)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Previous years Certificate Submitted")){
			out.println("<td>"+rs.getString(37)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Previous years TC Submitted")){
			out.println("<td>"+rs.getString(38)+"</td>");
		}
	if ((request.getParameter("select"+i)).equals("Photos Submitted")){
			out.println("<td>"+rs.getString(39)+"</td>");
		}
	}
}
out.println("</tr>");
}
out.println("</table>");


  PreparedStatement c=con.prepareStatement("select count(rollno) from student where "+clause+" ;");
  //c.setString(1,clause);
  ResultSet cs = c.executeQuery();
  cs.next();
 out.println("<br><br><center><em><strong> Total </strong> : "+cs.getString(1)+" Students</em><br><br>");

}
out.println("</table>");
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
