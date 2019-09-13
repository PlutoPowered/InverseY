package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.FunctionX;

public interface Function0<R> extends FunctionX<R>, DangerousFunction0<R, RuntimeException> {

    R apply();

    @Override
    default R applyArray(Object... params) {
        if ((params.length != 0)) {
            throw new IllegalArgumentException("Expected exactly 0 parameters");
        }
        return this.apply();
    }

    @Override
    default void acceptArray(Object... params) {
        if ((params.length != 0)) {
            throw new IllegalArgumentException("Expected exactly 0 parameters");
        }
        this.accept();
    }

    @Override
    default void accept() {
        this.apply();
    }

    @Override
    default int parameterCount() {
        return 0;
    }

}
