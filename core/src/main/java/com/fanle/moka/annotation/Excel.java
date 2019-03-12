package com.fanle.moka.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {

    String name() default "";

    Class statusClass() default Class.class;

    String exportFormat() default "" ;

    boolean isLink() default  false ;

}
