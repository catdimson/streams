import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;




public class Main {


    public static void main(String[] args) {

    }

    public static Map<String, List<String>> transformString(String str) {
        /*String ss=null, s2;

        Optional<String> t = Optional.ofNullable(ss);

        s2 = t.orElse("65465lknk");
        Predicate<String> p = x -> x.length()>2;
        t.filter(p)
                .map(x -> Integer.valueOf(x))
                .orElse(654654);

        Stream<String>  ss1 = Stream.of("15", "ufufyu", "iyguiygf")
                .filter(p)
                .map(x -> x.length())
                .map(x -> x.toString());
        Stream<String> ss2 = Stream.of("88888");

        Stream.of(ss1, ss2)
                .flatMap(x->x)
                .map(x-> x.length());

         Stream.of(List.of("kijughigh", "hijui"), List.of("ttrxtx"))
                 .map(List::stream)
                 .flatMap(x->x)
                 .collect(Collectors.toList());

        Optional.of(t)
                .flatMap(x-> x)
                .orElse("1234");*/



        /*---------- Задачка ---------*/

        /*Есть строка, состоящая из слов.
        Все слова в ней разделены одним пробелом.
        Нужно преобразовать строку в такую структуру данных,
        которая группирует слова по первой букве в слове. Затем вывести только группы, содержащие более одного элемента.

        Группы должны быть отсортированы в алфавитном порядке. Слова внутри группы нужно сортировать по убыванию количества символов;
        если количество символов равное, то сортировать в алфавитном порядке.

        Пример строки: String s = «сапог сарай арбуз болт бокс биржа»

        Отсортированная строка: [б=[биржа, бокс, болт], c=[caпог, сарай]]*/

        List<String> words = Arrays.asList(str.split(" "));

        Map<String, List<String>> mapWords = words.stream()
                .collect(groupingBy(s -> s.substring(0,1)));

        Stream<Map.Entry<String, List<String>>> myStream = mapWords.entrySet().stream()
                .filter(x -> x.getValue().size() > 1)
                .peek(x -> {
                    List<String> localWords = x.getValue();
                    localWords.sort(lexicalComparator);
                    x.setValue(localWords);
                })
                .sorted(Map.Entry.comparingByKey());

        mapWords = myStream.collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        System.out.println(mapWords);
        return mapWords;
    }

    public static Comparator<String> lexicalComparator = (s1, s2) -> {
        int res = 0;
        if (s1.length() < s2.length()) {
            res = 1;
        } else if (s1.length() > s2.length()) {
            res = -1;
        } else {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) < s2.charAt(i)) {
                    res = 1;
                } else {
                    res = -1;
                }
            }
        }
        return res;
    };
}
