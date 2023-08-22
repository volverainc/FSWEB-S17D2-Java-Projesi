package com.workintech.dependency.tax;

import org.springframework.stereotype.Component;

@Component
public class DeveloperTax implements Taxable{
    @Override
    public int getSimpleTaxRate() {
        return 10;
    }

    @Override
    public int getMiddleTaxRate() {
        return 20;
    }

    @Override
    public int getUpperTaxRate() {
        return 30;
    }
}
