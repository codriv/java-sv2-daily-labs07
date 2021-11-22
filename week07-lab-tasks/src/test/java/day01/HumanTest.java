package day01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanTest {

    @Test
    void HumanConstructorTest() {
        Human human = new Human("Nagy Sándor", 1990);
    }
    @Test
    void HumanConstructorWithWrongNameTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Human("Nagy", 1995));
        System.out.println(exception.getMessage());
    }
    @Test
    void HumanConstructorWithWrongYearTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Human("Nagy Sándor", 1900));
        System.out.println(exception.getMessage());
    }
}
