package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.ConsumerX;

public interface Consumer3<P1, P2, P3> extends ConsumerX, DangerousConsumer3<RuntimeException, P1, P2, P3> {

    void accept(P1 p1, P2 p2, P3 p3);

    @Override
    default void acceptArray(Object... params) {
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
