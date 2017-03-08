/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface Function6<P1, P2, P3, P4, P5, P6, R> extends Consumer6<P1, P2, P3, P4, P5, P6>, DangerousConsumer6<P1, P2, P3, P4, P5, P6, RuntimeException>, DangerousFunction6<P1, P2, P3, P4, P5, P6, R, RuntimeException> {

    R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6);

    @Override
    default <T extends Throwable> DangerousFunction6<P1, P2, P3, P4, P5, P6, R, T> cast() {
        return (DangerousFunction6<P1, P2, P3, P4, P5, P6, R, T>) this;
    }

    @Override
    default void call(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6) {
        this.invoke(p1, p2, p3, p4, p5, p6);
    }

}
