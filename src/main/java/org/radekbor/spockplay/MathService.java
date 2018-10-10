package org.radekbor.spockplay;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MathService {

    private SqrtService sqrtService;

    @Autowired
    public MathService(SqrtService sqrtService) {
        this.sqrtService = sqrtService;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divideAndSqrt(int a, int b) {
        return sqrtService.sqrt(a / b);
    }
}
