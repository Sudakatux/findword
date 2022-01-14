import org.junit.jupiter.api.Test;
import somepackage.Client;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientTest {
    @Test
    public void shouldPrintEverySingleWord(){
        final String samplePrefix = "aas";
        Client c = new Client();
        c.readFile();
        Set<String> words = c.wordsForPrefix(samplePrefix);
        words.forEach(a-> System.out.println(a));
        assertAll(()->{
            assertTrue(words.containsAll(Arrays.asList("aas","aasvogel","aasvogels")));
            assertTrue(words.size() == 3);
        });

    }

}
