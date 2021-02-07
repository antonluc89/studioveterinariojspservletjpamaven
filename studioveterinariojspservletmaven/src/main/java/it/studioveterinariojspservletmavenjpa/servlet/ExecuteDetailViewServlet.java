package it.studioveterinariojspservletmavenjpa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.studioveterinariojspservletmavenjpa.service.MyServiceFactory;

@WebServlet("/ExecuteDetailViewServlet")
public class ExecuteDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParamAnimale = request.getParameter("idAnimale");

		if (!NumberUtils.isCreatable(idParamAnimale)) {
			request.setAttribute("errorMessage", "Attenzione, vi è il verificarsi di un'errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("view_animale_attr",
					MyServiceFactory.getAnimaleServiceInstance().caricaSingoloElemento(Long.parseLong(idParamAnimale)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione, vi è il verificarsi di un'errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/animale/show.jsp").forward(request, response);
	}

}
