package be.pxl.ja.h8_files.decorator;

public abstract class ChristmasTreeDecorator implements ChristmasTree {
	private ChristmasTree christmasTree;

	public ChristmasTreeDecorator(ChristmasTree christmasTree) {
		this.christmasTree = christmasTree;
	}

	public void decorate() {
		christmasTree.decorate();
	}
}
