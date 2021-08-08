package com.epam.jwd.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SphereInputValidator{
    private final static String REGEXP = "^[0-9]+\\.[0-9]+,[0-9]+\\.[0-9]+,[0-9]+\\.[0-9]+;[0-9]+\\.[0-9]+$";

    public SphereInputValidator()
    {

    }
    public boolean checkInput(final String input)
    {
        final Pattern pattern = Pattern.compile(REGEXP, Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
