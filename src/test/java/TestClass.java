import org.junit.Test;

public class TestClass extends Base {

    @Test
    public void shouldCorrectlyAddClothesToCart() {
        //given
        TestClassSecondLine tl = new TestClassSecondLine();
        //when
        tl.addClothesToCart(driver);
        //then
        tl.checkAmountOfClothesAtCart(driver);
    }
}
