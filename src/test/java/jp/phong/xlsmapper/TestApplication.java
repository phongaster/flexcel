package jp.phong.xlsmapper;

import com.gh.mygreen.xlsmapper.Configuration;
import com.gh.mygreen.xlsmapper.XlsMapper;
import jp.phong.xlsmapper.annotation.XlsMapMultiHeader;
import jp.phong.xlsmapper.fieldprocessor.impl.MultiHeaderProcessor;
import jp.phong.xlsmapper.sheet.TestCaseSheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class TestApplication {

    public static void main(String[] args) throws IOException {
        // 独自のFieldProcessorの登録
        Configuration config = new Configuration();
        config.getFieldProcessorRegistry().registerProcessor(XlsMapMultiHeader.class, new MultiHeaderProcessor());

        XlsMapper xlsMapper = new XlsMapper();
        xlsMapper.setConiguration(config);

        TestCaseSheet sheet = xlsMapper.load(
                new FileInputStream(Paths.get("src", "test", "resources", "ComplicatedWorkbook.xlsx").toString()), // 読み込むExcelファイル。
                TestCaseSheet.class                      // シートマッピング用のPOJOクラス。
        );///Users/phong/Projects/flexcel/src/test/resources/ComplicatedWorkbook.xlsx
        // print all

    }
}
