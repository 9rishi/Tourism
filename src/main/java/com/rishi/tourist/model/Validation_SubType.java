package com.rishi.tourist.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Constraint(validatedBy = SubjectValidtor.class)
public @interface Validation_SubType {

	String  sub_type() default "maths";
	
	public String message() default "Invalid subType , it should be chem,phy,maths";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };


	
}
