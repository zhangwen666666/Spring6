package com.zw.spring6.bean;

import java.util.List;
import java.util.Set;

public class Person {
    private List<String> phones;
    private Set<String> hobbies;
    private Set<Address> addresses;
    private List<Clazz> clazzes;

    @Override
    public String toString() {
        return "Person{" +
                "phones=" + phones +
                ", hobbies=" + hobbies +
                ", addresses=" + addresses +
                ", clazzes=" + clazzes +
                '}';
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }
}
