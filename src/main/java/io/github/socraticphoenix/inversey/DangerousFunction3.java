package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.DangerousFunctionX;

public interface DangerousFunction3<R, T extends Throwable, P1, P2, P3> extends DangerousFunctionX<R, T>, DangerousConsumer3<T, P1, P2, P3> {

    R apply(P1 p1, P2 p2, P3 p3) throws T;

    @Override
    default R applyArray(Object... params) throws T {
        if ((params.length != 3)) {
            throw new IllegalArgumentException("Expected exactly 3 parameters");
        }
        return this.apply((P1) params[0], (P2) params[1], (P3) params[2]);
    }

    @Override
    default void accept(P1 p1, P2 p2, P3 p3) throws T {
        this.apply(p1, p2, p3);
    }

    @Override
    default int parameterCount() {
        return 3;
    }

}
