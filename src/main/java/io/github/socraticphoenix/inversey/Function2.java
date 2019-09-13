package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.FunctionX;

public interface Function2<R, P1, P2> extends FunctionX<R>, DangerousFunction2<R, RuntimeException, P1, P2> {

    R apply(P1 p1, P2 p2);

    @Override
    default R applyArray(Object... params) {
        if ((params.length != 2)) {
            throw new IllegalArgumentException("Expected exactly 2 parameters");
        }
        return this.apply((P1) params[0], (P2) params[1]);
    }

    @Override
    default void acceptArray(Object... params) {
        if ((params.length != 2)) {
            throw new IllegalArgumentException("Expected exactly 2 parameters");
        }
        this.accept((P1) params[0], (P2) params[1]);
    }

    @Override
    default void accept(P1 p1, P2 p2) {
        this.apply(p1, p2);
    }

    @Override
    default int parameterCount() {
        return 2;
    }

}
