import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import praktikum.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsReturnCorrectValue() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientAddValueToListCorrect() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientRemoveIngridientFromListCorrect() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientMoveIngredientToLIst() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient, burger.ingredients.get(1));
    }

}