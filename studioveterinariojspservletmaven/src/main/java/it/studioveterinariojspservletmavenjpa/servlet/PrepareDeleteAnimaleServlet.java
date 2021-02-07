package it.studioveterinariojspservletmavenjpa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.studioveterinariojspservletmavenjpa.model.Animale;
import it.studioveterinariojspservletmavenjpa.service.MyServiceFactory;
import it.studioveterinariojspservletmavenjpa.utility.Utility;

@WebServlet("/PrepareDeleteAnimaleServlet")
public class PrepareDeleteAnimaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareDeleteAnimaleServlet() {
		super();
	}

	private Utility utility;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idEntryStringParam = request.getParameter("idAnimale");

		Long idEntryParsedLong = utility.parseIdEntryToLongFromString(idEntryStringParam);

		try {
			Animale animaleInputDelete = MyServiceFactory.getAnimaleServiceInstance()
					.caricaSingoloElemento(idEntryParsedLong);
			request.setAttribute("elimina_animale_attr", animaleInputDelete);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione, verificarsi di un'errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/animale/delete.jsp").forward(request, response);

	}

}
