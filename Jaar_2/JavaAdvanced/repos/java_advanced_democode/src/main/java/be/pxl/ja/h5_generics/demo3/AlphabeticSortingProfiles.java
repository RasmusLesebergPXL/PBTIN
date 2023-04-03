package be.pxl.ja.h5_generics.demo3;

import be.pxl.ja.streamingservice.domain.Profile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphabeticSortingProfiles {

	public static void main(String[] args) {
		List<Profile> profiles = new ArrayList<>();
		Profile profile1 = new Profile("Erik");
		profile1.setDateOfBirth(LocalDate.of(2005, 5, 14));
		Profile profile2 = new Profile("Sam");
		profile2.setDateOfBirth(LocalDate.of(2000, 12, 23));
		Profile profile3 = new Profile("Ann");
		Profile profile4 = new Profile("Ann");
		profile4.setDateOfBirth(LocalDate.of(1980, 2, 8));

		profiles.add(profile1);
		profiles.add(profile2);
		profiles.add(profile3);
		profiles.add(profile4);

		System.out.println(profile3.compareTo(profile4));
		System.out.println(profile4.compareTo(profile2));

		Collections.sort(profiles);
		System.out.println(profiles);
	}
}
