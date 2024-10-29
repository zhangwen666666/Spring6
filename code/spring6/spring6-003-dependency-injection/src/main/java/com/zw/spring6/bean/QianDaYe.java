package com.zw.spring6.bean;

import java.util.Arrays;

public class QianDaYe {
    private String[] hobbies;
    private Student[] students;

    @Override
    public String toString() {
        return "QianDaYe{" +
                "hobbies=" + Arrays.toString(hobbies) +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

}
