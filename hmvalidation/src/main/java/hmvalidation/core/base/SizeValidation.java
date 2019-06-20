package hmvalidation.core.base;

import java.util.Collection;
import java.util.Map;

public class SizeValidation extends AbstractValidation
{
    private int maxSize;
    private int minSize;
    @Override
    public boolean validation(Object object) {
        int size = -1;
        if(object instanceof  String){
            size = ((String) object).length();
        } else if(object instanceof Collection){
            size = ((Collection) object).size();
        } else if(object instanceof Map){
            size = ((Map) object).size();
        }
        return size < maxSize && size > minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }
}