package io.github.socraticphoenix.inversey.interfaces;

public interface FunctionX<R> extends DangerousFunctionX<R, RuntimeException>, ConsumerX {

    R applyArray(Object... params);

    int parameterCount();

    @Override
    default void acceptArray(Object... params) {
        applyArray(params);
    }

}
