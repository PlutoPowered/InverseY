package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.DangerousConsumerX;

public interface DangerousConsumer27<T extends Throwable, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, P24, P25, P26, P27> extends DangerousConsumerX<T> {

    void accept(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14, P15 p15, P16 p16, P17 p17, P18 p18, P19 p19, P20 p20, P21 p21, P22 p22, P23 p23, P24 p24, P25 p25, P26 p26, P27 p27) throws T;

    @Override
    default void acceptArray(Object... params) throws T {
        if ((params.length != 27)) {
            throw new IllegalArgumentException("Expected exactly 27 parameters");
        }
        this.accept((P1) params[0], (P2) params[1], (P3) params[2], (P4) params[3], (P5) params[4], (P6) params[5], (P7) params[6], (P8) params[7], (P9) params[8], (P10) params[9], (P11) params[10], (P12) params[11], (P13) params[12], (P14) params[13], (P15) params[14], (P16) params[15], (P17) params[16], (P18) params[17], (P19) params[18], (P20) params[19], (P21) params[20], (P22) params[21], (P23) params[22], (P24) params[23], (P25) params[24], (P26) params[25], (P27) params[26]);
    }

    @Override
    default int parameterCount() {
        return 27;
    }

}
