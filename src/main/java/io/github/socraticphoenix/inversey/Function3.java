package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.FunctionX;

public interface Function3<R, P1, P2, P3> extends FunctionX<R>, DangerousFunction3<R, RuntimeException, P1, P2, P3> {

    R apply(P1 p1, P2 p2, P3 p3);

    @Override
    default R applyArray(Object... params) {
        if ((params.length != 3)) {
            throw new IllegalArgumentException("Expected exactly 3 parameters");
        }
        return this.apply((P1) params[0], (P2) params[1], (P3) params[2]);
    }

    @Override
    default void acceptArray(Object... params) {
        if ((params.length != 3)) {
            throw new IllegalArgumentException("Expected exactly 3 parameters");
        }
        this.accept((P1) params[0], (P2) params[1], (P3) params[2]);
    }

    @Override
    default void accept(P1 p1, P2 p2, P3 p3) {
        this.apply(p1, p2, p3);
    }

    @Override
    default int parameterCount() {
        return 3;
    }

}
