/*
 * This file is an auto-generated element of InverseY
 */
package com.gmail.socraticphoenix.inversey.many;

public interface Function3<P1, P2, P3, R> extends Consumer3<P1, P2, P3>, DangerousConsumer3<P1, P2, P3, RuntimeException>, DangerousFunction3<P1, P2, P3, R, RuntimeException> {

    R invoke(P1 p1, P2 p2, P3 p3);

    @Override
    default <T extends Throwable> DangerousFunction3<P1, P2, P3, R, T> cast() {
        return (DangerousFunction3<P1, P2, P3, R, T>) this;
    }

    @Override
    default void call(P1 p1, P2 p2, P3 p3) {
        this.invoke(p1, p2, p3);
    }

}
