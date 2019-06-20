package hmvalidation.core.base;

import java.util.regex.Pattern;

public class RegexValidation extends AbstractValidation
{
    private String regex;

    @Override
    public boolean validation(Object object) {
        if(object == null) return false;
        String data = (String) object;
        Pattern r = Pattern.compile(regex);
        return r.matcher(data).matches();
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
