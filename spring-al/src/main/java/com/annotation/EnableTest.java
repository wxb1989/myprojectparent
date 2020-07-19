package com.annotation;
import com.support.TestRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(TestRegistrar.class)
public @interface EnableTest {
}
