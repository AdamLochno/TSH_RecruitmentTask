import org.junit.Test;

public class TestClass extends Base {

    @Test
    public void shouldCorrectlyAddClothesToCart() {
        //given
        TestClassSecondLine tl = new TestClassSecondLine();
        //when
        tl.zbiorczeZadanie(driver);
        //then
        tl.asercja(driver);
    }
}
