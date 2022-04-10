package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class demo01 {
    @annotationTest(age = 1)
    public void test() {

    }

    public static void main(String[] args) {

    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@interface annotationTest {
    String name() default "";

    int age();
}