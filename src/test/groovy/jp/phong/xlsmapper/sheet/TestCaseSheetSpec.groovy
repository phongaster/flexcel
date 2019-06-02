package jp.phong.xlsmapper.sheet

import com.gh.mygreen.xlsmapper.XlsMapper
import spock.lang.Specification

class TestCaseSheetSpec extends Specification {

    def 'should return a sheet object with corresponding fields'() {
        when: 'シートの読み込み'
        XlsMapper xlsMapper = new XlsMapper()
        TestCaseSheet sheet = xlsMapper.load(
                new FileInputStream("src/test/resources/ComplicatedWorkbook.xlsx"), // 読み込むExcelファイル。
                TestCaseSheet.class                     // シートマッピング用のPOJOクラス。
        )

        // fix wrong things
        // remove redundant test values
        for(int i = 0; i < sheet.testCases.size(); i++) {
            sheet.testCases[i].testValues.subList(sheet.groups.size(), sheet.testCases[i].testValues.size()).clear()
        }


        then: 'return correct information'
        sheet.screenName == "đăng ký user"
        sheet.screenID == "M001"
        sheet.testCases.each {
            switch (it.no) {
                case 1:
                    assert it.itemName == "username"
                    assert it.isRequired
                    assert it.type == "Text"
                    assert it.numberOfDigits == 50
                    assert it.testValues == ["tuannguyen", "aaa", "tuanguyen1", "tuannguyen", "tuannguyen", "0"] // note that all are strings
                    break
                case 2:
                    assert it.itemName == "password"
                    assert it.isRequired
                    assert it.type == "Text"
                    assert it.numberOfDigits == 50
                    assert it.testValues == ["dfsdf", "123123", "123123", "123123", "123123", "0"]
                    break
                case 3:
                    assert it.itemName == "Login"
                    assert it.isRequired
                    assert it.type == "Text"
                    assert it.numberOfDigits == 50
                    assert it.testValues == ["dsfdfs", "x", "x", "x", "x", null]
                    break
            }
        }
        assert sheet.groups[0].groupNo == 1
        assert sheet.groups[0].subGroupNo == 1
        assert sheet.groups[1].groupNo == 1
        assert sheet.groups[1].subGroupNo == 2
        assert sheet.groups[2].groupNo == 2
        assert sheet.groups[2].subGroupNo == 1
        assert sheet.groups[3].groupNo == 2
        assert sheet.groups[3].subGroupNo == 2
        assert sheet.groups[4].groupNo == 2
        assert sheet.groups[4].subGroupNo == 3
        assert sheet.groups[5].groupNo == 2
        assert sheet.groups[5].subGroupNo == 4
    }
}