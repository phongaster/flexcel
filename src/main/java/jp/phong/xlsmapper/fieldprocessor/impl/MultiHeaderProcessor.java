package jp.phong.xlsmapper.fieldprocessor.impl;

import com.gh.mygreen.xlsmapper.*;
import com.gh.mygreen.xlsmapper.annotation.XlsHorizontalRecords;
import com.gh.mygreen.xlsmapper.fieldaccessor.FieldAccessor;
import com.gh.mygreen.xlsmapper.fieldprocessor.AbstractFieldProcessor;
import com.gh.mygreen.xlsmapper.util.CellPosition;
import com.gh.mygreen.xlsmapper.util.POIUtils;
import jp.phong.xlsmapper.annotation.XlsMapMultiHeader;
import jp.phong.xlsmapper.record.GroupValue;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.*;

public class MultiHeaderProcessor extends AbstractFieldProcessor<XlsMapMultiHeader> {

    /**
     * 読み込み時のアノテーションを処理する。
     *
     * @param sheet    Excelのシート
     * @param beansObj マッピング対象のBean。
     * @param anno     処理対象のアノテーション。
     * @param accessor マッピング対象のフィールド情報
     * @param config   システム設定
     * @param work     一時オブジェクト
     * @throws XlsMapperException 読み込み時に失敗した場合
     */
    @Override
    public void loadProcess(Sheet sheet, Object beansObj, XlsMapMultiHeader anno, FieldAccessor accessor, Configuration config, LoadingWorkObject work) throws XlsMapperException {

//        if(!Utils.isLoadCase(anno.cases())) {
//            return;
//        }
//
//        Class<?> recordClass = anno.recordClass();
//        if(recordClass == Object.class) {
//            recordClass = accessor.getComponentType();
//        }

//        List<RecordMultiHeader> headers = this.getHeaders();
//        Map<Integer,GroupValue> value = loadRecords(sheet, headers, anno, initPosition, recordClass, config, work);
//        accessor.setValue(value);
//        Cell cell = POIUtils.getCell(sheet, CellPosition.of(anno.groupColumnAddress()));
//        String value = POIUtils.getCellContents(cell, config.getCellFormatter());
//        accessor.setValue(beansObj, value);

    }

//    private List<RecordMultiHeader> getHeaders() {
//        List<RecordMultiHeader> headers = new ArrayList<>();
//        return headers;
//    }

//    private Map<?,?> loadRecords(final Sheet sheet, final List<RecordMultiHeader> headers,
//                                final XlsHorizontalRecords anno,
//                                final CellPosition initPosition, final int parentMergedSize,
//                                final FieldAccessor accessor, final Class<?> recordClass,
//                                final Configuration config, final LoadingWorkObject work) throws XlsMapperException {
//        final Map<Integer, GroupValue> result = new HashMap<>();
//        //TODO: calculate positions of group and sub group
//        GroupValue groupValue = new GroupValue();
////        groupValue.setGroup(1);
////        groupValue.setSubGroup(1);
////        groupValue.setValue("aaa");
////        result.put(1, groupValue);
//        return result;
//    }

    /**
     * 書き込み時のアノテーションを処理する。
     *
     * @param sheet    Excelのシート
     * @param beansObj マッピング対象のBean。
     * @param anno     処理対象のアノテーション。
     * @param accessor マッピング対象のフィールド情報
     * @param config   システム設定
     * @param work     一時オブジェクト
     * @throws XlsMapperException 書き込み時に失敗した場合
     */
    @Override
    public void saveProcess(Sheet sheet, Object beansObj, XlsMapMultiHeader anno, FieldAccessor accessor, Configuration config, SavingWorkObject work) throws XlsMapperException {
    }
}
