package org.frozenarc.ifelse;

import java.util.function.Function;

public class Work<T, S> implements Do<T, S> {

    private Function<T, Boolean> whnFn;
    private Do<T, S> thnFn;
    private Do<T, S> elsFn;

    @Override
    public S doFor(T value) {
        return whnFn.apply(value)
                ? thnFn.doFor(value)
                : elsFn.doFor(value);
    }

    static <T, S> Work<T, S> of(Function<T, Boolean> whnFn) {
        Work<T, S> work = new Work<>();
        return work.whnFn(whnFn);
    }

    private Work<T, S> whnFn(Function<T, Boolean> whnFn) {
        this.whnFn = whnFn;
        return this;
    }

    Work<T, S> thnFn(Do<T, S> thnFn) {
        this.thnFn = thnFn;
        return this;
    }

    Work<T, S> elsFn(Do<T, S> elsFn) {
        this.elsFn = elsFn;
        return this;
    }

}
