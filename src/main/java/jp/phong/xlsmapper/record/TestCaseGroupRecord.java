package jp.phong.xlsmapper.record;

import com.gh.mygreen.xlsmapper.annotation.XlsColumn;

public class TestCaseGroupRecord {

    @XlsColumn(columnName="Group No",optional = true)
    int groupNo;
    @XlsColumn(columnName="Sub group No",optional = true)
    int subGroupNo;
}
