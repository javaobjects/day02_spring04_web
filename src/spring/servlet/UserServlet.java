package spring.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import spring.IUserDao;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取IOC容器
		WebApplicationContext factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
	
		//2.获取UserDao
		IUserDao userDao = (IUserDao)factory.getBean("userDao");
		IUserDao userDao2 = (IUserDao)factory.getBean("userDao");
		
		System.out.println(userDao == userDao2);
		System.out.println(userDao.equals(userDao2));  
		
		System.out.println("UserServlet.userDao:" + userDao);
		System.out.println("UserServlet.userDao2:" + userDao2);
		
		//request.getRequestDispatcher("/Servlet2").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/Servlet2");
	}

}
