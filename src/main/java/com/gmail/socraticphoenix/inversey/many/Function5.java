/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface Function5<P1, P2, P3, P4, P5, R> extends Consumer5<P1, P2, P3, P4, P5>, DangerousConsumer5<P1, P2, P3, P4, P5, RuntimeException>, DangerousFunction5<P1, P2, P3, P4, P5, R, RuntimeException> {

    R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);

    @Override
    default <T extends Throwable> DangerousFunction5<P1, P2, P3, P4, P5, R, T> cast() {
        return (DangerousFunction5<P1, P2, P3, P4, P5, R, T>) this;
    }

    @Override
    default void call(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5) {
        this.invoke(p1, p2, p3, p4, p5);
    }

}
