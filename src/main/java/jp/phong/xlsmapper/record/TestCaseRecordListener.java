package jp.phong.xlsmapper.record;

import com.gh.mygreen.xlsmapper.Configuration;
import com.gh.mygreen.xlsmapper.annotation.XlsPostLoad;
import com.gh.mygreen.xlsmapper.annotation.XlsPreLoad;
import com.gh.mygreen.xlsmapper.validation.SheetBindingErrors;
import org.apache.poi.ss.usermodel.Sheet;

public class TestCaseRecordListener {

    @XlsPreLoad
    public void onPreLoad(TestCaseRecord targetObj, Sheet sheet, Configuration config, SheetBindingErrors errors) {
        String b = "";
    }

    @XlsPostLoad
    public void onPostLoad(TestCaseRecord targetObj, Sheet sheet, Configuration config, SheetBindingErrors errors) {
        // 読み込み後に実行される処理
        // 入力値チェックなどを行う
        String a = "aaa";

    }
}
