package it.studioveterinariojspservletmavenjpa.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.studioveterinariojspservletmavenjpa.dao.AnimaleDAO;
import it.studioveterinariojspservletmavenjpa.listener.LocalEntityManagerFactoryListener;
import it.studioveterinariojspservletmavenjpa.model.Animale;

public class AnimaleServiceImpl implements AnimaleService {

	private AnimaleDAO animaleDao;

	public void setAnimaleDao(AnimaleDAO animaleDao) {
		this.animaleDao = animaleDao;
	}

	@Override
	public List<Animale> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			animaleDao.setEntityManager(entityManager);

			return animaleDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Animale caricaSingoloElemento(Long idInput) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			animaleDao.setEntityManager(entityManager);

			return animaleDao.findById(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Animale input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			animaleDao.setEntityManager(entityManager);

			animaleDao.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void inserisciNuovo(Animale input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			animaleDao.setEntityManager(entityManager);

			animaleDao.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Animale input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {

			entityManager.getTransaction().begin();

			animaleDao.setEntityManager(entityManager);

			animaleDao.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Animale> findByExample(Animale input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {

			entityManager.getTransaction().begin();

			animaleDao.setEntityManager(entityManager);

			return animaleDao.findByExample(input);

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

}
