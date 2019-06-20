package hmvalidation.core.base;

public class ContainArrayStringValidation  extends AbstractValidation  {
    String[] values;
    @Override
    protected boolean validation(Object object) {
        if(!(object instanceof String)) return false;
        if(values != null && values.length != 0){
            for(String data : values){
                if(object.equals(data)){
                    return true;
                }
            }
        }
        return false;
    }


    public void setValue(String[] values) {
        this.values = values;
    }
}
