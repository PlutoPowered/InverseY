/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface Consumer9<P1, P2, P3, P4, P5, P6, P7, P8, P9> extends DangerousConsumer9<P1, P2, P3, P4, P5, P6, P7, P8, P9, RuntimeException> {

    void call(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9);

    default <T extends Throwable> DangerousConsumer9<P1, P2, P3, P4, P5, P6, P7, P8, P9, T> cast() {
        return (DangerousConsumer9<P1, P2, P3, P4, P5, P6, P7, P8, P9, T>) this;
    }
}