package cn.edu.zzti.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.entity.PersonalInfo;
import cn.edu.zzti.entity.User;

public class PersonalPage2 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Object loginTag = request.getSession().getAttribute("user");
		if(loginTag==null){		
			response.sendRedirect("LoginPageView");
			return;
		}
		User user = (User)loginTag;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>Web应用首页</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("当前登录的用户是："+user.getUsername());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		out.println("，登录时间："+sdf.format(user.getLoginTime()));
		out.println("<br><a href='IndexView'>进入首页</a><br>");
		
		PersonalInfo p = (PersonalInfo)request.getAttribute("p");
		String body = "<form action='PersonalInfoProcess' method='post'>" 
				+ "<table>"
				+ "<tr><td>最高学历：</td>"
				+ "<td><select name='highestEducation'>"
				+ "<option value='学士'>学士</option>"
				+ "<option value='硕士'>硕士</option>"
				+ "<option value='博士'>博士</option>"
				+ "<option value='其他'>其他</option>" + "</select></td></tr>"
				+ "<tr><td>毕业院校：</td>" 
				+ "<td><select name='graduateSchool'>"
				+ "<option value='北京大学'>北京大学</option>"
				+ "<option value='清华大学'>清华大学</option>"
				+ "<option value='其他院校'>其他院校</option>" + "</select></td></tr>"
				+ "<tr><td>所学专业：</td>" 
				+ "<td><input type='text' name='major'/></td></tr>"
				+ "<tr><td>" 
				+ "<input type='hidden' name='requestType' value='save'>" 
				+ "<input type='hidden' name='age' value='"+request.getParameter("age")+"'>" 
				+ "<input type='hidden' name='gender' value='"+request.getParameter("gender")+"'>" 
				+ "<input type='hidden' name='address' value='"+request.getParameter("address")+"'>" 
				+ "<input type='hidden' name='tel' value='"+request.getParameter("tel")+"'>" 
				+ "<input type='hidden' name='email' value='"+request.getParameter("email")+"'>" 
				+ "</td>"
				+ "<td><input type='submit' value='保存'></td></tr>"
				+ "</table>"
				+ " </form>";
		out.println(body);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
