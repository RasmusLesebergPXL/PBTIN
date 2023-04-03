package be.pxl.ja.streamingservice.domain;

import be.pxl.ja.streamingservice.util.PasswordUtil;

public class Account {
	private String email;
	private String password;

	public Account(String email, String password) {
		this.email = email;
		setPassword(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean verifyPassword(String password) {
		return PasswordUtil.isValid(password, this.password);
	}

	public void setPassword(String password) {
		this.password = PasswordUtil.encodePassword(password);
	}
}