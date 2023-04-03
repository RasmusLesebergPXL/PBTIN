package be.pxl.ja.h5_generics.demo6;

import be.pxl.ja.streamingservice.domain.Content;
import be.pxl.ja.streamingservice.domain.Documentary;
import be.pxl.ja.streamingservice.domain.Movie;
import be.pxl.ja.streamingservice.domain.Rating;

import java.util.ArrayList;
import java.util.List;

public class BoundsDemo {

	//Upper bound wildcard
	public static void deleteMovie(List<? extends Movie> movieList, Movie movie) {
		movieList.remove(movie);
	}

	//Lower bound wildcard
	public static void addDocumentary(List<? super Movie> movieList) {
		movieList.add(new Documentary("Hunt for Red October", Rating.OLDER_KIDS));
	}

	//Unbounded wildcard
	public static void printAll(List<?> list) {
		System.out.println("Number of items: " + list.size());
		for (Object item : list) {
			System.out.println(item);
		}
		System.out.println("+++++++++++++++++++++++++++++++");
	}

	public static void main(String[] args) {

		List<Content> contentList = new ArrayList<>();
		List<Movie> movieList = new ArrayList<>();
		List<Documentary> documentaryList = new ArrayList<>();

		addDocumentary(contentList);
		addDocumentary(movieList);
		//addDocumentary(documentaryList);

		printAll(contentList);
		printAll(movieList);

		Movie movie = movieList.get(0);
		deleteMovie(movieList, movie);

		printAll(movieList);
	}

}
