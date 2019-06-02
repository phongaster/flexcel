package jp.phong.xlsmapper.sheet;

import com.gh.mygreen.xlsmapper.annotation.*;
import jp.phong.xlsmapper.annotation.XlsMapMultiHeader;
import jp.phong.xlsmapper.fieldprocessor.impl.RecordMultiHeader;
import jp.phong.xlsmapper.record.GroupValue;
import jp.phong.xlsmapper.record.TestCaseGroupRecord;
import jp.phong.xlsmapper.record.TestCaseRecord;

import java.util.List;
import java.util.Map;

@XlsSheet(name="TestCase")
public class TestCaseSheet {

    @XlsLabelledCell(label = "tên màn hình", type = LabelledCellType.Right)
    String screenName;

    @XlsLabelledCell(label = "ID màn hình", type = LabelledCellType.Right)
    String screenID;

    @XlsOrder(1)
    @XlsVerticalRecords(headerColumn = 5, headerRow = 3, headerLimit = 2)
    List<TestCaseGroupRecord> groups;

    @XlsOrder(2)
    @XlsHorizontalRecords(headerColumn = 1, headerRow = 5)
    List<TestCaseRecord> testCases;
}
