package it.studioveterinariojspservletmavenjpa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import it.studioveterinariojspservletmavenjpa.model.Animale;

public class AnimaleDAOImpl implements AnimaleDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Animale> list() throws Exception {
		return entityManager.createQuery("from Animale", Animale.class).getResultList();
	}

	@Override
	public Animale findById(Long id) throws Exception {
		return entityManager.find(Animale.class, id);
	}

	@Override
	public void update(Animale input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.merge(input);
	}

	@Override
	public void insert(Animale input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Animale input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public List<Animale> findByExample(Animale input) throws Exception {
		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereCause = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT a FROM Animale a ");

		if (!StringUtils.isEmpty(input.getNome())) {
			whereCause.add(" a.nome =:nome ");
			paramaterMap.put("nome", input.getNome());
		}

		if (!StringUtils.isEmpty(input.getRazza())) {
			whereCause.add(" a.razza =:razza ");
			paramaterMap.put("razza", input.getRazza());
		}

		if (input.getEta() != null && input.getEta() != 0) {
			whereCause.add(" a.eta =:eta ");
			paramaterMap.put("eta", input.getEta());
		}
		if (input.getDataPrenotazione() != null) {
			whereCause.add("a.dataprenotazione =:dataprenotazione ");
			paramaterMap.put("dataprenotazione", input.getDataPrenotazione());
		}

		queryBuilder.append(" where " + StringUtils.join(whereCause, " and "));
		TypedQuery<Animale> query = entityManager.createQuery(queryBuilder.toString(), Animale.class);

		for (String key : paramaterMap.keySet()) {
			query.setParameter(key, paramaterMap.get(key));
		}

		return query.getResultList();
	}

}
