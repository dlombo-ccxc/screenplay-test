package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import starter.builder.Login;
import starter.exceptions.EnvironmentError;
import starter.facts.AToken;
import starter.questions.dashboard.OverviewData;
import starter.ui.dashboard.DashboardPage;
import starter.navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginStepDefinitions {

    String actor;
    String name;
    @Given("^(.*) has an active account")
    public void has_an_active_account(String actor) {
        this.actor = actor;
    }

    @Given("^(.*) has a token")
    public void has_a_token(String name){
        this.name = name;
        theActorCalled(name)
                .has(AToken.toManageTheirProducts());
    }

    @Given("^(.*) failed1")
    public void pepito_failed1(String name) {
        theActorCalled(name).should(
                seeThat("failed 1", actor -> true, equalTo(false))
        );
    }

    @Given("^(.*) failed2")
    public void pepito_failed2(String name) {
        theActorCalled(name).should(
                seeThat("failed 2", actor -> true, equalTo(false))
        );
    }
    @Given("^(.*) compromised")
    public void pepito_compromised(String name) {
       theActorCalled(name).should(
               seeThat("", act -> true, equalTo(false))
                       .orComplainWith(EnvironmentError.class, "No se tiene conexion con el third party ")
       );
    }

    @When("she sends their valid credentials")
    public void she_sends_their_valid_credentials() {
        theActorCalled(actor).attemptsTo(
                NavigateTo.theLoginHomePage(),
                Login
                        .with()
                        .username("daniela")
                        .and()
                        .password("password")
                        .rememberMe(true)
        );
    }
    @Then("she should have access to manage his account")
    public void she_should_have_access_to_manage_his_account() {
        theActorInTheSpotlight().should(
                seeThat("The diplayed Credit Available", OverviewData.creditAvailable(), equalTo("$17,800")),
                seeThat("The diplayed Total Balance", OverviewData.totalBalance(), equalTo("$350"))
        );
        theActorInTheSpotlight().attemptsTo(
                Click.on(DashboardPage.LEFT_MENU.CREDIT_CARD_LINK)
        );
    }

}
