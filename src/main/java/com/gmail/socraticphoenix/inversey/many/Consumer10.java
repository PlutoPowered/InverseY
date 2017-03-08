/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface Consumer10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> extends DangerousConsumer10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, RuntimeException> {

    void call(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10);

    default <T extends Throwable> DangerousConsumer10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, T> cast() {
        return (DangerousConsumer10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, T>) this;
    }
}