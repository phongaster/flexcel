package jp.phong.xlsmapper.fieldprocessor

import jp.phong.xlsmapper.annotation.XlsMapMultiHeader

import static com.gh.mygreen.xlsmapper.xml.XmlBuilder.*;

import com.gh.mygreen.xlsmapper.XlsMapper
import com.gh.mygreen.xlsmapper.annotation.XlsSheet
import com.gh.mygreen.xlsmapper.annotation.XlsSheetName
import com.gh.mygreen.xlsmapper.validation.SheetBindingErrors
import com.gh.mygreen.xlsmapper.xml.bind.AnnotationMappingInfo
import jp.phong.xlsmapper.fieldprocessor.impl.MultiHeaderProcessor
import jp.phong.xlsmapper.sheet.TestCaseSheet
import spock.lang.Specification


class MultiHeaderProcessorSpec extends Specification {

    /**
     * 読み込み用のファイルの定義
     */
    private File inputFile = new File("src/test/resources/ComplicatedWorkbook.xlsx")

    /**
     *
     */
    private XlsMapper mapper

    void setup() {
        mapper = new XlsMapper()
    }

    def 'should get group values'() {
        given: 'create AnnotationMappingInfo'
        AnnotationMappingInfo xmlInfo = createXml()
                .classInfo(createClass(TestCaseSheet.class)
                        .field(createField("groupValues")
                                .annotation(createAnnotation(XlsMapMultiHeader.class)
                                        .attribute("groupColumnAddress", "F4")
                                        .buildAnnotation())
                                .buildField())
                        .buildClass())
                .buildXml()
        mapper.getConiguration().setAnnotationMapping(xmlInfo);

        when: 'load sheet details'
        def input = new FileInputStream(inputFile)
        SheetBindingErrors<TestCaseSheet> errors = mapper.loadDetail(input, TestCaseSheet.class)
        TestCaseSheet sheet = errors.getTarget()

        then: 'group values should be null'
        sheet.groupValues == null
    }

    def 'should get group records'() {

    }

}