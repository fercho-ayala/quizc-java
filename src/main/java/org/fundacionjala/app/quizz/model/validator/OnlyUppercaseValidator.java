package org.fundacionjala.app.quizz.model.validator;

import java.text.ParseException;
import java.util.List;

public class OnlyUppercaseValidator implements Validator {

    private static final String ERROR_MESSAGE = "The string format is invalid, it should be only lowercase: ";

    @Override
    public void validate(String value, String conditionValueString, List<String> errors) {
        if (!value.equals(conditionValueString.toLowerCase())) {
            errors.add(ERROR_MESSAGE + conditionValueString);
        }
        errors.add(ERROR_MESSAGE);
    }
}
