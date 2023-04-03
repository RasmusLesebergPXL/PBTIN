package be.pxl.ja.h8_files.factory;

public class NotificationFactory {

	public Notification createNotification(Preference preference) {
		switch (preference) {
			case SMS:
				return new SMSNotification();
			case EMAIL:
				return new EmailNotification();
			default:
				return null;
		}
	}

}
