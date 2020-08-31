package junitwyklad;

import gherkin.lexer.Ca;
import org.junit.*;
import tdd.tdd.Calculator;

import static org.junit.Assert.*;

public class JunitTest {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("@BeforeClass - setUpClass()");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("@AfterClass - tearDownClass()");
    }

    @Before
    public void setUp() {
        System.out.println("@Before - setUp()");
    }

    @After
    public void tearDown() {
        System.out.println("@After - tearDown()");
    }

    @Test
    public void testOne() {
        System.out.println("@Test - testOne()");
        System.out.println("@Test - testOne()");
        System.out.println("@Test - testOne()");
        System.out.println("@Test - testOne()");
        fail();
    }

    @Test
    public void testTwo() {
        System.out.println("@Test - testTwo()");
    }

    @Ignore("Do poprawienia pozniej.")
    @Test
    public void ingoreTest() {
        System.out.println("@Ignore - ignoreTest()");
    }

    @Test(expected = NullPointerException.class)
    public void expectedException() {
//        try {
//            //WebElement element = driver.findElementBy()
//        } catch (NoSuchElementException e)
//        {
//            Assert.assertTrue(true);
//            return;
//        }
//        Assert.fail();
        throw new NullPointerException();
    }

    @Test
    public void dokladnosc() {
        //Assert.assertEquals(3.333, 10.0/3.0, 0.001);
        Calculator calculator = new Calculator();
        Calculator calculator2 = new Calculator();
        Assert.assertNotNull(calculator);
        Assert.assertNotSame(calculator, calculator2);
    }
}
