/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface Function4<P1, P2, P3, P4, R> extends Consumer4<P1, P2, P3, P4>, DangerousConsumer4<P1, P2, P3, P4, RuntimeException>, DangerousFunction4<P1, P2, P3, P4, R, RuntimeException> {

    R invoke(P1 p1, P2 p2, P3 p3, P4 p4);

    @Override
    default <T extends Throwable> DangerousFunction4<P1, P2, P3, P4, R, T> cast() {
        return (DangerousFunction4<P1, P2, P3, P4, R, T>) this;
    }

    @Override
    default void call(P1 p1, P2 p2, P3 p3, P4 p4) {
        this.invoke(p1, p2, p3, p4);
    }

}
