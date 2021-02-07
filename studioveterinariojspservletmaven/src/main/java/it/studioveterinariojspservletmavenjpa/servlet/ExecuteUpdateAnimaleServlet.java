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

@WebServlet("/ExecuteUpdateAnimaleServlet")
public class ExecuteUpdateAnimaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteUpdateAnimaleServlet() {
		super();
	}

	private Utility utility;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idEntryStringParam = request.getParameter("idAnimale");
		String nomeInputParam= request.getParameter("nome");
		String razzaInputParam = request.getParameter("razza");
		String etaInputStringParam = request.getParameter("eta");
		String dataPrenotazioneStringParam = request.getParameter("dataPrenotazione");

		Date dataPrenotazioneParsed = utility.parseDatePrenotazioneFromString(dataPrenotazioneStringParam);

		Long idEntryParsedLong = utility.parseIdEntryToLongFromString(idEntryStringParam);

		if (!utility.validateInput(nomeInputParam, razzaInputParam, etaInputStringParam, dataPrenotazioneStringParam)
				|| dataPrenotazioneParsed == null) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/animale/update.jsp").forward(request, response);
			return;
		}

		Animale animaleUpdate;
		try {
			animaleUpdate=MyServiceFactory.getAnimaleServiceInstance().caricaSingoloElemento(idEntryParsedLong);
			animaleUpdate.setNome(nomeInputParam);
			animaleUpdate.setRazza(razzaInputParam);
			animaleUpdate.setEta(Integer.parseInt(etaInputStringParam));
			animaleUpdate.setDataPrenotazione(dataPrenotazioneParsed);
			
					MyServiceFactory.getAnimaleServiceInstance().aggiorna(animaleUpdate);

			request.setAttribute("listaAnimaliAttribute", MyServiceFactory.getAnimaleServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione di aggiornamento effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Errori nell'esecuzione dell'update di animale");
			request.getRequestDispatcher("/animale/update.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/animale/results.jsp").forward(request, response);

	}




}