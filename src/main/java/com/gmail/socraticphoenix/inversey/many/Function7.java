/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface Function7<P1, P2, P3, P4, P5, P6, P7, R> extends Consumer7<P1, P2, P3, P4, P5, P6, P7>, DangerousConsumer7<P1, P2, P3, P4, P5, P6, P7, RuntimeException>, DangerousFunction7<P1, P2, P3, P4, P5, P6, P7, R, RuntimeException> {

    R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7);

    @Override
    default <T extends Throwable> DangerousFunction7<P1, P2, P3, P4, P5, P6, P7, R, T> cast() {
        return (DangerousFunction7<P1, P2, P3, P4, P5, P6, P7, R, T>) this;
    }

    @Override
    default void call(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7) {
        this.invoke(p1, p2, p3, p4, p5, p6, p7);
    }

}
