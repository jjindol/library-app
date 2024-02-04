package com.group.libraryapp.dto.calculator;


import lombok.Getter;

@Getter
public class CalculatorMulReq {

    private int number1;

    private int number2;

    public CalculatorMulReq(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
}
