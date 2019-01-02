package model;

import core.annotation.NotEmpty;
import core.annotation.NotNull;
import core.annotation.Regex;
import core.annotation.Size;

public class Customer
{
    @NotNull
    public String name;
    @NotNull
    @NotEmpty
    @Regex(regex = "\\d+")
    public String phone;

    @Size(min = 3)
    public int age;

    @Size(min = 2, target = "$.age",message = "Ban cua ban cua ban qua nho")
    public Customer friend;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

