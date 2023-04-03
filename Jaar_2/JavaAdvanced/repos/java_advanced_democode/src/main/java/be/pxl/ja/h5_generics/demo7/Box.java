package be.pxl.ja.h5_generics.demo7;

public class Box<T> {

	//compiler error
	//	private static T value;
	private T t;

//		public Box() {
//			// compiler error
//			t = new T();
//		}

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

//		public boolean test() {
//			return t instanceof T;
//		}
}
