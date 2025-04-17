package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class _09_DataTableExample {

    @When("Write username {string}")
    public void writeUsername(String username) {
        System.out.println("username = " + username);
    }

    @And("Write username and password {string} and {string}")
    public void writeUsernameAndPasswordAnd(String username, String password) {
        System.out.print("Username = " + username);
        System.out.println("  Password = " + password);
    }

    @And("Write username as DataTable")
    public void writeUsernameAsDataTable(DataTable users) {

        List<String> listUsers = users.asList(); // list

        for (int i = 0; i < listUsers.size(); i++) {
            String user = listUsers.get(i);
            System.out.println("User = " + user);
        }
    }

    @And("Write username and password as DataTable")
    public void writeUsernameAndPasswordAsDataTable(DataTable credentials) {

        List<List<String>> credentialsLists = credentials.asLists();

        for (int i = 0; i < credentialsLists.size(); i++) {
            List<String> credentialsList = credentialsLists.get(i);
            System.out.printf("User = %-10s <--> Password = %s%n", credentialsList.get(0),  // username
                    credentialsList.get(1)); // password
        }
    }
}

