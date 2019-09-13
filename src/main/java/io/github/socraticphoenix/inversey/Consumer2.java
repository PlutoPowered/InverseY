package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.ConsumerX;

public interface Consumer2<P1, P2> extends ConsumerX, DangerousConsumer2<RuntimeException, P1, P2> {

    void accept(P1 p1, P2 p2);

    @Override
    default void acceptArray(Object... params) {
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
