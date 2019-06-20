package model;

import hmvalidation.core.IValidation;
import hmvalidation.core.annotation.NotEmpty;
import hmvalidation.core.result.ResultObserver;

public class Car implements IValidation {
    @NotEmpty
    public String name;

    @Override
    public ResultObserver getValidation() {
        return result -> {

        };
    }
}
