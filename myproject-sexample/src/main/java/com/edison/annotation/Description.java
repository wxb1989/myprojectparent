package com.edison.annotation;


import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {

    String[]name();

    int age() default 18;

    PeopleKind kind() default PeopleKind.YELLOW;
}
