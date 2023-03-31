package edu.hm.gaertner.simon.lab23.a05;
@SuppressWarnings({"PMD.FieldNamingConventions",
        "checkstyle:JavadocVariable"})
public enum Units {
    MM,
    M,
    KM,
    MI,
    CM,
    FT;

    public double recalculate(Units targetUnit, double oldAmount){
        return switch (this) {
            case M -> switch (targetUnit) {
                case MM -> oldAmount * 100 * 10;
                case M  -> oldAmount;
                case KM -> oldAmount / 1000;
                case MI -> oldAmount * 0.000621;
                case CM -> oldAmount * 100;
                case FT -> oldAmount * 3.2808398950131;
            };
            case MM -> switch (targetUnit) {
                case MM -> oldAmount;
                case M -> oldAmount / 10 / 100;
                case KM -> oldAmount / 10 / 100 / 1000;
                case MI -> oldAmount * 6.213712121212e-7;
                case CM -> oldAmount / 10;
                case FT -> oldAmount * 0.00328084;
            };
            case KM -> switch (targetUnit) {
                case MM -> oldAmount * 1000 * 100 * 10;
                case M -> oldAmount * 1000;
                case KM -> oldAmount;
                case MI -> oldAmount * 0.62137121212120016711;
                case CM -> oldAmount * 1000 * 100;
                case FT -> oldAmount * 3280.84;
            };
            case MI -> switch (targetUnit) {
                case MM -> oldAmount * 1.609e+6;
                case M -> oldAmount * 1609.34;
                case KM -> oldAmount * 1.60934;
                case MI -> oldAmount;
                case CM -> oldAmount * 160934;
                case FT -> oldAmount * 5280;
            };
            case FT -> switch (targetUnit) {
                case MM -> oldAmount * 304.8;
                case M -> oldAmount * 0.3048;
                case KM -> oldAmount * 0.0003048;
                case MI -> oldAmount * 0.000189394;
                case CM -> oldAmount * 30.48;
                case FT -> oldAmount;
            };
            case CM -> switch (targetUnit) {
                case MM -> oldAmount * 10;
                case M -> oldAmount / 100;
                case KM -> oldAmount / 1000 / 100;
                case MI -> oldAmount * 6.2137e-6;
                case CM -> oldAmount;
                case FT -> oldAmount * 0.0328084;
            };
        };
    }
}
