package be.pxl.ja.h6_lambdas.demo6;

public class CountServiceDemoWithLambda {

	public static void main(String[] args) {

		Service<Integer, String> countService  = (data) -> data.length();
		System.out.println(countService.getClass());
		System.out.println(countService.execute("abcdefghijkl"));
	}
}
