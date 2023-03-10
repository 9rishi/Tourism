package com.rishi.tourist.model;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SubjectValidtor implements ConstraintValidator<Validation_SubType, String> {

	@Override
	public boolean isValid(String subType, ConstraintValidatorContext context) {
		
		List<String> subTypes = Arrays.asList("chem","phy","maths");
		return subTypes.contains(subType);
	}
}
