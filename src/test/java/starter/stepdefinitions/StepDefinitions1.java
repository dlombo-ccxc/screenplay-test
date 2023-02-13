package starter.stepdefinitions;

import io.cucumber.java.en.When;
import starter.conf.SessionVariables;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefinitions1 {
    @When("she tries to remember (.*)")
    public void she_tries_to_remember_foo(String value) {
        theActorInTheSpotlight().remember(SessionVariables.FOO.toString(), value);
    }
}
