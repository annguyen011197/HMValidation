package hmvalidation.core.result;

import java.util.HashMap;
import java.util.List;

public class ResultItemObserver implements ResultObserver {
    private HashMap<String, ResultCallback> resultHashMap;

    public ResultItemObserver() {
        this.resultHashMap = new HashMap<>();
    }

    public void update(List<Result> results){
        for (Result result : results){
            String key = result.getName();
            ResultCallback callback = resultHashMap.get(key);
            if(callback != null){
                callback.update(result);
            }
        }
    }
    public void putCallback(String key,ResultCallback callback){
        resultHashMap.put(key,callback);
    }
}
