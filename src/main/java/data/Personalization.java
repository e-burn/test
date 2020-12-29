package data;

import java.io.IOException;
import java.io.Serializable;

public class Personalization implements Serializable {

	private static Personalization instance;

	private String backgroundColor;

	private String backgroundPicture;

	private String profilePicture;

	public Personalization() {
	}

	public static synchronized Personalization getInstance() throws IOException {
		if (instance == null) {
			instance = new Personalization();
		}
		return instance;
	}

	public void setBackgroundColor (String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setBackgroundPicture (String backgroundPicture) {
		this.backgroundPicture = backgroundPicture;
	}

	public void setProfilePicture (String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getBackgroundColor () {
		return backgroundColor;
	}

	public String getBackgroundPicture () {
		return backgroundPicture;
	}

	public String getProfilePicture () {
		return profilePicture;
	}

}
