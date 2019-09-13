package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.DangerousConsumerX;

public interface DangerousConsumer3<T extends Throwable, P1, P2, P3> extends DangerousConsumerX<T> {

    void accept(P1 p1, P2 p2, P3 p3) throws T;

    @Override
    default void acceptArray(Object... params) throws T {
        if ((params.length != 3)) {
            throw new IllegalArgumentException("Expected exactly 3 parameters");
        }
        this.accept((P1) params[0], (P2) params[1], (P3) params[2]);
    }

    @Override
    default int parameterCount() {
        return 3;
    }

}
