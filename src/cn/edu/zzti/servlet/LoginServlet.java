package cn.edu.zzti.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.entity.User;
import cn.edu.zzti.util.PathUtil;

public class LoginServlet extends HttpServlet {

	public String checkLogin(User user){
		String errorInfo=null;
		if(user.getUsername()==null||"".equals(user.getUsername().trim())
				||user.getPassword()==null||"".equals(user.getPassword().trim())){
			errorInfo = "用户名或者密码不能为空";
		}
		
		return errorInfo;
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username,password,new Date());
		String error = checkLogin(user);
		
		String basePath = PathUtil.getBasePath(request);
		String targetPath = basePath + "/servlet/IndexView";
		if(error==null){
			request.getSession().setAttribute("user", user);
		}else{
			targetPath = basePath + "/servlet/LoginPageView?error="+error;
		}
		response.sendRedirect(targetPath);
		
	}

}
