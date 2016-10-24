package com.panda.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.panda.dao.UserDaoImpl;
import com.panda.vo.User;

/**
 * 
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        System.out.println("正在构造LoginServlet***");
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("正在初始化LoginServlet***");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//对post方法提交的数据进行解码
		request.setCharacterEncoding("UTF-8");
		//response要有输出。必须设置字符集
		response.setCharacterEncoding("UTF-8");
		
		//获取提交页面的账号名和密码
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		try {
			User user = new UserDaoImpl().getAllUserByAccount(account);
			if (user != null && !user.getPassword().equals(password)) {
				response.sendRedirect("/ChatProject/login.jsp");
				return ;
			}
			else {
				//将该用户存到session中
				request.getSession().setAttribute("user", user);
				//得到早已经存在于appication域中的users、message属性
				ArrayList<User> users = (ArrayList<User>) getServletConfig().getServletContext().getAttribute("users");
				ArrayList<String> message = (ArrayList<String>) getServletConfig().getServletContext().getAttribute("message");
				users.add(user);
				message.add(user.getCname()+"上线啦");
				response.sendRedirect("/ChatProject/chatForm.jsp");
			}
			response.getWriter().println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
