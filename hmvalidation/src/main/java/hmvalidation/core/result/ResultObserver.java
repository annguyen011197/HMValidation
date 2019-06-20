package hmvalidation.core.result;

import java.util.List;

public interface ResultObserver {
    void update(List<Result> result);
}

