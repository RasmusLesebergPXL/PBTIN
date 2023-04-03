package be.pxl.ja.h4_collections;

import be.pxl.ja.streamingservice.domain.Content;

import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		List<Content> contentList = new ContentRepository().getContentList();

		System.out.println("Size before: " + contentList.size());
		Iterator<Content> contentIterator = contentList.iterator();
		while (contentIterator.hasNext()) {
			Content content = contentIterator.next();
			if (content.getImageUrl() == null) {
				contentIterator.remove();
			}
		}
		System.out.println("Size after: " + contentList.size());
	}
}
