package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.ConsumerX;

public interface Consumer4<P1, P2, P3, P4> extends ConsumerX, DangerousConsumer4<RuntimeException, P1, P2, P3, P4> {

    void accept(P1 p1, P2 p2, P3 p3, P4 p4);

    @Override
    default void acceptArray(Object... params) {
        if ((params.length != 4)) {
            throw new IllegalArgumentException("Expected exactly 4 parameters");
        }
        this.accept((P1) params[0], (P2) params[1], (P3) params[2], (P4) params[3]);
    }

    @Override
    default int parameterCount() {
        return 4;
    }

}
