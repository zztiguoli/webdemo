package cn.edu.zzti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.entity.PersonalInfo;
import cn.edu.zzti.entity.User;

public class PersonalInfoProcess extends HttpServlet {

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
		doPost(request, response);
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
		request.setCharacterEncoding("utf-8");
		Object loginTag = request.getSession().getAttribute("user");
		if(loginTag==null){		
			response.sendRedirect("LoginPageView");
			return;
		}
		User user = (User)loginTag;
		String requestType = request.getParameter("requestType");
		if(requestType == null){
			request.setAttribute("info", "您还没有完善个人信息，请进行完善");
			request.getRequestDispatcher("PersonalPage1").forward(request, response);
			return;
		}else{
			String targetPath = "PersonalInfoView";
			PersonalInfo p = new PersonalInfo();
			p.setAge(Integer.parseInt(request.getParameter("age")));
			p.setGender(request.getParameter("gender"));
			p.setAddress(request.getParameter("address"));
			p.setTel(request.getParameter("tel"));
			p.setEmail(request.getParameter("email"));
			p.setHighestEducation(request.getParameter("highestEducation"));
			p.setGraduateSchool(request.getParameter("graduateSchool"));
			p.setMajor("major");
			getServletContext().setAttribute(user.getUsername(), p);
			response.sendRedirect(targetPath);
			/*if("next".equals(requestType)){
				PersonalInfo p = new PersonalInfo();
				p.setAge(Integer.parseInt(request.getParameter("age")));
				p.setGender(request.getParameter("gender"));
				p.setAddress(request.getParameter("address"));
				p.setTel(request.getParameter("tel"));
				p.setEmail(request.getParameter("email"));
				
				getServletContext().setAttribute(user.getUsername(), p);
				request.setAttribute("p", p);
				targetPath = "PersonalPage2";
				request.getRequestDispatcher(targetPath).forward(request, response);
			}else if("save".equals(requestType)){
				Object op = request.getAttribute("p");
				if(op!=null){
					PersonalInfo p = (PersonalInfo)op;
					p.setHighestEducation(request.getParameter("highestEducation"));
					p.setGraduateSchool(request.getParameter("graduateSchool"));
					p.setMajor("major");
					getServletContext().setAttribute(user.getUsername(), p);
				}
				response.sendRedirect(targetPath);
				
			}*/
		}
		
		
	}

}
