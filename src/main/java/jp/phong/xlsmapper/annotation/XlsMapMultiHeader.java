package jp.phong.xlsmapper.annotation;

import com.gh.mygreen.xlsmapper.annotation.XlsFieldProcessor;
import com.gh.mygreen.xlsmapper.fieldprocessor.CellNotFoundException;
import com.gh.mygreen.xlsmapper.fieldprocessor.ProcessCase;
import jp.phong.xlsmapper.fieldprocessor.impl.MultiHeaderProcessor;

import java.lang.annotation.*;

// 独自のマッピング用のアノテーションの作成
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@XlsFieldProcessor(MultiHeaderProcessor.class)  // 対応するFieldProcessorの指定
public @interface XlsMapMultiHeader {
    /**
     * この属性で指定した次のカラム以降、カラム名をキーとしたMapが生成され、Beanにセットされます。
     * <p>セルが見つからない場合はエラーとなりますが、属性{@link #optional()}を'true'とすることで無視して処理を続行します。</p>
     * <p>システム設定により、正規表現による指定や正規化（改行、空白、タブの削除）による比較の対象となります。</p>
     */
    String previousColumnName();

    /**
     * この属性で指定した前のカラムまでが処理対象となり、マッピングの終了条件を指定することができます。
     * <p>セルが見つからない場合はエラーとなりますが、属性{@link #optional()}を'true'とすることで無視して処理を続行します。</p>
     * <p>システム設定により、正規表現による指定や正規化（改行、空白、タブの削除）による比較の対象となります。</p>
     *
     * <pre class="highlight"><code class="java">
     * public class SampleRecord {
     *
     *     {@literal @XlsColumn(columnName="ID")}
     *     private int id;
     *
     *     {@literal @XlsColumn(columnName="名前")}
     *     private String name;
     *
     *     {@literal @XlsMapColumns(previousColumnName="名前", nextColumnName="備考")}
     *     private {@literal Map<String, String>} attendedMap;
     *
     *     {@literal @XlsColumn(columnName="備考")}
     *     private String comment;
     *
     * }
     * </code></pre>
     *
     * <div class="picture">
     *    <img src="doc-files/MapColumns_nextColumnName.png" alt="">
     *    <p>マッピングの終了条件の指定</p>
     * </div>
     *
     * @since 1.2
     */
    String nextColumnName() default "";

    /**
     * マップの値のクラスを指定します。
     * <p>省略した場合、定義されたたGenericsの情報から取得します。
     */
    Class<?> valueClass() default Object.class;

    /**
     * レコードのマッピング先のクラスを指定します。
     * <p>省略した場合、定義されたGenericsタイプから取得します。</p>
     */
    Class<?> recordClass() default Object.class;

    /**
     *
     * @return
     */
    String groupColumnAddress() default "B3";

    /**
     * 属性{@link #previousColumnName()}、{@link #nextColumnName()}で指定したカラム（セル）が見つからない場合、trueと設定すると無視して処理を続行します。
     * <p>falseを指定し、セルが見つからない場合は、例外{@link CellNotFoundException}がスローされます。</p>
     * @since 2.0
     * @return trueの場合、該当するカラム（セル）が見つからないときは無視して処理を続行します。
     */
    boolean optional() default false;

    /**
     * 適用するケースを指定します。
     * @since 2.0
     * @return 何も指定しない場合は全てのケースに適用されます。
     */
    ProcessCase[] cases() default {};
}
