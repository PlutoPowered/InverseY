/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface DangerousFunction1<P1, R, T extends Throwable> extends DangerousConsumer1<P1, T> {

    R invoke(P1 p1) throws T;

    @Override
    default void call(P1 p1) throws T {
        this.invoke(p1);
    }

}
