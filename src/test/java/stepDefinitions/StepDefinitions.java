package stepDefinitions;

import com.zsidek.Item;
import com.zsidek.Market;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class StepDefinitions {

    Market market = new Market();

    @Given("I have the following items in the first list:")
    public void iHaveTheFollowingItemsInTheFirstList(DataTable table) {


        List<List<String>> rows = table.asLists(String.class);

        rows.stream()
                .filter(row -> row.get(1).matches("[0-9]\\S+"))
                .forEach(row -> market.addItemToFirstList(new Item(row.get(0), row.get(1), row.get(2))));

/*        for (List<String> columns : rows) {
            market.addItem(new Item(columns.get(0), columns.get(1), columns.get(2)));
        */

        System.out.println(market);
    }

    @And("I have the following items in the second list:")
    public void iHaveTheFollowingItemsInTheSecondList(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        rows.stream()
                .filter(row -> row.get(1).matches("[0-9]\\S+"))
                .forEach(row -> market.addItemToSecondList(new Item(row.get(0), row.get(1), row.get(2))));

    }

    @When("I compare both lists")
    public void iCompareBothLists() {
        System.out.println("when");
    }


    @Then("the lists should contain the same items with name, price, and category, regardless of order")
    public void theListsShouldContainTheSameItemsWithNamePriceAndCategoryRegardlessOfOrder() {

    }
}
