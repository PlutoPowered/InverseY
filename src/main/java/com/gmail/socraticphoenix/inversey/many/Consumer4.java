/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface Consumer4<P1, P2, P3, P4> extends DangerousConsumer4<P1, P2, P3, P4, RuntimeException> {

    void call(P1 p1, P2 p2, P3 p3, P4 p4);

    default <T extends Throwable> DangerousConsumer4<P1, P2, P3, P4, T> cast() {
        return (DangerousConsumer4<P1, P2, P3, P4, T>) this;
    }
}