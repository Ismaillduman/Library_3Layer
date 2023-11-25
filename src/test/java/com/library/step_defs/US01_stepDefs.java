package com.library.step_defs;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US01_stepDefs {
    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        System.out.println("...Connected...");
    }
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
       DB_Util.runQuery("select count(distinct id) AS UNIQIDCount from users");
    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
