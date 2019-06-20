package model;

import hmvalidation.core.ValidationImp;
import hmvalidation.core.annotation.Limit;
import hmvalidation.core.annotation.NotEmpty;
import hmvalidation.core.annotation.NotNull;
import hmvalidation.core.annotation.Regex;
import hmvalidation.core.result.ResultItemObserver;

import java.util.List;

public class Customer extends ValidationImp {
    @NotNull
    public String name;

    @NotNull
    @NotEmpty
    @Regex(regex = "\\d+")
    public String phone;

    @Limit(min = 3)
    public int age;

    @Limit(min = 2, target = "$.age",message = "Ban cua ban cua ban qua nho")
    public Customer friend;

    @NotNull(target = "$.list[0].name")
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

