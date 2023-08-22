package com.workintech.dependency.model;

import org.springframework.stereotype.Component;

@Component
public class SeniorDeveloper extends Developer{
    @Override
    public double getSalary() {
        return super.getSalary();
    }
}
