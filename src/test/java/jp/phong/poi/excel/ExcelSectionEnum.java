package jp.phong.poi.excel;

public enum ExcelSectionEnum {
    SCREEN_DEFINITION("ScreenDefinition"), //
    TEST_CASE("TestCase");

    final String typeValue;

    private ExcelSectionEnum(final String typeValue) {
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