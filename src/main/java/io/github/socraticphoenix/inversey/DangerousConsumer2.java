package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.DangerousConsumerX;

public interface DangerousConsumer2<T extends Throwable, P1, P2> extends DangerousConsumerX<T> {

    void accept(P1 p1, P2 p2) throws T;

    @Override
    default void acceptArray(Object... params) throws T {
        if ((params.length != 2)) {
            throw new IllegalArgumentException("Expected exactly 2 parameters");
        }
        this.accept((P1) params[0], (P2) params[1]);
    }

    @Override
    default int parameterCount() {
        return 2;
    }

}
