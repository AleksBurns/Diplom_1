import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTests {
    private final String name;
    private final float price;

    public BunTests(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Название булочки: {0} Цена: {1}")
    public static Object[][] GetNameAndPrice(){
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }

    @Test
    public void checkBunName(){
        Bun bun = new Bun(name,price);
        Assert.assertEquals("Неверное название булочки", bun.getName(), name);
    }

    @Test
    public void checkBunPrice(){
        Bun bun = new Bun(name,price);
        Assert.assertEquals("Неверная цена булочки", price, bun.getPrice(), 0);
    }

}