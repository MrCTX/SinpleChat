package com.panda.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.panda.vo.User;

@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChatServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//post提交方式解码
		request.setCharacterEncoding("UTF-8");
		//得到message参数
		String message = request.getParameter("message");
		//取出application中的messages
		ArrayList<String> messages = (ArrayList<String>) 
				getServletConfig().getServletContext().getAttribute("message");
		User user = (User) request.getSession().getAttribute("user");
		//如果messages不为空，且提交的数据有参数
		if (messages != null && !"".equals(message)) {
			messages.add(user.getCname()+"说:"+message);
			response.sendRedirect("/ChatProject/chatForm.jsp");
		}
		
	}

}
