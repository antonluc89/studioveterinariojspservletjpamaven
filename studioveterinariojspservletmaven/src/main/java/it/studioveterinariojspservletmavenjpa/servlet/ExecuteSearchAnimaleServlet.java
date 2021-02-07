package it.studioveterinariojspservletmavenjpa.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import it.studioveterinariojspservletmavenjpa.model.Animale;
import it.studioveterinariojspservletmavenjpa.service.MyServiceFactory;
import it.studioveterinariojspservletmavenjpa.utility.Utility;


	@WebServlet("/ExecuteSearchAnimaleServlet")
	public class ExecuteSearchAnimaleServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		private Utility utility;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			String nomeInputParam = request.getParameter("nome");
			String razzaInputParam = request.getParameter("razza");
			String etaInputStringParam = request.getParameter("eta");
			String dataPrenotazioneStringParam = request.getParameter("dataPrenotazione");

			Date dataPrenotazioneParsed = utility.parseDatePrenotazioneFromString(dataPrenotazioneStringParam);

			Animale animaleSearch = new Animale(nomeInputParam, razzaInputParam,
					Integer.parseInt(etaInputStringParam), dataPrenotazioneParsed);

			try {
				List<Animale> listaWithfilterSearch = MyServiceFactory.getAnimaleServiceInstance()
						.findByExample(animaleSearch);
				request.setAttribute("listaAnimaliAttribute", listaWithfilterSearch);
				request.setAttribute("successMessage", "Operazione di ricerca effettuata con successo");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "Attenzione, verificarsi di un'errore.");
				request.getRequestDispatcher("/animale/search.jsp").forward(request, response);
				return;
			}

			request.getRequestDispatcher("/animale/results.jsp").forward(request, response);

		}


	}
