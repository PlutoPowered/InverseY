package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.FunctionX;

public interface Function1<R, P1> extends FunctionX<R>, DangerousFunction1<R, RuntimeException, P1> {

    R apply(P1 p1);

    @Override
    default R applyArray(Object... params) {
        if ((params.length != 1)) {
            throw new IllegalArgumentException("Expected exactly 1 parameters");
        }
        return this.apply((P1) params[0]);
    }

    @Override
    default void acceptArray(Object... params) {
        if ((params.length != 1)) {
            throw new IllegalArgumentException("Expected exactly 1 parameters");
        }
        this.accept((P1) params[0]);
    }

    @Override
    default void accept(P1 p1) {
        this.apply(p1);
    }

    @Override
    default int parameterCount() {
        return 1;
    }

}
