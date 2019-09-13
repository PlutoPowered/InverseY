package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.FunctionX;

public interface Function7<R, P1, P2, P3, P4, P5, P6, P7> extends FunctionX<R>, DangerousFunction7<R, RuntimeException, P1, P2, P3, P4, P5, P6, P7> {

    R apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7);

    @Override
    default R applyArray(Object... params) {
        if ((params.length != 7)) {
            throw new IllegalArgumentException("Expected exactly 7 parameters");
        }
        return this.apply((P1) params[0], (P2) params[1], (P3) params[2], (P4) params[3], (P5) params[4], (P6) params[5], (P7) params[6]);
    }

    @Override
    default void acceptArray(Object... params) {
        if ((params.length != 7)) {
            throw new IllegalArgumentException("Expected exactly 7 parameters");
        }
        this.accept((P1) params[0], (P2) params[1], (P3) params[2], (P4) params[3], (P5) params[4], (P6) params[5], (P7) params[6]);
    }

    @Override
    default void accept(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7) {
        this.apply(p1, p2, p3, p4, p5, p6, p7);
    }

    @Override
    default int parameterCount() {
        return 7;
    }

}
