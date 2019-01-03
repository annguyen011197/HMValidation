package model;

import core.IValidation;
import core.annotation.Limit;
import core.annotation.NotEmpty;
import core.annotation.NotNull;
import core.annotation.Regex;
import core.result.ResultItemObserver;

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

