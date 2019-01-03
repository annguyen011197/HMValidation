package model;

import core.annotation.MinDouble;
import core.annotation.NotEmpty;
import core.annotation.NotNull;
import core.annotation.Regex;

public class Customer
{
    @NotNull
    public String name;
    @NotNull
    @NotEmpty
    @Regex(regex = "\\d+")
    public String phone;

    @MinDouble(min = 3)
    public int age;

    @MinDouble(min = 2, target = "$.age",message = "Ban cua ban cua ban qua nho")
    public Customer friend;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

