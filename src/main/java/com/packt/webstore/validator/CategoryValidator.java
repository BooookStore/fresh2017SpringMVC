package com.packt.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CategoryValidator implements ConstraintValidator<Category, String> {

    private List<String> allowedCategoryList = new ArrayList<>();

    public CategoryValidator() {
        allowedCategoryList.add("Tablet");
        allowedCategoryList.add("LapTop");
        allowedCategoryList.add("SmartPhone");
    }

    public void initialize(Category constraint) {
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        return allowedCategoryList.stream().anyMatch(t -> t.equals(value));
    }
}
