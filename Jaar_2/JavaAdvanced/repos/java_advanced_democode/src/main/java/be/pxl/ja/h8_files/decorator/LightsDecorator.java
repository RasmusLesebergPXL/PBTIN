package be.pxl.ja.h8_files.decorator;

public class LightsDecorator extends ChristmasTreeDecorator {

	public LightsDecorator(ChristmasTree christmasTree) {
		super(christmasTree);
	}

	@Override
	public void decorate() {
		super.decorate();
		System.out.println("added colorfull lights");
	}
}
