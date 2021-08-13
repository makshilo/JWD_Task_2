package com.epam.jwd.validator;

import com.epam.jwd.action.impl.SphereGeometryActionImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SphereInputValidator{
    private final static String REGEXP = "^[0-9]+\\.[0-9]+,[0-9]+\\.[0-9]+,[0-9]+\\.[0-9]+;[0-9]+\\.[0-9]+$";
    private final static Logger LOG = LogManager.getLogger(SphereInputValidator.class);

    public SphereInputValidator()
    {

    }
    public boolean checkInput(final String input)
    {
        LOG.trace("Verifying input");
        final Pattern pattern = Pattern.compile(REGEXP, Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
