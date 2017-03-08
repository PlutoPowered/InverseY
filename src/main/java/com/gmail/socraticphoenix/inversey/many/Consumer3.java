/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface Consumer3<P1, P2, P3> extends DangerousConsumer3<P1, P2, P3, RuntimeException> {

    void call(P1 p1, P2 p2, P3 p3);

    default <T extends Throwable> DangerousConsumer3<P1, P2, P3, T> cast() {
        return (DangerousConsumer3<P1, P2, P3, T>) this;
    }
}