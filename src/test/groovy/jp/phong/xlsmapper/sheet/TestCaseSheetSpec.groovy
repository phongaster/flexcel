package jp.phong.xlsmapper.sheet

import com.gh.mygreen.xlsmapper.XlsMapper
import spock.lang.Specification

class TestCaseSheetSpec extends Specification {

    def 'should return a sheet object with corresponding fields'() {
        when: 'シートの読み込み'
        XlsMapper xlsMapper = new XlsMapper();
        TestCaseSheet sheet = xlsMapper.load(
                new FileInputStream("src/test/resources/ComplicatedWorkbook.xlsx"), // 読み込むExcelファイル。
                TestCaseSheet.class                     // シートマッピング用のPOJOクラス。
        )

        then: 'return correct information'
        sheet.screenName == "đăng ký user"
        sheet.screenID == "M001"
        sheet.testCases.each {
            switch (it.no) {
                case 1:
                    assert it.itemName == "username"
                    assert it.isRequired == true
                    assert it.type == "Text"
                    assert it.numberOfDigits == 50
                    assert it.testValues == ["tuannguyen", "xx", "tuanguyen1", "tuannguyen", "tuannguyen", "..."]
                    break
                case 2:
                    assert it.itemName == "password"
                    assert it.isRequired == true
                    assert it.type == "Text"
                    assert it.numberOfDigits == 50
                    break
                case 3:
                    assert it.itemName == "Login"
                    assert it.isRequired == true
                    assert it.type == "Text"
                    assert it.numberOfDigits == 50
                    break
            }
        }
        assert sheet.groups[0].groupNo == 1
    }
}