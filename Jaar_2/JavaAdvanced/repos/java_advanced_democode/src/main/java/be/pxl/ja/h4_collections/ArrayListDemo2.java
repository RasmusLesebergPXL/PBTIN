package be.pxl.ja.h4_collections;

import be.pxl.ja.streamingservice.domain.Content;
import be.pxl.ja.streamingservice.domain.Movie;
import be.pxl.ja.streamingservice.domain.Rating;
import be.pxl.ja.streamingservice.domain.TVShow;

import java.util.List;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		List<Content> contentList = new ContentRepository().getContentList();

		System.out.println("Eigen kweek: " + contentList.contains(new TVShow("Eigen kweek", Rating.TEENS, 0)));
		System.out.println("Iron fist: " + contentList.contains(new Movie("Iron fist", Rating.MATURE)));
		System.out.println("Rambo: " + contentList.contains(new Movie("Rambo", Rating.TEENS)));

	}


}
