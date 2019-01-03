package core.base;

public abstract class DoubleCompareValidation extends AbstractValidation {
    double valueCompare;
    @Override
    public boolean validation(Object object) {
        if (object instanceof Double) {
            return checkCompare((Double) object);
        } else {
            try {
                Double value = Double.valueOf(String.valueOf(object));
                return checkCompare(value);
            } catch (Exception e) {
                return false;
            }
        }
    }

    protected abstract boolean checkCompare(Double value);

    public void setValueCompare(double valueCompare) {
        this.valueCompare = valueCompare;
    }
}