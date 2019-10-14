package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args){

		//1.加载并且解析applicationContext.xml
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("----------IOC容器加载完成--------------------");
		
		//2.获取工厂中的IUserDao对象了
		IUserDao userDao = (IUserDao)factory.getBean("userDao"); 
		IUserDao userDao2 = (IUserDao)factory.getBean("userDao"); 
		
		System.out.println(userDao == userDao2);
		System.out.println(userDao.equals(userDao2));
	}

}
