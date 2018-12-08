package model;

import core.annotation.BaseRuleAnnotation;
import core.annotation.RegexRuleAnnotation;
import core.base.EmptyValidation;
import core.base.NullValidation;
import core.base.RegexValidation;

public class Customer
{
    //public String name;

    @BaseRuleAnnotation(type = EmptyValidation.class)
    @RegexRuleAnnotation(type = RegexValidation.class, regex = "1232131232131")
    public String phone;

    public Customer(String name, String phone) {
        //this.name = name;
        this.phone = phone;
    }
}
