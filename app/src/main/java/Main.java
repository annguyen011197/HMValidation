import Custom.Email;
import Custom.EmailProcess;
import hmvalidation.core.Validation;
import hmvalidation.core.process.FactoryProcess;
import model.Car;
import model.Customer;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]){

        FactoryProcess.register(Email.class, EmailProcess.class);
        Customer customer =new Customer(null, "34324");
        customer.age = 5;
        customer.list = new ArrayList<>();
        customer.list.add(new Car());
        Customer friend = new Customer(null,"");
        friend.age = 0;
        friend.friend = null;
        customer.friend = friend;



        customer.onValidated("$.name",result -> {
            if(result.isFailed()){
                System.out.println(result.getName() + ": " + result.getMessage());
            }
        });

        customer.onValidated("default",result -> {
            if(result.isFailed()){
                System.out.println(result.getName() + ": " + result.getMessage());
            }
        });
        Validation.getInstance().runObserver(customer);

    }
}
