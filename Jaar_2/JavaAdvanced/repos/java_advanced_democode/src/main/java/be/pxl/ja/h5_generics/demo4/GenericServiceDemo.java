package be.pxl.ja.h5_generics.demo4;

import be.pxl.ja.streamingservice.domain.Profile;

public class GenericServiceDemo {

	public static void main(String[] args) {

		CountService countService = new CountService();
		System.out.println(countService.execute("abcdefghijkl"));

		ProfileService profileService = new ProfileService();
		Profile profile1 = profileService.execute(8);
		System.out.println(profile1);
	}
}
