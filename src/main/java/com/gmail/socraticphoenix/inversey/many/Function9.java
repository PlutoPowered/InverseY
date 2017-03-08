/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface Function9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> extends Consumer9<P1, P2, P3, P4, P5, P6, P7, P8, P9>, DangerousConsumer9<P1, P2, P3, P4, P5, P6, P7, P8, P9, RuntimeException>, DangerousFunction9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, RuntimeException> {

    R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9);

    @Override
    default <T extends Throwable> DangerousFunction9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, T> cast() {
        return (DangerousFunction9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, T>) this;
    }

    @Override
    default void call(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9) {
        this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

}
