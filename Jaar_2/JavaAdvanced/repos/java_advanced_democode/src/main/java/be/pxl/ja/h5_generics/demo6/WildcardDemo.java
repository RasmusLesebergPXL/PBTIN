package be.pxl.ja.h5_generics.demo6;

import be.pxl.ja.streamingservice.domain.*;

import java.util.ArrayList;
import java.util.List;

public class WildcardDemo {


	public static void main(String[] args) {
		List<Movie> movies = new ArrayList<>();
		Movie brotherBear = new Movie("Brother Bear", Rating.LITTLE_KIDS);
		brotherBear.setDuration(125);
		Movie theLionKing = new Movie("The Lion King", Rating.LITTLE_KIDS);
		brotherBear.setDuration(135);
		movies.add(brotherBear);
		movies.add(theLionKing);
		System.out.println(totalDuration(movies));

		List<Documentary> documentaries = new ArrayList<>();
		Documentary planetEarth = new Documentary("Planet Earht", Rating.OLDER_KIDS);
		planetEarth.setDuration(200);
		Documentary ourOcean = new Documentary("Our Ocean", Rating.OLDER_KIDS);
		planetEarth.setDuration(140);

		System.out.println(totalDuration(documentaries));

		startPlayableContent(ourOcean);
		startPlayableContent(brotherBear);
	}


	public static int totalDuration(List<? extends Movie> movies) {
		int totalDuration = 0;
		for (Movie movie: movies) {
			totalDuration += movie.getDuration();
		}
		return totalDuration;
	}

	public static <T extends Content & Playable> void startPlayableContent(T playableContent) {
		playableContent.play();
		System.out.println("This content will be playing for " + playableContent.getDuration() + " minutes.");
	}
}
