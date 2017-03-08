/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface Consumer7<P1, P2, P3, P4, P5, P6, P7> extends DangerousConsumer7<P1, P2, P3, P4, P5, P6, P7, RuntimeException> {

    void call(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7);

    default <T extends Throwable> DangerousConsumer7<P1, P2, P3, P4, P5, P6, P7, T> cast() {
        return (DangerousConsumer7<P1, P2, P3, P4, P5, P6, P7, T>) this;
    }
}