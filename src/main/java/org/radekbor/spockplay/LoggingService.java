package org.radekbor.spockplay;

import org.springframework.stereotype.Component;


interface LogAction {
    void call();
}

public class LoggingService {

    private LogAction[] actions;

    public LoggingService(LogAction... actions) {
        this.actions = actions;
    }

    public int foo() {
        for (LogAction action: actions) {
            action.call();
        }
        return 1;
    }
}
