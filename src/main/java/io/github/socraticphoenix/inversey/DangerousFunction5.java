package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.DangerousFunctionX;

public interface DangerousFunction5<R, T extends Throwable, P1, P2, P3, P4, P5> extends DangerousFunctionX<R, T>, DangerousConsumer5<T, P1, P2, P3, P4, P5> {

    R apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5) throws T;

    @Override
    default R applyArray(Object... params) throws T {
        if ((params.length != 5)) {
            throw new IllegalArgumentException("Expected exactly 5 parameters");
        }
        return this.apply((P1) params[0], (P2) params[1], (P3) params[2], (P4) params[3], (P5) params[4]);
    }

    @Override
    default void accept(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5) throws T {
        this.apply(p1, p2, p3, p4, p5);
    }

    @Override
    default int parameterCount() {
        return 5;
    }

}
