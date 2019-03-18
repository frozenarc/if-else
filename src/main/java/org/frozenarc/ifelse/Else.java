package org.frozenarc.ifelse;

public interface Else<T, S> {

    Work<T, S> els(Do<T, S> elsFn);

}
