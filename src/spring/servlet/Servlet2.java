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

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取IOC容器
		WebApplicationContext factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
	
		//2.获取UserDao
		IUserDao userDao = (IUserDao)factory.getBean("userDao");
		IUserDao userDao2 = (IUserDao)factory.getBean("userDao");
		
		System.out.println("Servlet2:" + (userDao == userDao2));
		System.out.println("Servlet2:" + (userDao.equals(userDao2)));  
		
		System.out.println("Servlet2.userDao:" + userDao);
		System.out.println("Servlet2.userDao2:" + userDao2);
				
	}

}
