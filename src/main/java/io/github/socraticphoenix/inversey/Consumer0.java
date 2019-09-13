package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.ConsumerX;

public interface Consumer0 extends ConsumerX, DangerousConsumer0<RuntimeException> {

    void accept();

    @Override
    default void acceptArray(Object... params) {
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
