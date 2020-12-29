package data;

import consts.ListID;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private static UserInfo instance;

	private String login;

	private HashMap<ListID, ListOfFilms> allLists;

	private boolean access;

	private boolean saved;

	private Personalization personalization;

	public UserInfo(String login)
	{
		this.login = login;
		allLists = new HashMap<>();
		for(ListID listID: ListID.values())
		{
			allLists.put(listID, new ListOfFilms(listID));
		}
	}
	public ListOfFilms getFilmList(ListID listID)
	{
		return allLists.get(listID);
	}

	public static synchronized UserInfo getInstance() throws IOException {
		if (instance == null) {
			instance = new UserInfo("login");
		}
		return instance;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPersonalization(Personalization personalization) {
		this.personalization = personalization;
	}

	public Personalization getPersonalization() {
		return personalization;
	}
}
