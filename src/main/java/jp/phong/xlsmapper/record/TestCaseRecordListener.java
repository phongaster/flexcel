package jp.phong.xlsmapper.record;

import com.gh.mygreen.xlsmapper.Configuration;
import com.gh.mygreen.xlsmapper.annotation.XlsArrayColumns;
import com.gh.mygreen.xlsmapper.annotation.XlsPostLoad;
import com.gh.mygreen.xlsmapper.annotation.XlsPreLoad;
import com.gh.mygreen.xlsmapper.validation.SheetBindingErrors;
import com.gh.mygreen.xlsmapper.xml.bind.AnnotationMappingInfo;
import jp.phong.util.RuntimeAnnotations;
import jp.phong.xlsmapper.annotation.XlsMapMultiHeader;
import jp.phong.xlsmapper.sheet.TestCaseSheet;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.HashMap;
import java.util.Map;

import static com.gh.mygreen.xlsmapper.xml.XmlBuilder.*;
import static com.gh.mygreen.xlsmapper.xml.XmlBuilder.createAnnotation;

public class TestCaseRecordListener {

    @XlsPreLoad
    public void onPreLoad(TestCaseRecord targetObj, Sheet sheet, Configuration config, SheetBindingErrors errors) {
//        XlsArrayColumns annotation = TestCaseRecord.class.getAnnotation(XlsArrayColumns.class);
//        System.out.println("TestClass annotation before:" + annotation);
//
//        Map<String, Object> valuesMap = new HashMap<>();
//        valuesMap.put("size", 7);
//        RuntimeAnnotations.putAnnotation(TestCaseRecord.class, XlsArrayColumns.class, valuesMap);
//
//        annotation = TestCaseRecord.class.getAnnotation(XlsArrayColumns.class);
//        System.out.println("TestClass annotation after:" + annotation);

        // hack annotation
/*        AnnotationMappingInfo xmlInfo = createXml()
                .classInfo(createClass(TestCaseRecord.class)
                        .field(createField("testValues")
                                .annotation(createAnnotation(XlsArrayColumns.class)
                                        .attribute("size", 6)
                                        .buildAnnotation())
                                .buildField())
                        .buildClass())
                .buildXml();
        config.setAnnotationMapping(xmlInfo);*/
    }

    @XlsPostLoad
    public void onPostLoad(TestCaseRecord targetObj, Sheet sheet, Configuration config, SheetBindingErrors errors) {
        // 読み込み後に実行される処理
        // 入力値チェックなどを行う
        String a = "aaa";
/*        XlsArrayColumns annotation = TestCaseRecord.class.getAnnotation(XlsArrayColumns.class);

        annotation = TestCaseRecord.class.getAnnotation(XlsArrayColumns.class);
        System.out.println("TestClass annotation after:" + annotation);
        AnnotationMappingInfo xmlInfo = createXml()
                .classInfo(createClass(TestCaseRecord.class)
                        .field(createField("testValues")
                                .annotation(createAnnotation(XlsArrayColumns.class)
                                        .attribute("size", 6)
                                        .buildAnnotation())
                                .buildField())
                        .buildClass())
                .buildXml();
        config.setAnnotationMapping(xmlInfo);*/
    }
}
