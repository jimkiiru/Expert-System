package com.expertsystem.controller;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.expertsystem.model.*;

@Component("expertFormValidator")
public class ExpertFormValidator implements Validator
{
	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz)
	{
		return FarmerModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object model, Errors errors)
	{
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname","required.surname", "Surname required.");
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname","required.fname", "fname required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname","required.lname", "lname required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailaddress","required.emailaddress", "emailaddress required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phonenum","required.phonenum", "phonenum required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobDescription","required.jobDescription", "jobDescription required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "county","required.county", "county required.");*/
	}

}