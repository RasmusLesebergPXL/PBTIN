package be.pxl.ja.h6_lambdas.demo5;

public class HorrorShow {

	interface Lethal {
		void kill();
		void destroy();
	}

	abstract class Vampire implements Lethal {
		private int bloodAvailable;

		@Override
		public void kill() {
			System.out.println("kill");
		}

		void drinkBlood(int amount) {
			bloodAvailable += amount;
		}

		@Override
		public String toString() {
			return "Vampire{" +
					"class=" + this.getClass() + ", " +
					"bloodAvailable=" + bloodAvailable +
					'}';
		}
	}

	public void meetBarney() {
		Vampire barney = new Vampire() {
			@Override
			public void destroy() {
				drinkBlood(5);
				kill();
			}
		};
		System.out.println(barney);
		barney.destroy();
		System.out.println(barney);
	}


	public static void main(String[] args) {
		new HorrorShow().meetBarney();
	}
}
