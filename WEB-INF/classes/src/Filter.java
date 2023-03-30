import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Filter extends HttpServlet {
public Filter(){}
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();

String course= request.getParameter("course");
String branch = request.getParameter("branch");
String yos = request.getParameter("yos");
String caste = request.getParameter("caste");
String feereim = request.getParameter("feereim");
String gen = request.getParameter("gen");

String user= request.getParameter("user");
String pass="null";
if(user!=null){
	pass = request.getParameter("pass");
}
try{
  Class.forName("com.mysql.jdbc.Driver");
  Connection con;
if(user==null){
  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oshp","root","pass");
}else{
  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oshp",user,pass);
}
  out.println("<html><title>Student Details</title>");
   out.println("<link rel= 'icon' href= '/bcsctc/Images/logo.png' type= 'image/x-icon'>");
   out.println("<body style='background-color:#f5f5f5'>");
   out.println("<center>");
   out.println("<a href='/bcsctc'><img alt='LOGO' src='/bcsctc/Images/image-preview.jpg' style='max-width:100%;height:auto;' /></a></center>");

   out.println("<form method='post'>");
	out.println("<input type='hidden' value='"+course+"' name='course' />");
	out.println("<input type='hidden' value='"+branch+"' name='branch' />");
	out.println("<input type='hidden' value='"+yos+"' name='yos' />");
	out.println("<input type='hidden' value='"+feereim+"' name='feereim' />");
	out.println("<input type='hidden' value='"+gen+"' name='gen' />");
	out.println("<input type='hidden' value='"+caste+"' name='caste' />");
   out.println("<p style='text-align:right'><input placeholder='Find . . . ' size='15' id='searchText'><button onclick='search()'>Find</button>");
if(user==null){
   out.println(" <button onclick='window.print()'>Print Full Table</button>");
   out.println(" <input type='submit' value='Configure Table & Print' formaction='PrintFilter' />");
}
   out.println("</form></p>");
   out.println("<script>");
		out.println("function search() {");
   out.println("var searchText = document.getElementById('searchText').value;");
   out.println("var found = window.find(searchText);");
	out.println("}");
	out.println("</script>");
	out.println("<div class='searchText'>");
if(user==null){
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
}else{
   out.println("<form method='post'>");
	out.println("<input type='hidden' value='"+course+"' name='course' />");
	out.println("<input type='hidden' value='"+branch+"' name='branch' />");
	out.println("<input type='hidden' value='"+yos+"' name='yos' />");
	out.println("<input type='hidden' value='"+feereim+"' name='feereim' />");
	out.println("<input type='hidden' value='"+gen+"' name='gen' />");
	out.println("<input type='hidden' value='"+caste+"' name='caste' />");
	if (!course.equals("null")){
				out.println("<strong>Course</strong>: "+course+"  ");
				out.println("<input type='hidden' value='7' name='val' />");
		    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/><br>");
	}
	if (!branch.equals("null")){
				out.println("<strong>Branch</strong>: "+branch+"  ");
				out.println("<input type='hidden' value='8' name='val' />");
		    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/><br>");
	}
	if (!yos.equals("null")){
				out.println("<strong>Year of Study</strong> : "+yos+"  ");
				out.println("<input type='hidden' value='9' name='val' />");
		    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/><br>");
	}
	if (!gen.equals("null")){
				out.println("<strong>Gender</strong>: "+gen+"  ");
				out.println("<input type='hidden' value='10' name='val' />");
		    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/><br>");
	}
	if (!feereim.equals("null")){
				out.println("<strong>Fee Reimbursement </strong> : "+feereim+"  ");
				out.println("<input type='hidden' value='11' name='val' />");
		    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/><br>");
	}
	if (!caste.equals("null")){
				out.println("<strong>Caste</strong> : "+caste+"  ");
				out.println("<input type='hidden' value='12' name='val' />");
		    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/><br>");
	}
	out.println("</form>");
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
if(user==null){
   out.println("<form method='post'><p style='text-align:right'>");
	out.println("<input type='hidden' value='"+course+"' name='course' />");
	out.println("<input type='hidden' value='"+branch+"' name='branch' />");
	out.println("<input type='hidden' value='"+yos+"' name='yos' />");
	out.println("<input type='hidden' value='"+feereim+"' name='feereim' />");
	out.println("<input type='hidden' value='"+gen+"' name='gen' />");
	out.println("<input type='hidden' value='"+caste+"' name='caste' />");
   out.println("<input type='password' placeholder='Enter Username' name='user' size='11' />");
   out.println("<input type='password' placeholder='Enter Password' name='pass' size='11' />");
   out.println("<input type='submit' value='Edit Details' formaction='Filter'/>");
   out.println("</p></form>");
   out.println("<table>");
}

if(user!=null){
		out.println("<br><table>");
	  out.println("<tr>");
	// for(int i=1;i<7;i++){
	out.println("<td></td>");
	for(int i=2;i<7;i++){
	  out.println("<form method='post'>");
	  	out.println("<input type='hidden' value='"+course+"' name='course' />");
			out.println("<input type='hidden' value='"+branch+"' name='branch' />");
			out.println("<input type='hidden' value='"+yos+"' name='yos' />");
			out.println("<input type='hidden' value='"+feereim+"' name='feereim' />");
			out.println("<input type='hidden' value='"+gen+"' name='gen' />");
			out.println("<input type='hidden' value='"+caste+"' name='caste' />");
    out.println("<td><input type='hidden' value='"+i+"' name='val' />");
    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/></td></form>");
    }
	  out.println("<form method='post'>");
	  	out.println("<input type='hidden' value='"+course+"' name='course' />");
			out.println("<input type='hidden' value='"+branch+"' name='branch' />");
			out.println("<input type='hidden' value='"+yos+"' name='yos' />");
			out.println("<input type='hidden' value='"+feereim+"' name='feereim' />");
			out.println("<input type='hidden' value='"+gen+"' name='gen' />");
			out.println("<input type='hidden' value='"+caste+"' name='caste' />");
   if (course.equals("null")){
    out.println("<td><input type='hidden' value='7' name='val' />");
    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/></td>");
	 }
	 if (branch.equals("null")){
    out.println("<td><input type='hidden' value='8' name='val' />");
    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/></td>");
	 }
	 if (yos.equals("null")){
    out.println("<td><input type='hidden' value='9' name='val' />");
    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/></td>");
	 }
	 if (gen.equals("null")){
    out.println("<td><input type='hidden' value='10' name='val' />");
    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/></td>");
	 }
	 if (feereim.equals("null")){
    out.println("<td><input type='hidden' value='11' name='val' />");
    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/></td>");
	 }
	 if (caste.equals("null")){
    out.println("<td><input type='hidden' value='12' name='val' />");
    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/></td>");
	 }
	out.println("</form>");
	for(int i=13;i<29;i++){
	  out.println("<form method='post'>");
	  	out.println("<input type='hidden' value='"+course+"' name='course' />");
			out.println("<input type='hidden' value='"+branch+"' name='branch' />");
			out.println("<input type='hidden' value='"+yos+"' name='yos' />");
			out.println("<input type='hidden' value='"+feereim+"' name='feereim' />");
			out.println("<input type='hidden' value='"+gen+"' name='gen' />");
			out.println("<input type='hidden' value='"+caste+"' name='caste' />");
    out.println("<td><input type='hidden' value='"+i+"' name='val' />");
    out.println("<input type='submit' value='Edit' formaction='FilterEdit'/></td></form>");
    }
  out.println("</tr>");
}
			  out.println("<tr>");
				out.println("<th>Roll Number</th>");
				out.println("<th>Name</th>");
				out.println("<th>Father Name</th>");
				out.println("<th>Mother Name</th>");
				out.println("<th>Date Of Birth</th>");
				out.println("<th>Place Of Birth</th>");

String clause=" True";
if (course.equals("null")){
				out.println("<th>Course</th>");
}else{
	clause = clause + " AND course='" + course +"'";
}
if (branch.equals("null")){
				out.println("<th>Branch</th>");
}else{
	clause = clause + " AND branch='" + branch+"'";
}
if (yos.equals("null")){
				out.println("<th>Year of Study</th>");
}else{
	clause = clause + " AND yos='" + yos+"'";
}
if (gen.equals("null")){
				out.println("<th>Gender</th>");
}else{
	clause = clause + " AND gen='" + gen+"'";
}
if (feereim.equals("null")){
				out.println("<th>Fee Reim.</th>");
}else{
	clause = clause + " AND feereim='" + feereim+"'";
}
if (caste.equals("null")){
				out.println("<th>Caste</th>");
}else{
	clause = clause + " AND caste='" + caste+"'";
}
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

 PreparedStatement ps=con.prepareStatement("select * from student where "+clause+" ;");
 //ps.setString(1,clause);
 ResultSet rs = ps.executeQuery();
 while(rs.next()){

		out.println("<tr>");
			out.println("<td>"+rs.getString(1)+"</td>");
			out.println("<td>"+rs.getString(7)+"</td>");
			out.println("<td>"+rs.getString(8)+"</td>");
			out.println("<td>"+rs.getString(9)+"</td>");
			out.println("<td>"+rs.getString(10)+"</td>");
			out.println("<td>"+rs.getString(11)+"</td>");
if (course.equals("null")){
			out.println("<td>"+rs.getString(4)+"</td>");
}
if (branch.equals("null")){
			out.println("<td>"+rs.getString(5)+"</td>");
}
if (yos.equals("null")){
			out.println("<td>"+rs.getString(6)+"</td>");
}
if (gen.equals("null")){
			out.println("<td>"+rs.getString(35)+"</td>");
}
if (feereim.equals("null")){
			out.println("<td>"+rs.getString(34)+"</td>");
}
if (caste.equals("null")){
			out.println("<td>"+rs.getString(13)+"</td>");
}
			out.println("<td>"+rs.getString(14)+"</td>");
			out.println("<td>"+rs.getString(17)+"</td>");
			out.println("<td>"+rs.getString(19)+"</td>");
			out.println("<td>"+rs.getString(20)+"</td>");
			out.println("<td>"+rs.getString(21)+"</td>");
			out.println("<td>"+rs.getString(18)+"</td>");
			out.println("<td>"+rs.getString(22)+"</td>");
			out.println("<td>"+rs.getString(12)+"</td>");
			out.println("<td>"+rs.getString(15)+"</td>");
			out.println("<td>"+rs.getString(16)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td>"+rs.getString(30)+"</td>");
			out.println("<td>"+rs.getString(31)+"</td>");
			out.println("<td>"+rs.getString(32)+"</td>");
			out.println("<td>"+rs.getString(33)+"</td>");
			out.println("<td>"+rs.getString(29)+"</td>");
		out.println("</tr>");

 }
out.println("</table>");

  PreparedStatement c=con.prepareStatement("select count(rollno) from student where "+clause+" ;");
  //c.setString(1,clause);
  ResultSet cs = c.executeQuery();
  cs.next();
 out.println("<br><br><center><em><strong> Total </strong> : "+cs.getString(1)+" Students</em><br><br>");
 if (feereim.equals("YES")){
 			out.println("<form method='post' action='EpassBCF'>");
 			out.println("<input type='hidden' value='"+course+"' name='course' />");
 			out.println("<input type='hidden' value='"+branch+"' name='branch' />");
 			out.println("<input type='hidden' value='"+yos+"' name='yos' />");
 			out.println("<input type='hidden' value='"+feereim+"' name='feereim' />");
 			out.println("<input type='hidden' value='"+gen+"' name='gen' />");
			out.println("<input type='hidden' value='"+caste+"' name='caste' />");
out.println("<select name='acyear' id='yearRangeSelect'>");
  out.println("<option value='null'>Select Academic Year</option>");
out.println("</select>");
out.println("<script>");
  out.println("const select = document.getElementById('yearRangeSelect');");
  out.println("for (let year = 2009; year <= 2100;year += 1) {");
    out.println("const yearRange = `${year}-${year + 1}`;");
    out.println("const option = document.createElement('option');");
    out.println("option.value = yearRange;");
    out.println("option.text = yearRange;");
    out.println("select.add(option);");
  out.println("}");
out.println("</script>");
out.println("<select name='year' id='yearno'/>");
out.println("<option value='null'>Select Year</option>");
out.println("<option value='IV'>IV</option>");
out.println("<option value='III'>III</option>");
out.println("<option value='II'>II</option>");
out.println("<option value='I'>I</option>");
out.println("</select>");
out.println("<select name='sem' id='semno'/>");
out.println("<option value='null'>Select Semester</option>");
out.println("<option value='II'>II</option>");
out.println("<option value='I'>I</option>");
out.println("</select>");
 			out.println("<input type='submit' value='Generate & Print TS-Epass Bonafide Certificates' >");
 			out.println("</form></center>");
}
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
