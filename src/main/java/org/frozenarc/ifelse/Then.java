package org.frozenarc.ifelse;

public interface Then<T, U> {

    Else<T, U> thn(Do<T, U> thnFn);

}