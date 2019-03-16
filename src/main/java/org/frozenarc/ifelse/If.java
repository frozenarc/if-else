package org.frozenarc.ifelse;

import java.util.function.Function;

public interface If {

    static <T, U> Then<T, U> of(Function<T, Boolean> whnFn) {
        return thnFn -> elsFn -> Work.<T, U>of(whnFn)
                .thnFn(thnFn)
                .elsFn(elsFn);
    }

}
