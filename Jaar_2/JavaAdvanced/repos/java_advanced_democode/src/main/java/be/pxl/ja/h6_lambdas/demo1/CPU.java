package be.pxl.ja.h6_lambdas.demo1;

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

	public class Core {
		private double clockspeed;

		public Core(double clockspeed) {
			this.clockspeed = clockspeed;
		}

		public double getClockspeed() {
			return clockspeed;
		}

		public String getManufacturer() {
			return manufacturer;
		}
	}

	public static void main(String[] args) {
		CPU cpu = new CPU(4, 3.0, "AMD");
		System.out.println(cpu.getNumberOfCores());

		Core newCore = cpu.new Core(4.0);
		System.out.println(newCore.getManufacturer());
	}
}
