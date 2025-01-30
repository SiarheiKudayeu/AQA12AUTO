package lesson3.grouping;

import org.testng.annotations.Test;

public class GroupTestTwoTest {

    @Test(groups = {"smoke"})
    public void two_a() {

    }

    @Test
    public void two_b() {

    }

    @Test(groups = {"smoke"})
    public void two_c() {

    }

    @Test(groups = {"regression"})
    public void two_d() {

    }

    @Test(groups = {"smoke"})
    public void two_e() {

    }

    @Test(groups = {"regression"})
    public void two_f() {

    }

    @Test(groups = {"regression", "smoke"})
    public void two_g() {

    }
}
