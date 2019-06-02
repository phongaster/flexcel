package jp.phong.poi.excel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import jp.phong.poi.excel.model.ScreenDefinition;
import jp.phong.poi.excel.model.TestCase;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class TestApplication {
    public static void main(String[] args) throws InvalidFormatException {
        try {
            Workbook workbook = ExcelReader.readExcel(String.valueOf(Paths.get(ClassLoader.getSystemResource("ComplicatedWorkbook.xlsx").toURI())));
            Sheet sheet = workbook.getSheetAt(0);
            Map<String, List<ExcelValueConfig[]>> excelRowValuesMap = ExcelReader.getExcelRowValues(sheet);
            excelRowValuesMap.forEach((section, rows) -> {
                 System.out.println(section);
                 System.out.println("==============");
                boolean headerPrint = true;
                for (ExcelValueConfig[] evc : rows) {
                    if (headerPrint) {
                        for (int j = 0; j < evc.length; j++) {
                             System.out.print(evc[j].getExcelHeader() + "t");
                        }
                         System.out.println();
                         System.out.println(
                         "------------------------------------------------------------------------------------");
                         System.out.println();
                        headerPrint = false;
                    }
                    for (int j = 0; j < evc.length; j++) {
                         System.out.print(evc[j].getExcelValue() + "t");
                    }
                     System.out.println();
                }
                 System.out.println();
            });
            List<ScreenDefinition> screenDefinitions = ExcelPojoMapper.getPojos(excelRowValuesMap.get(ExcelSectionEnum.SCREEN_DEFINITION.getValue()),
                    ScreenDefinition.class);
            List<TestCase> testCases = ExcelPojoMapper.getPojos(excelRowValuesMap.get(ExcelSectionEnum.TEST_CASE.getValue()),
                    TestCase.class);
            screenDefinitions.forEach(o -> {
                System.out.println(o.getScreenName());
                System.out.println(o.getAreaName());
                System.out.println(o.getGroupName());
                System.out.println(o.getItemName());
                System.out.println(o.getItemType());
            });
            testCases.forEach(p -> {
                System.out.println(p.getClass());
                System.out.println(p.getClass());
            });
        } catch (EncryptedDocumentException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}