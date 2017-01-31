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
 * չ�ָ�����Ϣ
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
			request.setAttribute("info", "����û�����Ƹ�����Ϣ�����������");
			request.getRequestDispatcher("PersonalPage1").forward(request, response);
			return;
		}
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>WebӦ����ҳ</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("��ǰ��¼���û��ǣ�"+user.getUsername());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		out.println("����¼ʱ�䣺"+sdf.format(user.getLoginTime()));
		out.println("<br><a href='IndexView'>������ҳ</a>");
		
		String body="<table><tr><td>���䣺</td><td>" + p.getAge()+
				"</td></tr><tr><td>�Ա�</td><td>" + p.getGender()+
				"</td></tr><tr><td>��ͥסַ��</td><td>" +p.getAddress()+
				"</td></tr><tr><td>��ϵ��ʽ��</td><td>" +p.getTel()+
				"</td></tr><tr><td>email��</td><td>" +p.getEmail()+
				"</td></tr><tr><td>��ҵԺУ��</td><td>" +p.getGraduateSchool()+
				"</td></tr><tr><td>���ѧ����</td><td>" +p.getHighestEducation()+
				"</td></tr><tr><td>רҵ����</td><td>" +p.getMajor()+
				"</td></tr></table>";
		
		out.println(body);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
