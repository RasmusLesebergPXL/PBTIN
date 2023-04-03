package be.pxl.ja.h5_generics.demo4;

import be.pxl.ja.streamingservice.domain.Profile;

import java.time.LocalDate;
import java.util.Random;

public class ProfileService implements Service<Profile, Integer> {

	private static final Random RANDOM = new Random();

	/**
	 * This method can be used to create a Profile-object with a random name and age 18.
	 *
	 * @param length length of the random name of the newly created Profile
	 * @return a newly created Profile-object with a random name of given length and age 18.
	 */
	public Profile execute(Integer length) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int number = RANDOM.nextInt(26) + 97;
			builder.append((char) number);
		}
		Profile profile = new Profile(builder.toString());
		profile.setDateOfBirth(LocalDate.now().minusYears(18));
		return profile;
	}
}
