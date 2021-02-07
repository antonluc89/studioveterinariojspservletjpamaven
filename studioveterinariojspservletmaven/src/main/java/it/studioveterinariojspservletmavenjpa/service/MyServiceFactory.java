package it.studioveterinariojspservletmavenjpa.service;

import it.studioveterinariojspservletmavenjpa.dao.AnimaleDAO;
import it.studioveterinariojspservletmavenjpa.dao.AnimaleDAOImpl;

public class MyServiceFactory {
	private static AnimaleService ANIMALE_SERVICE_INSTANCE = null;
	private static AnimaleDAO ANIMALEDAO_INSTANCE = null;

	public static AnimaleService getAnimaleServiceInstance() {
		if (ANIMALE_SERVICE_INSTANCE == null)
			ANIMALE_SERVICE_INSTANCE = new AnimaleServiceImpl();

		if (ANIMALEDAO_INSTANCE == null)
			ANIMALEDAO_INSTANCE = new AnimaleDAOImpl();

		ANIMALE_SERVICE_INSTANCE.setAnimaleDao(ANIMALEDAO_INSTANCE);

		return ANIMALE_SERVICE_INSTANCE;
	}

}
