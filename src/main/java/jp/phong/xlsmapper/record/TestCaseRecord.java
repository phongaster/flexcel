package jp.phong.xlsmapper.record;

import com.gh.mygreen.xlsmapper.annotation.*;
import com.gh.mygreen.xlsmapper.util.CellPosition;
import jp.phong.util.RuntimeAnnotations;
import org.apache.poi.ss.usermodel.Sheet;

import java.lang.annotation.Annotation;
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
    // set max size 'cause can not change it here (final)
    @XlsArrayColumns(columnName = "test value",size = 100, optional = true)
    private ArrayList<String> testValues;

    @XlsPostLoad
    public void handlePostLoad(final Sheet sheet) {

    }

    @XlsPreLoad
    public void handlePreLoad(final Sheet sheet) {
//        XlsArrayColumns[] annotation = TestCaseRecord.class.getAnnotationsByType(XlsArrayColumns.class);
//        System.out.println("TestClass annotation before:" + annotation);

//        Map<String, Object> valuesMap = new HashMap<>();
//        valuesMap.put("size", 6);
//        RuntimeAnnotations.putAnnotation(TestCaseRecord.class, XlsArrayColumns.class, valuesMap);
//
//        annotation = TestCaseRecord.class.getAnnotation(XlsArrayColumns.class);
//        System.out.println("TestClass annotation after:" + annotation);
    }
}

