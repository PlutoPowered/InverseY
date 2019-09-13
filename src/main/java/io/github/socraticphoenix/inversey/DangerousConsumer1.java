package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.DangerousConsumerX;

public interface DangerousConsumer1<T extends Throwable, P1> extends DangerousConsumerX<T> {

    void accept(P1 p1) throws T;

    @Override
    default void acceptArray(Object... params) throws T {
        if ((params.length != 1)) {
            throw new IllegalArgumentException("Expected exactly 1 parameters");
        }
        this.accept((P1) params[0]);
    }

    @Override
    default int parameterCount() {
        return 1;
    }

}
