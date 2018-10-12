package org.radekbor.spockplay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathCtrl {

    @Autowired
    MathCtrl(MathService mathService) {
        this.mathService = mathService;
    }

    private MathService mathService;

    @GetMapping("/multiply/{a}/{b}")
    public int multiply(@PathVariable("a") int a, @PathVariable("b") int b) {
        return mathService.multiply(a, b);
    }
}
