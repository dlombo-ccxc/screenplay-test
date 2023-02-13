package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import starter.conf.SessionVariables;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefinitions2 {
    @Then("she should get Foo")
    public void she_should_get_foo() {
        String valueRecall = theActorInTheSpotlight().recall(SessionVariables.FOO.toString());
    }
}
