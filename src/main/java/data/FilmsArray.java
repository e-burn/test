package data;

import java.io.Serializable;
import java.util.ArrayList;

public class FilmsArray implements Serializable {

	private ArrayList<String> films;

	public FilmsArray()
	{
		films = new ArrayList<>();
	}

	public ArrayList<String> getFilms()
	{
		return films;
	}

}
