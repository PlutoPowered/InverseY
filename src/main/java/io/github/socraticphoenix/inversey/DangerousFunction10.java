package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.DangerousFunctionX;

public interface DangerousFunction10<R, T extends Throwable, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> extends DangerousFunctionX<R, T>, DangerousConsumer10<T, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> {

    R apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10) throws T;

    @Override
    default R applyArray(Object... params) throws T {
        if ((params.length != 10)) {
            throw new IllegalArgumentException("Expected exactly 10 parameters");
        }
        return this.apply((P1) params[0], (P2) params[1], (P3) params[2], (P4) params[3], (P5) params[4], (P6) params[5], (P7) params[6], (P8) params[7], (P9) params[8], (P10) params[9]);
    }

    @Override
    default void accept(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10) throws T {
        this.apply(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    @Override
    default int parameterCount() {
        return 10;
    }

}