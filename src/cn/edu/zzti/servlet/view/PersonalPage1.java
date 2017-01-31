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

public class PersonalPage1 extends HttpServlet {

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
		out.println("  <HEAD><TITLE>WebӦ����ҳ</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("��ǰ��¼���û��ǣ�"+user.getUsername());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		out.println("����¼ʱ�䣺"+sdf.format(user.getLoginTime()));
		out.println("<br><a href='IndexView'>������ҳ</a><br>");
		String info = request.getParameter("info");
		if(info!=null){
			out.println("<br><font color='red'>"+info+"</font><br>");
		}
		/*
		if(getServletContext().getAttribute(user.getUsername())==null){
			getServletContext().setAttribute(user.getUsername(), new PersonalInfo());
		}
		PersonalInfo p = (PersonalInfo)getServletContext().getAttribute(user.getUsername());
		*/
		String body = " <form action='PersonalPage2' method='post'>"
				+"<table>"
				+ "<tr><td>���䣺</td><td><input type='text' name='age'/></td></tr>"
				+ "<tr><td>�Ա�</td><td><input type='radio' name='gender' checked='checked' value='Ů'/>Ů"
				+ "<input type='radio' name='gender' value='��'/>��</td></tr>"
				+ "<tr><td>��ͥסַ��</td><td><input type='text' name='address'/></td></tr>"
				+ "<tr><td>��ϵ��ʽ��</td><td><input type='text' name='tel'/></td></tr>"
				+ "<tr><td>email��</td><td><input type='text' name='email'/></td></tr>"
				+ "<tr><td>" 
				/*+ "<input type='hidden' name='requestType' value='next'>" */
				+ "</td>"
				+ "<td><input type='submit' value='��һ��'></td></tr>" 
				+"</table>"
				+ "</form>";
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
