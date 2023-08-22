package com.workintech.dependency.model;

import com.workintech.dependency.tax.Taxable;
import org.springframework.stereotype.Component;

@Component
public class JuniorDeveloper extends Developer {
    public JuniorDeveloper() {
    }

    public JuniorDeveloper(int id, String name, double salary, Experience experience) {
        super(id, name, salary, experience);
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }
}
