package be.pxl.ja.h8_files.factory;

public class EmailNotification implements Notification {

	@Override
	public void notify(User user) {
		System.out.println("Sending email to " + user.getEmail());
	}
}
