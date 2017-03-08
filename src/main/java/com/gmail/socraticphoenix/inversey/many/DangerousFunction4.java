/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface DangerousFunction4<P1, P2, P3, P4, R, T extends Throwable> extends DangerousConsumer4<P1, P2, P3, P4, T> {

    R invoke(P1 p1, P2 p2, P3 p3, P4 p4) throws T;

    @Override
    default void call(P1 p1, P2 p2, P3 p3, P4 p4) throws T {
        this.invoke(p1, p2, p3, p4);
    }

}
