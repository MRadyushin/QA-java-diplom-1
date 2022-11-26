import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

import praktikum.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private IngredientType ingredientType;
    private final String name;
    public IngredientTypeTest(String name){
        this.name=name;
    }
    @Parameterized.Parameters(name = "Тип Ингридиента: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void ingredientTypeReturnCorrectValuesTest() {
        boolean available = true;
        try {
            ingredientType.valueOf(name);
        } catch (IllegalArgumentException DRINK) {
            available = false;
        }
        assertTrue(available);
    }

}