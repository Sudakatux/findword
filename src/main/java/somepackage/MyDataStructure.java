package somepackage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyDataStructure {
    private final Map root = new HashMap<>();
    private Set<String> words = new HashSet<>();

    public MyDataStructure put(String key,String word) {
        Object nested = root.get(key);

        if (nested == null || !(nested instanceof MyDataStructure)) {
            nested = new MyDataStructure();
            ((MyDataStructure) nested).addToWords(word);
            root.put(key, nested);
        }
        MyDataStructure existing = (MyDataStructure) nested;
        existing.addToWords(word);
        return existing;
    }

    private void addToWords(String word) {
        this.words.add(word);
    }

    public MyDataStructure get(String key) {
        return (MyDataStructure) root.get(key);
    }

    public void putWord(String word) {
        MyDataStructure instance = this;
        String[] charecters = word.split("");
        for (int i =0;i<charecters.length;i++) {
            String currentCharecter = (charecters[i]);
            instance = instance.put(currentCharecter,word);
        }
    }


    public Set<String> getWordsForPrefix(String prefix){
        MyDataStructure instance = this;
        String[] charecters = prefix.split("");
        for (int i =0;i < charecters.length ;i++) {
            String currentCharecter = (charecters[i]);
            instance = instance.get(currentCharecter);
            if(instance == null){
                return Set.of();
            }
        }
        return instance.words;
    }
}
