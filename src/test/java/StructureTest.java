import org.junit.jupiter.api.Test;
import somepackage.MyDataStructure;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StructureTest {
    @Test
    public void shouldBeAbleToPutAWordInTheStructure(){
        MyDataStructure testStructure = new MyDataStructure();
        String someWord = "word";
        testStructure.putWord("word");
        assertAll(()->{
           assertTrue(testStructure.getWordsForPrefix(someWord).contains(someWord));
        });
    }
    @Test
    public void shouldBeAbleToReturnWordsWithSamePrefix(){
        MyDataStructure structure = new MyDataStructure();
        String someWord = "word";
        String someWorda = "worda";
        structure.putWord(someWord);
        structure.putWord(someWorda);
        assertAll(()->{
            assertTrue(structure.getWordsForPrefix(someWord).contains(someWord));
            assertTrue(structure.getWordsForPrefix(someWord).contains(someWorda));
        });
    }
}
