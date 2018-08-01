import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.String;

public class Text {
    public static void main(String[] args) throws IOException {
        //Объявление списка
        List<String> text = new ArrayList<>();
        //Чтение файла
        for (String line : Files.readAllLines(Paths.get("words.txt"))) {
            for (String part : line.split("\\s+")) {
                String i = String.valueOf(part);
                text.add(i);
            }
        }
        //Вывод текста из файла
        System.out.println("Вывод текста из файла: " + text);
//Сортировка списка по алфавиту
        Collections.sort(text);
        System.out.println("Сортировка по алфавиту: " + text + "\n");

        System.out.println("Количество повторений: ");

        //Вывод слов и их количества повторений
        Set<String> uniqueWords = new HashSet<String>(text);
        for (String word : uniqueWords) {
            System.out.println(word + ": " + Collections.frequency(text, word));
        }
        //Хэширование списка
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        for (int i = 0; i < text.size(); i++) {
            if (h.containsKey(text.get(i))) {
                h.replace(text.get(i), h.get(text.get(i)) + 1);
            } else {
                h.put(text.get(i), 1);
            }
        }
        //Поиск слова, которое повторяется большее количество раз
        String s = null;
        int p = 0;
        for (String w : h.keySet()) {
            if (p < h.get(w)) {
                p = h.get(w);
                s = w;
            }
        }
        System.out.println("Самое повторяющееся слово: " + s + " (встречается " + h.get(s) + " раз)");
    }
}