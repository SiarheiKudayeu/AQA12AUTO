package lesson3.priority;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTest {
    @Test(priority = 1)
    public void a(){

    }

    @Test
    public void b(){

    }

    @Test
    public void f(){

    }

    @Test(dependsOnMethods = {"d"}, alwaysRun = true)
    public void c(){

    }

    @Test(priority = 2)
    public void e(){

    }

    @Test
    public void d(){
        Assert.fail();
    }
}
