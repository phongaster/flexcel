package jp.phong.xlsmapper.fieldprocessor.impl;

import java.util.Map;

public class RecordMultiHeader {
    /**
     * 見出しの値
     */
    private final Map<String, String> multiHeader;
    /**
     * 表の開始位置からの距離
     */
    private final int interval;

    public RecordMultiHeader(Map<String, String> multiHeader, int interval) {
        this.multiHeader = multiHeader;
        this.interval = interval;
    }

    public Map<String, String> getMultiHeader() {
        return multiHeader;
    }

    public int getInterval() {
        return interval;
    }

    @Override
    public String toString() {
        return "RecordMultiHeader{" +
                "multiHeader=" + multiHeader +
                ", interval=" + interval +
                '}';
    }
}
