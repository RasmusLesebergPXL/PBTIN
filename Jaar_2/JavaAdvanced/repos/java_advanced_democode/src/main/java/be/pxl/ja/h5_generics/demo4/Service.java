package be.pxl.ja.h5_generics.demo4;

public interface Service<T,U> {

	T execute(U arg);
}
