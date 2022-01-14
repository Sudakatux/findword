package somepackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Stream;

public class Client {
    MyDataStructure treeLike = new MyDataStructure();
    public void readFile() {
        String fileName="/home/jimmy/words_alpha.txt";
        try(Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach((word)->{
               treeLike.putWord(word);
            });
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public Set<String> wordsForPrefix(String prefix){
        return treeLike.getWordsForPrefix(prefix);
    }
}
