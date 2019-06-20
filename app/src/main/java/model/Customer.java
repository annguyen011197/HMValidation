package model;

import hmvalidation.core.IValidation;
import hmvalidation.core.annotation.Limit;
import hmvalidation.core.annotation.NotEmpty;
import hmvalidation.core.annotation.NotNull;
import hmvalidation.core.annotation.Regex;
import hmvalidation.core.result.ResultItemObserver;

public class Customer extends IValidation {
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

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    protected void setupValidation(ResultItemObserver observer) {
        observer.putCallback("name", result -> System.out.println("name:"+ result.getMessage()));
        observer.putCallback("phone", result -> System.out.println("phone:"+ result.getMessage()));
        observer.putCallback("friend", result -> System.out.println("friend:"+ result.getMessage()));
    }
}

