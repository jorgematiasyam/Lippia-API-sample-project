package ar.steps;

import api.config.EntityConfiguration;
import api.model.Data;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import com.google.api.client.repackaged.com.google.common.base.Splitter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class UserSteps extends PageSteps {


        private Map<String, String> getParameters(String jsonReplacementValues) {
        Map<String, String> parameters = null;
        if (!StringUtils.isEmpty(jsonReplacementValues)) {
            parameters = Splitter.on(",").withKeyValueSeparator(":").split(jsonReplacementValues);
        }
        return parameters;
    }

    @Then("^I will get the proper status code '(.*)'$")
    public void iWillGetTheProperStatusCodeStatusCode(String expStatusCode) {
        int actualStatusCode = APIManager.getLastResponse().getStatusCode();
        Assert.assertEquals(Integer.parseInt(expStatusCode), actualStatusCode, "The status code are not equals");
    }

    @And("^The proper '(.*)' '(.*)' returned in the response$")
    public void theProperIdReturnedInTheResponse(String property, String value) {
        if (!value.isEmpty()) {
            Data response = (Data) APIManager.getLastResponse().getResponse();
            Assert.assertEquals(String.valueOf(response.getUser().getId()), value, "The " + property + " is not in the response");
        }
    }
}
