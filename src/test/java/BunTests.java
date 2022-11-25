import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class BunTests {

    private Bun bun;
    private String name;
    private float price;
    public BunTests(String name, float price){
        this.name=name;
        this.price=price;
    }
    @Parameterized.Parameters(name = "Название булочки: {0}/ Цена булочки: {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Чёрная", 100},
                {"Красная", 300},
                {"Жёлтая", 100.5f},
                {"Белая", 10.55f}
        };
    }

    @Before
    public void setUp(){
        this.bun = new Bun(name, price);
    }
    @Test
    public void getNameReturnCorrectValue(){
        String actualName = bun.getName();
        assertEquals("Название булочки не корректно", actualName, name);
    }

    @Test
    public void getPriceReturnCorrectValue(){
        float actualPrice = bun.getPrice();
        assertEquals("Цена буллочки не корректна", actualPrice, price,0);
    }
}