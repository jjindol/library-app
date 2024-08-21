package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.request.CalculatorAddRequest;
import com.group.libraryapp.dto.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public int addTwoNums(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiplyTwoNums(@RequestBody  CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }
}

//ctrl+op+O => 안쓰는 어노테이션 정리