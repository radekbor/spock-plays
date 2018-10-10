package org.radekbor.spockplay;

import org.springframework.stereotype.Service;

@Service
public class SqrtService {

    public double sqrt(double a) {
        return Math.sqrt(a);
    }
}
