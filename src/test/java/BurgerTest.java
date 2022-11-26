import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import praktikum.*;

import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsReturnCorrectValueTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientAddValueToListCorrectTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientRemoveIngridientFromListCorrectTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientMoveIngredientToLIstTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceCountPriceCorrectTest() {
        Burger burger = new Burger();
        when(bun.getPrice()).thenReturn(3.8f);
        when(ingredient.getPrice()).thenReturn(2.4f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        assertEquals(0, Float.compare(10, actual));
    }

    @Test
    public void getReceiptReturnCorrectValueTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200f);
        when(bun.getName()).thenReturn("white bun");
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String expected = "(==== white bun ====)\r\n" +
                "= filling dinosaur =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 200,000000\r\n";
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }
}