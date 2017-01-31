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
/**
 * 展现个人信息
 * @author guoli
 *
 */
public class PersonalInfoView extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object loginTag = request.getSession().getAttribute("user");
		if(loginTag==null){		
			response.sendRedirect("LoginPageView");
			return;
		}
		User user = (User)loginTag;
		PersonalInfo p = (PersonalInfo)getServletContext().getAttribute(user.getUsername());
		if(p==null){
			request.setAttribute("info", "您还没有完善个人信息，请进行完善");
			request.getRequestDispatcher("PersonalPage1").forward(request, response);
			return;
		}
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>Web应用首页</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("当前登录的用户是："+user.getUsername());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		out.println("，登录时间："+sdf.format(user.getLoginTime()));
		out.println("<br><a href='IndexView'>进入首页</a>");
		
		String body="<table><tr><td>年龄：</td><td>" + p.getAge()+
				"</td></tr><tr><td>性别：</td><td>" + p.getGender()+
				"</td></tr><tr><td>家庭住址：</td><td>" +p.getAddress()+
				"</td></tr><tr><td>联系方式：</td><td>" +p.getTel()+
				"</td></tr><tr><td>email：</td><td>" +p.getEmail()+
				"</td></tr><tr><td>毕业院校：</td><td>" +p.getGraduateSchool()+
				"</td></tr><tr><td>最高学历：</td><td>" +p.getHighestEducation()+
				"</td></tr><tr><td>专业方向：</td><td>" +p.getMajor()+
				"</td></tr></table>";
		
		out.println(body);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
