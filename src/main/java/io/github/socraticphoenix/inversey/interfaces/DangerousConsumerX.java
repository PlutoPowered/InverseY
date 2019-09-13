package io.github.socraticphoenix.inversey.interfaces;

public interface DangerousConsumerX<T extends Throwable> {

    void acceptArray(Object... params) throws T;

    int parameterCount();

}
