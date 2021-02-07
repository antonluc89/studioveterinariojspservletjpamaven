package it.studioveterinariojspservletmavenjpa.service;

import java.util.List;

import it.studioveterinariojspservletmavenjpa.dao.AnimaleDAO;
import it.studioveterinariojspservletmavenjpa.model.Animale;

public interface AnimaleService {
	public void setAnimaleDao(AnimaleDAO animaleDao);

	public List<Animale> listAll() throws Exception;

	public Animale caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Animale input) throws Exception;

	public void inserisciNuovo(Animale input) throws Exception;

	public void rimuovi(Animale input) throws Exception;

	public List<Animale> findByExample(Animale input) throws Exception;
}
