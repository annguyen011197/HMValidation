package Custom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hmvalidation.core.base.AbstractValidation;

public class EmailValidation extends AbstractValidation {
    @Override
    protected boolean validation(Object object) {
        if(object instanceof String){
            return validate((String) object);
        }
        return false ;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
}