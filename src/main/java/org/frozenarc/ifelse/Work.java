package org.frozenarc.ifelse;

import java.util.function.Function;

public class Work<T, U> implements Do<T, U> {

    private Function<T, Boolean> whnFn;
    private Do<T, U> thnFn;
    private Do<T, U> elsFn;

    @Override
    public U doFor(T value) {
        return whnFn.apply(value)
                ? thnFn.doFor(value)
                : elsFn.doFor(value);
    }

    static <T, U> Work<T, U> of(Function<T, Boolean> whnFn) {
        Work<T, U> worker = new Work<>();
        return worker.whnFn(whnFn);
    }

    private Work<T, U> whnFn(Function<T, Boolean> whnFn) {
        this.whnFn = whnFn;
        return this;
    }

    Work<T, U> thnFn(Do<T, U> thnFn) {
        this.thnFn = thnFn;
        return this;
    }

    Work<T, U> elsFn(Do<T, U> elsFn) {
        this.elsFn = elsFn;
        return this;
    }
}
