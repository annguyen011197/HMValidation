import Custom.Email;
import Custom.EmailProcess;
import hmvalidation.core.Validation;
import hmvalidation.core.process.FactoryProcess;
import model.Customer;

public class Main {
    public static void main(String args[]){

        FactoryProcess.register(Email.class, EmailProcess.class);
        Customer customer =new Customer(null, "34324");
        customer.age = 5;
        Customer friend = new Customer("Annn","111111");
        friend.age = 0;
        customer.friend = friend;
        customer.onValidated("name",result -> System.out.println("name"));
        Validation.getInstance().runObserver(customer);

    }
}
