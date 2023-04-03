package be.pxl.ja.h6_lambdas.demo2;

import java.util.ArrayList;
import java.util.List;

public class CPU {

	private List<Core> cores;
	private String manufacturer;

	public CPU(int numberOfCores, double clockspeed, String manufacturer) {
		cores = new ArrayList<>();
		for (int i = 0; i < numberOfCores; i++) {
			cores.add(new Core(clockspeed));
		}
		this.manufacturer = manufacturer;
	}

	public int getNumberOfCores() {
		return cores.size();
	}

	public static class Core {
		private double clockspeed;

		public Core(double clockspeed) {
			this.clockspeed = clockspeed;
		}

		public double getClockspeed() {
			return clockspeed;
		}
	}

	public static void main(String[] args) {
		CPU cpu = new CPU(4, 3.0, "AMD");
		System.out.println(cpu.getNumberOfCores());

		Core newCore = new Core(4.5);
		System.out.println(newCore.getClockspeed());
	}

}
