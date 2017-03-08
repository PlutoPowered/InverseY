/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface DangerousFunction0<R, T extends Throwable> extends DangerousConsumer0<T> {

    R invoke() throws T;

    @Override
    default void call() throws T {
        this.invoke();
    }

}
