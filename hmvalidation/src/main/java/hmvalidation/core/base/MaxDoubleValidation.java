package hmvalidation.core.base;

public class MaxDoubleValidation  extends DoubleCompareValidation{
    @Override
    protected boolean checkCompare(Double value) {
        return value <= valueCompare;
    }
}