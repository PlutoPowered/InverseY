package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.DangerousConsumerX;

public interface DangerousConsumer6<T extends Throwable, P1, P2, P3, P4, P5, P6> extends DangerousConsumerX<T> {

    void accept(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6) throws T;

    @Override
    default void acceptArray(Object... params) throws T {
        if ((params.length != 6)) {
            throw new IllegalArgumentException("Expected exactly 6 parameters");
        }
        this.accept((P1) params[0], (P2) params[1], (P3) params[2], (P4) params[3], (P5) params[4], (P6) params[5]);
    }

    @Override
    default int parameterCount() {
        return 6;
    }

}
