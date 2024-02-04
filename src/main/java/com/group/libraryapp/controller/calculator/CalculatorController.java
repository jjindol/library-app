package com.group.libraryapp.controller.calculator;


import com.group.libraryapp.dto.calculator.CalculatorMulReq;
import com.group.libraryapp.dto.calculator.CalculatorAddReq;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddReq request) {
        return request.getNumber1() + request.getNumber2();
    }
    // 객체(request) 로 감싸서 받으므로 request.을 이용해 호출해야 한다


    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMulReq request) {
        return request.getNumber1() * request.getNumber2();
    }
}
// 덧셈은 파라미터로, 곰셈은 바디에 값 전달