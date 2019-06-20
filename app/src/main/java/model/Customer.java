package model;

import Custom.Email;
import hmvalidation.core.ValidationImp;
import hmvalidation.core.annotation.*;
import hmvalidation.core.result.ResultItemObserver;

import java.util.List;

public class Customer extends ValidationImp {
    @NotNull
    @ContainArrayString(array = {"1", "2"})
    public String name;

    @NotNull
    @NotEmpty
    @Regex(regex = "\\d+")
    public String phone;

    @Limit(min = 3)
    public int age;

    @Limit(min = 2, target = "$.age",message = "Ban cua ban cua ban qua nho")
    public Customer friend;

    public List<Car> list;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    protected void setupValidation(ResultItemObserver observer) {
        observer.putCallback("$.name", result -> {
            if(result.isFailed()){
                System.out.println(result.getName() + ": " + result.getMessage());
            }
        });
        observer.putCallback("$.phone", result -> {
            if(result.isFailed()){
                System.out.println(result.getName() + ": " + result.getMessage());
            }
        });
        observer.putCallback("$.friend", result -> {
            if(result.isFailed()){
                System.out.println(result.getName() + ": " + result.getMessage());
            }
        });
    }
}

