/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface DangerousFunction2<P1, P2, R, T extends Throwable> extends DangerousConsumer2<P1, P2, T> {

    R invoke(P1 p1, P2 p2) throws T;

    @Override
    default void call(P1 p1, P2 p2) throws T {
        this.invoke(p1, p2);
    }

}
