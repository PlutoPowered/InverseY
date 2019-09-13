package io.github.socraticphoenix.inversey;

import io.github.socraticphoenix.inversey.interfaces.ConsumerX;

public interface Consumer102<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, P24, P25, P26, P27, P28, P29, P30, P31, P32, P33, P34, P35, P36, P37, P38, P39, P40, P41, P42, P43, P44, P45, P46, P47, P48, P49, P50, P51, P52, P53, P54, P55, P56, P57, P58, P59, P60, P61, P62, P63, P64, P65, P66, P67, P68, P69, P70, P71, P72, P73, P74, P75, P76, P77, P78, P79, P80, P81, P82, P83, P84, P85, P86, P87, P88, P89, P90, P91, P92, P93, P94, P95, P96, P97, P98, P99, P100, P101, P102> extends ConsumerX, DangerousConsumer102<RuntimeException, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, P24, P25, P26, P27, P28, P29, P30, P31, P32, P33, P34, P35, P36, P37, P38, P39, P40, P41, P42, P43, P44, P45, P46, P47, P48, P49, P50, P51, P52, P53, P54, P55, P56, P57, P58, P59, P60, P61, P62, P63, P64, P65, P66, P67, P68, P69, P70, P71, P72, P73, P74, P75, P76, P77, P78, P79, P80, P81, P82, P83, P84, P85, P86, P87, P88, P89, P90, P91, P92, P93, P94, P95, P96, P97, P98, P99, P100, P101, P102> {

    void accept(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14, P15 p15, P16 p16, P17 p17, P18 p18, P19 p19, P20 p20, P21 p21, P22 p22, P23 p23, P24 p24, P25 p25, P26 p26, P27 p27, P28 p28, P29 p29, P30 p30, P31 p31, P32 p32, P33 p33, P34 p34, P35 p35, P36 p36, P37 p37, P38 p38, P39 p39, P40 p40, P41 p41, P42 p42, P43 p43, P44 p44, P45 p45, P46 p46, P47 p47, P48 p48, P49 p49, P50 p50, P51 p51, P52 p52, P53 p53, P54 p54, P55 p55, P56 p56, P57 p57, P58 p58, P59 p59, P60 p60, P61 p61, P62 p62, P63 p63, P64 p64, P65 p65, P66 p66, P67 p67, P68 p68, P69 p69, P70 p70, P71 p71, P72 p72, P73 p73, P74 p74, P75 p75, P76 p76, P77 p77, P78 p78, P79 p79, P80 p80, P81 p81, P82 p82, P83 p83, P84 p84, P85 p85, P86 p86, P87 p87, P88 p88, P89 p89, P90 p90, P91 p91, P92 p92, P93 p93, P94 p94, P95 p95, P96 p96, P97 p97, P98 p98, P99 p99, P100 p100, P101 p101, P102 p102);

    @Override
    default void acceptArray(Object... params) {
        if ((params.length != 102)) {
            throw new IllegalArgumentException("Expected exactly 102 parameters");
        }
        this.accept((P1) params[0], (P2) params[1], (P3) params[2], (P4) params[3], (P5) params[4], (P6) params[5], (P7) params[6], (P8) params[7], (P9) params[8], (P10) params[9], (P11) params[10], (P12) params[11], (P13) params[12], (P14) params[13], (P15) params[14], (P16) params[15], (P17) params[16], (P18) params[17], (P19) params[18], (P20) params[19], (P21) params[20], (P22) params[21], (P23) params[22], (P24) params[23], (P25) params[24], (P26) params[25], (P27) params[26], (P28) params[27], (P29) params[28], (P30) params[29], (P31) params[30], (P32) params[31], (P33) params[32], (P34) params[33], (P35) params[34], (P36) params[35], (P37) params[36], (P38) params[37], (P39) params[38], (P40) params[39], (P41) params[40], (P42) params[41], (P43) params[42], (P44) params[43], (P45) params[44], (P46) params[45], (P47) params[46], (P48) params[47], (P49) params[48], (P50) params[49], (P51) params[50], (P52) params[51], (P53) params[52], (P54) params[53], (P55) params[54], (P56) params[55], (P57) params[56], (P58) params[57], (P59) params[58], (P60) params[59], (P61) params[60], (P62) params[61], (P63) params[62], (P64) params[63], (P65) params[64], (P66) params[65], (P67) params[66], (P68) params[67], (P69) params[68], (P70) params[69], (P71) params[70], (P72) params[71], (P73) params[72], (P74) params[73], (P75) params[74], (P76) params[75], (P77) params[76], (P78) params[77], (P79) params[78], (P80) params[79], (P81) params[80], (P82) params[81], (P83) params[82], (P84) params[83], (P85) params[84], (P86) params[85], (P87) params[86], (P88) params[87], (P89) params[88], (P90) params[89], (P91) params[90], (P92) params[91], (P93) params[92], (P94) params[93], (P95) params[94], (P96) params[95], (P97) params[96], (P98) params[97], (P99) params[98], (P100) params[99], (P101) params[100], (P102) params[101]);
    }

    @Override
    default int parameterCount() {
        return 102;
    }

}
