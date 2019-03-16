package org.frozenarc.ifelse;

public interface Else<T, U> {

    Work<T, U> els(Do<T, U> elsFn);
}
