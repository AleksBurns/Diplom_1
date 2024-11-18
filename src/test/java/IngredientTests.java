import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTests {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип: {0} Название: {1} Цена: {2}")
    public static Object [][] setIngredient(){
        return new Object[][]{
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
        };
    }

    @Test
    public void checkIngredientType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Неверный тип ингредиента", type, ingredient.getType());
    }

    @Test
    public void checkIngredientName(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Неверное название ингредиента", name, ingredient.getName());
    }

    @Test
    public void checkIngredientPrice(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Неверная цена ингредиента", price, ingredient.getPrice(), 0);
    }
}