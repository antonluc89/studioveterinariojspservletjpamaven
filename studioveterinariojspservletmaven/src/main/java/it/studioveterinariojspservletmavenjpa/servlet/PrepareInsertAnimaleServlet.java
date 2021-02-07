package it.studioveterinariojspservletmavenjpa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrepareInsertAnimaleServlet")
public class PrepareInsertAnimaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareInsertAnimaleServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/animale/insert.jsp").forward(request, response);

	}

}
