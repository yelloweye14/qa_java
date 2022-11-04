import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatClassMockTest {

    @Mock
    Feline feline;

    @Test
    public void catGetSoundTest() {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        Assert.assertEquals("Мяу", actual);
    }

    @Test
    public void catGetFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птица", "Рыба"));
        List<String> actual = cat.getFood();
        Assert.assertEquals(List.of("Животные", "Птица", "Рыба"), actual);
    }
}