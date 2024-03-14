package com.example;

import org.springframework.stereotype.Component;

@Component
public class InvoiceManagement {

    CalculatorService calculator;

    public InvoiceManagement(CalculatorService calculator) {
        this.calculator = calculator;
    }


}
