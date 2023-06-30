package be.pxl.rct.visitor;

import be.pxl.rct.themepark.ThemePark;
import com.github.javafaker.Faker;

public class VisitorFactory {

    private static final Faker FAKER = new Faker();
    private ThemePark themePark;

    public VisitorFactory(ThemePark themePark) {
        this.themePark = themePark;
    }


    public final Visitor createVisitor() {
        return new Visitor(FAKER.name().firstName(), themePark);
    }
}
