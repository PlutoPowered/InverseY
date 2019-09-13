package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.ConsumerX;

public interface Consumer1<P1> extends ConsumerX, DangerousConsumer1<RuntimeException, P1> {

    void accept(P1 p1);

    @Override
    default void acceptArray(Object... params) {
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
