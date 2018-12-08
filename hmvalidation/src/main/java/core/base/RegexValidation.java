package core.base;

public class RegexValidation extends AbstractValidation
{
    private String regex;

    @Override
    public boolean validation(Object object) {
        System.out.println(regex);
        return object != null;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
