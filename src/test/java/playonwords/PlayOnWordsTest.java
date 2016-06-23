package playonwords;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlayOnWordsTest {
    
    @DataProvider(name="inputExpectedOutput")
    public Object[][] getInputExpectedResultMap() {
        return new Object[][]{
            {Arrays.asList("abc", "cde"), true},
            {Arrays.asList("abc", "def"), false},
            {Arrays.asList("aba"), true},
            {Arrays.asList("abc"), false},
            {Arrays.asList("acm", "mouse", "malform"), true},
            {Arrays.asList("acm", "mouse", "malform", "elme", "eleme", "mese", "elm"), true},
            {Arrays.asList("acm", "moma", "acm"), true},
        };
    }
    
    @Test(dataProvider="inputExpectedOutput")
    public void isOrderingPossibleShouldReturnExpectedValues( List<String> input, boolean expected ) {
        PlayOnWords playOnWords = new PlayOnWords(input);
        boolean actual = playOnWords.isOrderingPossible();
        assertEquals(actual, expected);
    }
    
}
