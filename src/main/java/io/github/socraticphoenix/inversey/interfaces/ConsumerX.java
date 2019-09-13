package io.github.socraticphoenix.inversey.interfaces;

public interface ConsumerX extends DangerousConsumerX<RuntimeException> {

    void acceptArray(Object... params);

    int parameterCount();

}
