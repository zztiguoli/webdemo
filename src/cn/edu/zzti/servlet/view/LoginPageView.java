package cn.edu.zzti.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageView extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String error = request.getParameter("error");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>µÇÂ¼Ò³Ãæ</TITLE></HEAD>");
		out.println("  <BODY>");
		if(error!=null){
			out.println("ÇëÖØÐÂµÇÂ¼£º<font color='red'>"+error+"</font><br>");
		}
		String body=" <form action='LoginServlet' method='post'>"
				+" username:<input type='text' name='username'/><br/>" +
				"password:<input type='password' name='password'/><br/>" +
				"<input type='submit' value='µÇÂ¼'/></form>";
		out.println(body);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
