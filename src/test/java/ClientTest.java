import org.junit.jupiter.api.Test;
import somepackage.Client;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientTest {
    @Test
    public void shouldPrintEverySingleWord(){
        final String samplePrefix = "tab";
        Client c = new Client();
        c.readFile();
        Set<String> words = c.wordsForPrefix(samplePrefix);
        words.forEach(a-> System.out.println(a));
        assertAll(()->{
            assertTrue(words.containsAll(Arrays.asList("aas","aasvogel","aasvogels")));
            assertTrue(words.size() == 3);
        });
    }

    @Test
    public void someTest(){
        Client c = new Client();
        c.readFile();
        Arrays.asList("tab","wor","rand","matesdasdasdasdasd")
                 .forEach(word->{
                     System.out.println("WORD IS : "+word+"\n");
                     c.wordsForPrefix(word).forEach(System.out::println);
                 });
    }

}
