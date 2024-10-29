package com.zw.spring6.bean;

import java.util.List;
import java.util.Set;

public class Person {
    private List<String> hobbies;
    private Set<Address> addrs;

    private List<Student> students;
    private Set<String> phones;

    @Override
    public String toString() {
        return "Person{" +
                "hobbies=" + hobbies +
                ", addrs=" + addrs +
                ", students=" + students +
                ", phones=" + phones +
                '}';
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setAddrs(Set<Address> addrs) {
        this.addrs = addrs;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }
}
