package io.github.socraticphoenix.inversey.interfaces;

public interface DangerousFunctionX<R, T extends Throwable> extends DangerousConsumerX<T> {

    R applyArray(Object... params) throws T;

    int parameterCount();

}
