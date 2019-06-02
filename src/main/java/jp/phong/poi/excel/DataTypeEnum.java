package jp.phong.poi.excel;

public enum DataTypeEnum {
    DOUBLE("Double"),
    INTEGER("Integer"),
    STRING("String"),
    DATE("Date");

    final String typeValue;

    DataTypeEnum(final String typeValue) {
        this.typeValue = typeValue;
    }

    public String getName() {
        return name();
    }

    public String getValue() {
        return typeValue;
    }

    @Override
    public String toString() {
        return name();
    }
}
