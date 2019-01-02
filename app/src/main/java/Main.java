
import Custom.Email;
import Custom.EmailProcess;
import core.Validation;
import core.process.FactoryProcess;
import model.Customer;

public class Main {
    public static void main(String args[]){

        FactoryProcess.register(Email.class, EmailProcess.class);
        Customer customer =new Customer(null, "34324");
        Customer friend = new Customer("Annn","111111");
        friend.age = 10;
        customer.friend = friend;
        Validation.getInstance().runObserver(customer, result -> System.out.println(result.getName() + "->" + result.isFailed()));
    }
}
