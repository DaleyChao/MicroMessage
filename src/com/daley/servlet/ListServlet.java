package com.daley.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.daley.service.ListService;

/**
 * ҳ���ʼ������
 * 
 * @author Daley 2016-11-28
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//����ҳ���ֵ
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		//��ҳ�洫ֵ
		request.setAttribute("command", command);
		request.setAttribute("description", description);
		try {
			ListService listService=new ListService();
			//��ѯ��Ϣ�б���ҳ��
			request.setAttribute("messageList", listService.queryMessageList(command, description));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/jsp/back/List.jsp").forward(
				request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
