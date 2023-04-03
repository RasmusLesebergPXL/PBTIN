package be.pxl.ja.h6_lambdas.oefening1;

public class NumberSelector {

	private NumberMachine machine;

	public NumberSelector(NumberMachine numberMachine) {
		this.machine = numberMachine;
	}

	public String showEvenNumbers() {
		return machine.processNumbers( number -> number % 2 == 0);
	}

	public String printHexNumbers() {
		return machine.convertNumbers(Integer::toHexString);
	}

	public String showNumbersAbove(int number) {

		return machine.processNumbers(n -> n> number);
	}
}
