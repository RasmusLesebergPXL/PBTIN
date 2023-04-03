package be.pxl.ja.h8_files.factory;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

	public static void main(String[] args) {
		NotificationFactory notificationFactory = new NotificationFactory();
		List<User> users = new ArrayList<>();
		users.add(new User("user1", "user1@gmail.com", "0123/123123", Preference.EMAIL));
		users.add(new User("user2", "user2@gmail.com", "0123/678678", Preference.SMS));

		for (User user : users) {
			notificationFactory.createNotification(user.getPreference()).notify(user);
		}

	}

}
