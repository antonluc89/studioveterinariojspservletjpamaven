package it.studioveterinariojspservletmavenjpa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import it.studioveterinariojspservletmavenjpa.model.Animale;
import it.studioveterinariojspservletmavenjpa.service.MyServiceFactory;
import it.studioveterinariojspservletmavenjpa.utility.Utility;

@WebServlet("/PrepareUpdateAnimaleServlet")
public class PrepareUpdateAnimaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareUpdateAnimaleServlet() {

	}

	private Utility utility;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idEntryStringParam = request.getParameter("idAnimale");

		Long idEntryParsedLong = utility.parseIdEntryToLongFromString(idEntryStringParam);

		try {
			Animale animaleInputUpdate = MyServiceFactory.getAnimaleServiceInstance()
					.caricaSingoloElemento(idEntryParsedLong);
			request.setAttribute("update_animale_attr", animaleInputUpdate);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione, verificarsi di un'errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/animale/update.jsp").forward(request, response);

	}

}
