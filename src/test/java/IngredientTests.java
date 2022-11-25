import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import praktikum.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTests {

    private final String ingredientTypeValue;
    private final String name;
    private final float price;
    private Ingredient ingredient;
    private IngredientType ingredientType;

    public IngredientTests(String ingredientTypeValue, String name, float price) {
        this.ingredientTypeValue = ingredientTypeValue;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип ингридиента: {0}/ Название ингридиента: {1}/ Цена ингридиента: {2}")
    public static Object[][] getData() {
        return new Object[][]{
                {"FILLING", "sausage", 300f},
                {"SAUCE", "sour cream", 200f},
        };
    }

    @Before
    public void setUp() {
        this.ingredient = new Ingredient(this.ingredientType.valueOf(ingredientTypeValue), name, price);
    }

    @Test
    public void getNameReturnCorrectValue() {
        String actualName = ingredient.getName();
        assertEquals("Название ингридиента некорректно", actualName, name);
    }

    @Test
    public void getPriceReturnCorrectValue() {
        float actualPrice = ingredient.getPrice();
        assertEquals("Сумма ингридиента некорректна", actualPrice, price, 0);
    }

    @Test
    public void getTypeReturnCorrectValue() {
        assertEquals(this.ingredientType.valueOf(ingredientTypeValue), this.ingredient.getType());
    }

}
