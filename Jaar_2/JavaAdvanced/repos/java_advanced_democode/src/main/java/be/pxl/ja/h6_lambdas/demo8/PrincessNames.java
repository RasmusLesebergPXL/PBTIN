package be.pxl.ja.h6_lambdas.demo8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PrincessNames {

	private List<String> names = new ArrayList<>();

	public PrincessNames() {
		names.add("Snow White");
		names.add("Cinderella");
		names.add("Aurora");
		names.add("Ariel");
		names.add("Belle");
		names.add("Jasmine");
		names.add("Pocahontas");
		names.add("Mulan");
		names.add("Tiana");
		names.add("Rapunzel");
		names.add("Merida");
		names.add("Moana");
	}


	public void filterNames(Predicate<String> filter) {
		for (String name : names) {
			if (filter.test(name)) {
				System.out.println(name + " is valid!");
			}
		}
	}

}
