package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.DangerousConsumerX;

public interface DangerousConsumer53<T extends Throwable, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, P24, P25, P26, P27, P28, P29, P30, P31, P32, P33, P34, P35, P36, P37, P38, P39, P40, P41, P42, P43, P44, P45, P46, P47, P48, P49, P50, P51, P52, P53> extends DangerousConsumerX<T> {

    void accept(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14, P15 p15, P16 p16, P17 p17, P18 p18, P19 p19, P20 p20, P21 p21, P22 p22, P23 p23, P24 p24, P25 p25, P26 p26, P27 p27, P28 p28, P29 p29, P30 p30, P31 p31, P32 p32, P33 p33, P34 p34, P35 p35, P36 p36, P37 p37, P38 p38, P39 p39, P40 p40, P41 p41, P42 p42, P43 p43, P44 p44, P45 p45, P46 p46, P47 p47, P48 p48, P49 p49, P50 p50, P51 p51, P52 p52, P53 p53) throws T;

    @Override
    default void acceptArray(Object... params) throws T {
        if ((params.length != 53)) {
            throw new IllegalArgumentException("Expected exactly 53 parameters");
        }
        this.accept((P1) params[0], (P2) params[1], (P3) params[2], (P4) params[3], (P5) params[4], (P6) params[5], (P7) params[6], (P8) params[7], (P9) params[8], (P10) params[9], (P11) params[10], (P12) params[11], (P13) params[12], (P14) params[13], (P15) params[14], (P16) params[15], (P17) params[16], (P18) params[17], (P19) params[18], (P20) params[19], (P21) params[20], (P22) params[21], (P23) params[22], (P24) params[23], (P25) params[24], (P26) params[25], (P27) params[26], (P28) params[27], (P29) params[28], (P30) params[29], (P31) params[30], (P32) params[31], (P33) params[32], (P34) params[33], (P35) params[34], (P36) params[35], (P37) params[36], (P38) params[37], (P39) params[38], (P40) params[39], (P41) params[40], (P42) params[41], (P43) params[42], (P44) params[43], (P45) params[44], (P46) params[45], (P47) params[46], (P48) params[47], (P49) params[48], (P50) params[49], (P51) params[50], (P52) params[51], (P53) params[52]);
    }

    @Override
    default int parameterCount() {
        return 53;
    }

}
