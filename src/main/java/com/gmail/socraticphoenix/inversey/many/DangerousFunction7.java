/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface DangerousFunction7<P1, P2, P3, P4, P5, P6, P7, R, T extends Throwable> extends DangerousConsumer7<P1, P2, P3, P4, P5, P6, P7, T> {

    R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7) throws T;

    @Override
    default void call(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7) throws T {
        this.invoke(p1, p2, p3, p4, p5, p6, p7);
    }

}
