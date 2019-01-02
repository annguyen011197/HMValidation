
import Custom.Email;
import Custom.EmailProcess;
import core.Validation;
import core.process.FactoryProcess;
import model.Customer;

public class Main {
    public static void main(String args[]){

        FactoryProcess.register(Email.class, EmailProcess.class);

        Validation.getInstance().runObserver(new Customer(null, "34324"), result -> System.out.println(result.getName() + "->" + result.isFailed()));
    }
}
