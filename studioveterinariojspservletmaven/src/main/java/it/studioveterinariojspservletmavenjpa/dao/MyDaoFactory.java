package it.studioveterinariojspservletmavenjpa.dao;

public class MyDaoFactory {
	private static AnimaleDAO animaleDaoInstance = null;

	public static AnimaleDAO getAnimaleDAOInstance() {
		if (animaleDaoInstance == null)
			animaleDaoInstance = new AnimaleDAOImpl();

		return animaleDaoInstance;
	}
}
