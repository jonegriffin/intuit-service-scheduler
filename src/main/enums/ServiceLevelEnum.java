package main.enums;

public enum ServiceLevelEnum {
    VIP(1),
    NORMAL(2);

    public final Integer serviceLevel;

    private ServiceLevelEnum(Integer serviceLevel) {
        this.serviceLevel = serviceLevel;
    }
}
