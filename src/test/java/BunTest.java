import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class BunTest {

    private Bun bun;
    private String name;
    private float price;
    public BunTest(String name, float price){
        this.name=name;
        this.price=price;
    }
    @Parameterized.Parameters(name = "Название булочки: {0}/ Цена булочки: {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Чёрная", 100f},
                {"Красная", 300f},
                {"Жёлтая", 100.5f},
                {"Белая", 10.55f}
        };
    }

    @Before
    public void setUp(){
        this.bun = new Bun(name, price);
    }
    @Test
    public void getNameReturnCorrectValueTest(){
        String actualName = bun.getName();
        assertEquals("Название булочки не корректно", actualName, name);
    }

    @Test
    public void getPriceReturnCorrectValueTest(){
        float actualPrice = bun.getPrice();
        assertEquals("Цена буллочки не корректна", actualPrice, price,0);
    }
}