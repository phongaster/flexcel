package jp.phong.xlsmapper.record;

import com.gh.mygreen.xlsmapper.annotation.*;
import com.gh.mygreen.xlsmapper.util.CellPosition;
import jp.phong.util.RuntimeAnnotations;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XlsListener(TestCaseRecordListener.class)
public class TestCaseRecord {

    // マッピングした位置情報
//    private Map<String, CellPosition> positions;

    // 汎用的な見出し情報
//    public Map<String, String> labels;

//    private String noLabel;

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

    // アドレス形式、配列にマッピング
    @XlsArrayColumns(columnName = "test value",size = 6, optional = true)
    private ArrayList<String> testValues;

    @XlsPostLoad
    public void handlePostLoad(final Sheet sheet) {
    }

    @XlsPreLoad
    public void handlePreLoad(final Sheet sheet) {

    }
}

