package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.util.EnvironmentVariables;
import starter.abilities.ReadPdf;
import starter.navigation.NavigateTo;

import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class DownloadStatementsStepDefinitions {

    String name;
    private EnvironmentVariables enviromentVariables;

    String downloadFolder;
    String fileName;

    @Given("^(.*) has made purchases with his credit card")
    public void pepito_has_made_purchases_with_his_credit_card(String name) throws InterruptedException {
        this.name = name;

        downloadFolder = enviromentVariables.optionalProperty("download.fileFolder").orElseThrow(IllegalArgumentException::new);
        fileName = enviromentVariables.optionalProperty("statements.fileName").orElseThrow(IllegalArgumentException::new);
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Given("he already downloaded his statements")
    public void he_already_downloaded_his_statements() throws InterruptedException {
        theActorCalled(name);

        withCurrentActor(
                NavigateTo.theDuckDuckGoHomePage()
        );

        Thread.sleep(5000);
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("he reviews his transactions")
    public void he_reviews_his_transactions() throws IOException {
        String statementFilePath = String.format("%s\\%s", downloadFolder, fileName);
        theActorInTheSpotlight().whoCan(ReadPdf.downloadedInPath(statementFilePath));
        String pdfText = ReadPdf.as(theActorInTheSpotlight()).getText();

        System.out.println(pdfText);
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("he should see the transactions for last month")
    public void he_should_see_the_transactions_for_last_month() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

}
