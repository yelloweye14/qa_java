import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionClassMockTest {

    @Mock
    Feline feline;

    @Test
    public void checkHasManeTrueTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean hasMane = lion.doesHaveMane();
        Assert.assertTrue(hasMane);
    }

    @Test
    public void checkHasManeFalseTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean hasMane = lion.doesHaveMane();
        Assert.assertFalse(hasMane);
    }

    @Test
    public void lionGetKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        Assert.assertEquals(1, actual);
    }

    @Test
    public void lionGetFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), actual);
    }

    @Test
    public void lionGetExceptionTest() {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Гермафродит", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}