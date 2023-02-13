package starter.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CleanDatabase {
    @Before
    public static void beforeHook() {
        System.out.println("before hook");
    }
    @Before("@foo")
    public static void beforeHookFoo() {
        System.out.println("before hook for foo");
    }
    @After
    public static void afterHook() {
        System.out.println("after hook");
    }
}
