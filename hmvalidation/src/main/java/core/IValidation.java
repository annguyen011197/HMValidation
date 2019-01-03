package core;

import core.result.ResultItemObserver;
import core.result.ResultObserver;

public abstract class IValidation {
    ResultItemObserver resultObserver;
    protected IValidation() {
        resultObserver = new ResultItemObserver();
        setupValidation(this.resultObserver);
    }

    public ResultObserver getValidation(){
        return this.resultObserver;
    }

    protected abstract void setupValidation(ResultItemObserver observer);
}
