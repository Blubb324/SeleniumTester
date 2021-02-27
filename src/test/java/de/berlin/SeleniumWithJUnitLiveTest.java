package de.berlin;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SeleniumWithJUnitLiveTest {

    private static SeleniumExample seleniumExample;
    private String expectedTitle = "About Baeldung | Baeldung";

    @BeforeClass
    public static void setUp() {
        seleniumExample = new SeleniumExample();
    }
    
    @AfterClass
    public static void tearDown() {
        seleniumExample.closeWindow();
    }
    
    @Test
    public void whenAboutBaeldungIsLoaded_thenAboutEugenIsMentionedOnPage() {
        seleniumExample.getAboutBaeldungPage();
        String actualTitle = seleniumExample.getTitle();
     
        Assert.assertNotNull(actualTitle);
        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertTrue(seleniumExample.isAuthorInformationAvailable());
    }
}