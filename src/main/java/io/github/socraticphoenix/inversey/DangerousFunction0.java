package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.DangerousFunctionX;

public interface DangerousFunction0<R, T extends Throwable> extends DangerousFunctionX<R, T>, DangerousConsumer0<T> {

    R apply() throws T;

    @Override
    default R applyArray(Object... params) throws T {
        if ((params.length != 0)) {
            throw new IllegalArgumentException("Expected exactly 0 parameters");
        }
        return this.apply();
    }

    @Override
    default void accept() throws T {
        this.apply();
    }

    @Override
    default int parameterCount() {
        return 0;
    }

}
