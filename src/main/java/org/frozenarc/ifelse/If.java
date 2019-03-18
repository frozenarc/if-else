package org.frozenarc.ifelse;

import java.util.function.Function;

public interface If {

    static <T, S> Then<T, S> of(Function<T, Boolean> whnFn) {
        return thnFn -> elsFn -> Work.<T, S>of(whnFn)
                .thnFn(thnFn)
                .elsFn(elsFn);
    }

}
