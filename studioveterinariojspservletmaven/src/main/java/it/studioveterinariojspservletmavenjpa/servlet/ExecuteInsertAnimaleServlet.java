package it.studioveterinariojspservletmavenjpa.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.studioveterinariojspservletmavenjpa.model.Animale;
import it.studioveterinariojspservletmavenjpa.service.MyServiceFactory;
import it.studioveterinariojspservletmavenjpa.utility.Utility;

@WebServlet("/ExecuteInsertAnimaleServlet")
public class ExecuteInsertAnimaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertAnimaleServlet() {
		super();
	}

	private Utility utility;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeInputParam = request.getParameter("nome");
		String razzaInputParam = request.getParameter("razza");
		String etaInputStringParam = request.getParameter("eta");
		String dataPrenotazioneStringParam = request.getParameter("dataPrenotazione");

		Date dataPrenotazioneParsed = utility.parseDatePrenotazioneFromString(dataPrenotazioneStringParam);

		if (!utility.validateInput(nomeInputParam, razzaInputParam, etaInputStringParam,
				dataPrenotazioneStringParam) || dataPrenotazioneParsed == null) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/animale/insert.jsp").forward(request, response);
			return;
		}

		Animale animaleInsert = new Animale(nomeInputParam, razzaInputParam, Integer.parseInt(etaInputStringParam),
				dataPrenotazioneParsed);
		try {
			MyServiceFactory.getAnimaleServiceInstance().inserisciNuovo(animaleInsert);
			request.setAttribute("listaAnimaliAttribute", MyServiceFactory.getAnimaleServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione, verificarsi di un'errore.");
			request.getRequestDispatcher("/animale/insert.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/animale/results.jsp").forward(request, response);

	}

}
