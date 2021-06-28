import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void transformStringTest() {
        String str = "астра был ветер село сарай арбуз вал балет сон он аавар ас";

        Map<String, List<String>> result = Main.transformString(str);
        List<String> listLetterA = result.get("а");
        List<String> listLetterB = result.get("б");
        List<String> listLetterV = result.get("в");
        List<String> listLetterS = result.get("с");

        assertThat(listLetterA.size()).as("Не все слова на букву А найдены").isEqualTo(4);
        assertThat(listLetterB.size()).as("Не все слова на букву Б найдены").isEqualTo(2);
        assertThat(listLetterV.size()).as("Не все слова на букву В найдены").isEqualTo(2);
        assertThat(listLetterS.size()).as("Не все слова на букву С найдены").isEqualTo(3);
        assertThat(listLetterA.get(0)).as("Сортировка по А выполнена не верно").isEqualTo("аавар");
        assertThat(listLetterA.get(1)).as("Сортировка по А выполнена не верно").isEqualTo("арбуз");
        assertThat(listLetterA.get(2)).as("Сортировка по А выполнена не верно").isEqualTo("астра");
        assertThat(listLetterA.get(3)).as("Сортировка по А выполнена не верно").isEqualTo("ас");
        assertThat(listLetterB.get(0)).as("Сортировка по Б выполнена не верно").isEqualTo("балет");
        assertThat(listLetterB.get(1)).as("Сортировка по Б выполнена не верно").isEqualTo("был");
        assertThat(listLetterV.get(0)).as("Сортировка по В выполнена не верно").isEqualTo("ветер");
        assertThat(listLetterV.get(1)).as("Сортировка по В выполнена не верно").isEqualTo("вал");
        assertThat(listLetterS.get(0)).as("Сортировка по C выполнена не верно").isEqualTo("сарай");
        assertThat(listLetterS.get(1)).as("Сортировка по C выполнена не верно").isEqualTo("село");
        assertThat(listLetterS.get(2)).as("Сортировка по C выполнена не верно").isEqualTo("сон");
    }
}