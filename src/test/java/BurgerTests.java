import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    Burger burger = new Burger();
    public String bunName = "red bun";
    public float bunPrice = 300F;
    public String ingredientName = "cutlet";
    public float ingredientPrice = 100F;
    public String receiptExpected =
            "(==== "+ bunName +" ====)\n" +
            "= filling "+ ingredientName +" =\n" +
            "(==== "+ bunName +" ====)\n" +
                    "\n" +
            "Price: 700,000000\n";

    @Mock
    Bun bun;

    @Test
    public void checkSetBuns() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Assert.assertEquals (bun.getName(), burger.bun.getName());
    }

    @Mock
    Ingredient ingredient;

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Mock
    Ingredient anotherIngredient;

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        burger.moveIngredient(1,0);
        Assert.assertEquals(anotherIngredient, burger.ingredients.get(0));
    }

    @Test
    public void checkGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Assert.assertEquals(700F, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        Assert.assertEquals(receiptExpected, burger.getReceipt());
    }
}