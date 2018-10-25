package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Msgdb;
import po.Message;

/**
 * Servlet implementation class InsertMsg
 */
@WebServlet("/InsertMsg")
public class InsertMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		Message m = new Message();
		m.setUser(user);
		m.setEmail(email);
		m.setContent(content);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		m.setTime(sdf.format(new Date()));
		Msgdb.insertMsg(m);
		request.getRequestDispatcher("ShowMsg?pIndex=1").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
