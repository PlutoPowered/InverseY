/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface Function12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R> extends Consumer12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>, DangerousConsumer12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, RuntimeException>, DangerousFunction12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R, RuntimeException> {

    R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12);

    @Override
    default <T extends Throwable> DangerousFunction12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R, T> cast() {
        return (DangerousFunction12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R, T>) this;
    }

    @Override
    default void call(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12) {
        this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
    }

}