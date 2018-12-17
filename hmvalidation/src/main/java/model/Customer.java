package model;

import core.annotation.NotEmpty;
import core.annotation.NotNull;
import core.annotation.Regex;

public class Customer
{
    public String name;
    @NotNull
    @NotEmpty
    @Regex(regex = "\\d+")
    public String phone;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
