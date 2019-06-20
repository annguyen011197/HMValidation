package hmvalidation.core;

import hmvalidation.core.result.ResultCallback;
import hmvalidation.core.result.ResultItemObserver;
import hmvalidation.core.result.ResultObserver;

public abstract class ValidationImp implements IValidation {
    private ResultItemObserver resultObserver;
    protected ValidationImp() {
        resultObserver = new ResultItemObserver();
        setupValidation(this.resultObserver);
    }

    @Override
    public ResultObserver getValidation(){
        return this.resultObserver;
    }

    protected abstract void setupValidation(ResultItemObserver observer);

    public void onValidated(String key, ResultCallback callback){
        resultObserver.putCallback(key,callback);
    }
}