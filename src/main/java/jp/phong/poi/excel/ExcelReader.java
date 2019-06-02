package jp.phong.poi.excel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class ExcelReader {

    final static SimpleDateFormat dtf = new SimpleDateFormat("dd-MM-yyyy");

    private ExcelReader() {
    }

    public static Workbook readExcel(final String fullFilePath)
            throws EncryptedDocumentException, IOException {
        Workbook wb = null;
        wb = WorkbookFactory.create(new File(fullFilePath));
        return wb;
    }

    public static Map<String, List<ExcelValueConfig[]>> getExcelRowValues(final Sheet sheet) {
        Map<String, List<ExcelValueConfig[]>> excelMap = new HashMap<>();
        Map<String, ExcelValueConfig[]> excelSectionHeaders = getExcelHeaderSections();
        int totalRows = sheet.getLastRowNum();
        excelSectionHeaders.forEach((section, excelValueConfigs) -> {
            List<ExcelValueConfig[]> excelValueConfigList = new ArrayList<>();
            for (int i = 2; i <= totalRows; i++) {
                Row row = sheet.getRow(i);
                ExcelValueConfig[] excelValueConfigArr = new ExcelValueConfig[excelValueConfigs.length];
                int k = 0;
                for (ExcelValueConfig ehc : excelValueConfigs) {
                    int cellIndex = ehc.getExcelIndex();
                    String cellType = ehc.getExcelColType();
                    Cell cell = row.getCell(cellIndex);
                    ExcelValueConfig config = new ExcelValueConfig();
                    config.setExcelColType(ehc.getExcelColType());
                    config.setExcelHeader(ehc.getExcelHeader());
                    config.setExcelIndex(ehc.getExcelIndex());
                    config.setPojoAttribute(ehc.getPojoAttribute());
                    if (DataTypeEnum.STRING.getValue().equalsIgnoreCase(cellType)) {
                        config.setExcelValue(cell.getStringCellValue());
                    } else if (DataTypeEnum.DOUBLE.getValue().equalsIgnoreCase(cellType)
                            || DataTypeEnum.INTEGER.getValue().equalsIgnoreCase(cellType)) {
                        config.setExcelValue(String.valueOf(cell.getNumericCellValue()));
                    } else if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        config.setExcelValue(dtf.format(cell.getDateCellValue()));
                    }
                    excelValueConfigArr[k++] = config;
                }
                excelValueConfigList.add(excelValueConfigArr);
            }
            excelMap.put(section, excelValueConfigList);
        });
        return excelMap;
    }

    private static Map<String, ExcelValueConfig[]> getExcelHeaderSections() {
        List<Map<String, List<ExcelValueConfig>>> jsonConfigMap = getExcelHeaderConfigSections();
        Map<String, ExcelValueConfig[]> jsonMap = new HashMap<>();
        jsonConfigMap.forEach(jps -> {
            jps.forEach((section, values) -> {
                ExcelValueConfig[] excelValueConfigs = new ExcelValueConfig[values.size()];
                jsonMap.put(section, values.toArray(excelValueConfigs));
            });
        });
        return jsonMap;
    }

    private static List<Map<String, List<ExcelValueConfig>>> getExcelHeaderConfigSections() {
        List<Map<String, List<ExcelValueConfig>>> jsonMap = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonConfig = new String(
                    Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("ComplicatedWorkbook.config.json").toURI())));
            jsonMap = objectMapper.readValue(jsonConfig,
                    new TypeReference<List<HashMap<String, List<ExcelValueConfig>>>>() {
                    });
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return jsonMap;
    }
}
