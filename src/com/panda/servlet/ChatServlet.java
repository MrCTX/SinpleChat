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
		//post�ύ��ʽ����
		request.setCharacterEncoding("UTF-8");
		//�õ�message����
		String message = request.getParameter("message");
		//ȡ��application�е�messages
		ArrayList<String> messages = (ArrayList<String>) 
				getServletConfig().getServletContext().getAttribute("message");
		User user = (User) request.getSession().getAttribute("user");
		//���messages��Ϊ�գ����ύ�������в���
		if (messages != null && !"".equals(message)) {
			messages.add(user.getCname()+"˵:"+message);
			response.sendRedirect("/ChatProject/chatForm.jsp");
		}
		
	}

}
