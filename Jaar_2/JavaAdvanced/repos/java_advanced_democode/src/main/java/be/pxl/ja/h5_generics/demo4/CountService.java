package be.pxl.ja.h5_generics.demo4;

public class CountService implements Service<Integer, String> {

	@Override
	public Integer execute(String arg) {
		return arg.length();
	}
}
