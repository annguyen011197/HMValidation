package core.base;

public class LimitValidation extends AbstractValidation {
    private double max;
    private double min;
    @Override
    protected boolean validation(Object object) {
        if(object instanceof  Number){
            double value = ((Number) object).doubleValue();
            return value > min && value < max;
        }
        return false;
    }
    public void setMax(double max) {
        this.max = max;
    }

    public void setMin(double min) {
        this.min = min;
    }
}
