import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;

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
}