package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.DangerousFunctionX;

public interface DangerousFunction2<R, T extends Throwable, P1, P2> extends DangerousFunctionX<R, T>, DangerousConsumer2<T, P1, P2> {

    R apply(P1 p1, P2 p2) throws T;

    @Override
    default R applyArray(Object... params) throws T {
        if ((params.length != 2)) {
            throw new IllegalArgumentException("Expected exactly 2 parameters");
        }
        return this.apply((P1) params[0], (P2) params[1]);
    }

    @Override
    default void accept(P1 p1, P2 p2) throws T {
        this.apply(p1, p2);
    }

    @Override
    default int parameterCount() {
        return 2;
    }

}
