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
        System.out.println("���ڹ���LoginServlet***");
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("���ڳ�ʼ��LoginServlet***");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//��post�����ύ�����ݽ��н���
		request.setCharacterEncoding("UTF-8");
		//responseҪ����������������ַ���
		response.setCharacterEncoding("UTF-8");
		
		//��ȡ�ύҳ����˺���������
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		try {
			User user = new UserDaoImpl().getAllUserByAccount(account);
			if (user != null && !user.getPassword().equals(password)) {
				response.sendRedirect("/ChatProject/login.jsp");
				return ;
			}
			else {
				//�����û��浽session��
				request.getSession().setAttribute("user", user);
				//�õ����Ѿ�������appication���е�users��message����
				ArrayList<User> users = (ArrayList<User>) getServletConfig().getServletContext().getAttribute("users");
				ArrayList<String> message = (ArrayList<String>) getServletConfig().getServletContext().getAttribute("message");
				users.add(user);
				message.add(user.getCname()+"������");
				response.sendRedirect("/ChatProject/chatForm.jsp");
			}
			response.getWriter().println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
