package com.group.libraryapp.controller.calculator;


import com.group.libraryapp.dto.calculator.CalculatorMulRequest;
import com.group.libraryapp.dto.calculator.CalculatorAddRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/add") // GET
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }
    // 객체(request) 로 감싸서 받으므로 request.을 이용해 호출해야 한다


    @PostMapping("/multiply") // POST
    public int multiplyTwoNumbers(@RequestBody CalculatorMulRequest request) {
        return request.getNumber1() * request.getNumber2();
    }
}








// 오류 수정



// 단축키: ctrl + alt + o : import 문 정리
// ctrl + w : 단어 영역 지정