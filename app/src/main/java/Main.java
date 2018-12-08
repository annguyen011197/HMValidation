import core.Validation;
import model.Customer;

public class Main {
    public static void main(String args[]){
        Validation.getInstance().runObserver(new Customer(null, null), result -> System.out.println(result.getName() + "->" + result.getError()));
    }
}
