package jp.phong.poi.excel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExcelPojoMapper {

    final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static <T> List<T> getPojos(List<ExcelValueConfig[]> excelValueConfigs, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        excelValueConfigs.forEach(evc -> {
            T t = null;
            try {
                t = clazz.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
                e1.printStackTrace();
            }
            Class<? extends Object> classz = t.getClass();
            for (int i = 0; i < evc.length; i++) {
                for (Field field : classz.getDeclaredFields()) {
                    field.setAccessible(true);
                    if (evc[i].getPojoAttribute().equalsIgnoreCase(field.getName())) {
                        try {
                            if (DataTypeEnum.STRING.getValue().equalsIgnoreCase(evc[i].getExcelColType())) {
                                field.set(t, evc[i].getExcelValue());
                            } else if (DataTypeEnum.DOUBLE.getValue().equalsIgnoreCase(evc[i].getExcelColType())) {
                                field.set(t, Double.valueOf(evc[i].getExcelValue()));
                            } else if (DataTypeEnum.INTEGER.getValue().equalsIgnoreCase(evc[i].getExcelColType())) {
                                field.set(t, Double.valueOf(evc[i].getExcelValue()).intValue());
                            } else if (DataTypeEnum.DATE.getValue().equalsIgnoreCase(evc[i].getExcelColType())) {
                                field.set(t, LocalDate.parse(evc[i].getExcelValue(), dtf));
                            }
                        } catch (IllegalArgumentException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
            list.add(t);
        });
        return list;
    }
}
