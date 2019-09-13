package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.DangerousConsumerX;

public interface DangerousConsumer0<T extends Throwable> extends DangerousConsumerX<T> {

    void accept() throws T;

    @Override
    default void acceptArray(Object... params) throws T {
        if ((params.length != 0)) {
            throw new IllegalArgumentException("Expected exactly 0 parameters");
        }
        this.accept();
    }

    @Override
    default int parameterCount() {
        return 0;
    }

}
