package be.pxl.ja.h6_lambdas.demo6;

@FunctionalInterface
public interface Service<T,U> {

	T execute(U arg);
}
