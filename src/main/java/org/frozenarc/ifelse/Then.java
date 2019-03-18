package org.frozenarc.ifelse;

public interface Then<T, S> {

    Else<T, S> thn(Do<T, S> thnFn);

}