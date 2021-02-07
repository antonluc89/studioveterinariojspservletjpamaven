package it.studioveterinariojspservletmavenjpa.dao;

import java.util.List;

import it.studioveterinariojspservletmavenjpa.model.Animale;

public interface AnimaleDAO extends IBaseDAO<Animale> {

	public List<Animale> findByExample(Animale input) throws Exception;

}
