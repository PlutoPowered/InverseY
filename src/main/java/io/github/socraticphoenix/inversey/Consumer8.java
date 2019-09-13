package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.ConsumerX;

public interface Consumer8<P1, P2, P3, P4, P5, P6, P7, P8> extends ConsumerX, DangerousConsumer8<RuntimeException, P1, P2, P3, P4, P5, P6, P7, P8> {

    void accept(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8);

    @Override
    default void acceptArray(Object... params) {
        if ((params.length != 8)) {
            throw new IllegalArgumentException("Expected exactly 8 parameters");
        }
        this.accept((P1) params[0], (P2) params[1], (P3) params[2], (P4) params[3], (P5) params[4], (P6) params[5], (P7) params[6], (P8) params[7]);
    }

    @Override
    default int parameterCount() {
        return 8;
    }

}
