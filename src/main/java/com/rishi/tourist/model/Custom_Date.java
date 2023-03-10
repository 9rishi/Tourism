package com.rishi.tourist.model;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Payload;

@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited

public @interface Custom_Date {
	
	String custom_date() default "2023/02/27";
	
    public String message() default "Converting into yyyy/MM/dd";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
