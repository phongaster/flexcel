package jp.phong.xlsmapper.record;

import com.gh.mygreen.xlsmapper.annotation.*;
import com.gh.mygreen.xlsmapper.util.CellPosition;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XlsListener(TestCaseRecordListener.class)
public class TestCaseRecord {

    // マッピングした位置情報
    private Map<String, CellPosition> positions;

    // 汎用的な見出し情報
    //public Map<String, String> labels;

    private String noLabel;

    @XlsColumn(columnName = "No", optional = true)
    private int no;

    @XlsColumn(columnName = "tên fields")
    private String itemName;

    @XlsColumn(columnName = "Required?")
    @XlsBooleanConverter(loadForTrue = {"x"}, loadForFalse = {""}, saveAsTrue = "x", saveAsFalse = "", failToFalse = true)
    private boolean isRequired;

    @XlsColumn(columnName = "type")
    private String type;

    @XlsColumn(columnName = "number of digit")
    private int numberOfDigits;

    @XlsFormula(methodName = "test")
    private Map<String, String> map;

    @XlsVerticalRecords(headerColumn = 5, headerRow = 3, headerLimit = 2)
    List<TestCaseGroupRecord> groupList;

    // アドレス形式、配列にマッピング
    @XlsArrayColumns(columnName = "test value", size = 6)
    private List<String> testValues;

    @XlsPostLoad
    public void handlePostLoad(final Sheet sheet) {
    }
}

