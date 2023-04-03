package be.pxl.ja.h8_files.factory;

public class User {

	private String name;
	private String email;
	private String phone;
	private Preference preference;

	public User(String name, String email, String phone, Preference preference) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.preference = preference;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}


	public String getPhone() {
		return phone;
	}

	public Preference getPreference() {
		return preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}
}
