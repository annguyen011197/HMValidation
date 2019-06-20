package hmvalidation.core.base;

public class MinDoubleValidation extends DoubleCompareValidation{
    @Override
    protected boolean checkCompare(Double value) {
        return value >= valueCompare;
    }
}