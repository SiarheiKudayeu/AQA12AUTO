package lesson3.grouping;

import org.testng.annotations.Test;

public class GroupTestOneTest {

    @Test(groups = {"smoke"})
    public void a() {

    }

    @Test
    public void b() {

    }

    @Test(groups = {"smoke"})
    public void c() {

    }

    @Test(groups = {"regression"})
    public void d() {

    }

    @Test(groups = {"smoke"})
    public void e() {

    }

    @Test(groups = {"regression"})
    public void f() {

    }

    @Test(groups = {"regression", "smoke"})
    public void g() {

    }
}
