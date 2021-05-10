package tests.test;

import dataProvider.Users;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.base.BaseTest;

public class AddProduct extends BaseTest {

    private final Users zlogin = new Users(Users.UserRole.TESTER1);

    @Test
    public void logIn() {
        start()
                .openLoginPage()
                .loginAs(zlogin);
    }


}
