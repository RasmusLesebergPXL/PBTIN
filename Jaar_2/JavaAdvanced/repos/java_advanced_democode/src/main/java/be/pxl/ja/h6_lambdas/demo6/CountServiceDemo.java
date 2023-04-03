package be.pxl.ja.h6_lambdas.demo6;

public class CountServiceDemo {

	public static void main(String[] args) {

		Service<Integer, String> countService  = new Service<>() {
			@Override
			public Integer execute(String data) {
				return data.length();
			}
		};
		System.out.println(countService.getClass());
		System.out.println(countService.execute("abcdefghijkl"));
	}
}
