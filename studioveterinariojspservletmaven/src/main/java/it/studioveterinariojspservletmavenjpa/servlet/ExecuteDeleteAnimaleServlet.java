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

@WebServlet("/ExecuteDeleteAnimaleServlet")
public class ExecuteDeleteAnimaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteAnimaleServlet() {
		super();
	}

	private Utility utility;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idEntryStringParam = request.getParameter("idAnimale");

		Long idEntryParsedLong = utility.parseIdEntryToLongFromString(idEntryStringParam);

		try {
			Animale animaleDelete = MyServiceFactory.getAnimaleServiceInstance()
					.caricaSingoloElemento(idEntryParsedLong);

			MyServiceFactory.getAnimaleServiceInstance().rimuovi(animaleDelete);

			request.setAttribute("listaAnimaliAttribute", MyServiceFactory.getAnimaleServiceInstance().listAll());

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione, vi è il verificarsi di un'errore.");
			request.getRequestDispatcher("/animale/delete.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/animale/results.jsp").forward(request, response);
	}

}
