package de.swen.pflege;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Tourplan enthält eine Liste von Klienten, die von der Pflegefachkfraft
 * behandelt werden sollten. Im Tourplan sollten keine redundanten Klientennamen
 * enthalten sein. Die Liste der Klienten wird in zwei Diensten geführt.
 *
 */
public class Tourplan {
	private CentralClientFinder centralFinder;
	private SapService service;
	private String name;

	Tourplan(String name, CentralClientFinder f, SapService s) {
		// Task 1: validate name of Pflege
		if (name == null)
			throw new IllegalArgumentException("Name der Pflege darf nicht 'null' sein.");
		if (name.length() < 3)
			throw new IllegalArgumentException("Name der Pflege muss min. 3 Zeichen lang sein.");
		if (name.length() > 31)
			throw new IllegalArgumentException("Name der Pflege darf max. 31 Zeichen lang sein.");

		this.name = name;
		centralFinder = f;
		service = s;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return Liste der Klienten (ohne Duplikate)
	 */
	public List<String> getClients() {

		List<String> list = new ArrayList<String>();
		list.addAll(centralFinder.getClients(name));
		list = addWithoutDuplicates(list, service.getSapClientsForName(name));

		// if list is empty, we also could return the list itself. With this way, we can
		// easily change the behavior in the future.
		return (list.isEmpty()) ? new ArrayList<String>() : list;
	}

	/**
	 * 
	 * @param list erste Liste mit Klienten
	 * @param l    zweite Liste mit Klienten
	 * @return bereinigte Liste der Klienten (keine Duplikate enthalten)
	 */
	private List<String> addWithoutDuplicates(List<String> list, List<String> l) {
		List<String> newList = new ArrayList<String>();
		newList.addAll(list);
		for (String string : l) {
			if (!newList.contains(string))
				newList.add(string);
		}
		return newList;
	}
}
