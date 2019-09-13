package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.DangerousFunctionX;

public interface DangerousFunction1<R, T extends Throwable, P1> extends DangerousFunctionX<R, T>, DangerousConsumer1<T, P1> {

    R apply(P1 p1) throws T;

    @Override
    default R applyArray(Object... params) throws T {
        if ((params.length != 1)) {
            throw new IllegalArgumentException("Expected exactly 1 parameters");
        }
        return this.apply((P1) params[0]);
    }

    @Override
    default void accept(P1 p1) throws T {
        this.apply(p1);
    }

    @Override
    default int parameterCount() {
        return 1;
    }

}
