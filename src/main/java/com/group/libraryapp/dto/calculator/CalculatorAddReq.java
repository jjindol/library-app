package com.group.libraryapp.dto.calculator;


import lombok.Getter;

@Getter
public class CalculatorAddReq {

    private final int number1;
    private final int number2;


    public CalculatorAddReq(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }


}
