package ar.steps;

import api.config.EntityConfiguration;
import api.model.project.TimeAddResponse;
import api.model.project.TimeEntryRespService;
import ar.validator.TimeEntriesValidator;
import ar.validator.WorkspaceValidator;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import com.google.api.client.repackaged.com.google.common.base.Splitter;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.lang.StringUtils;
import services.BaseService;


import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class TimeProjectSteps extends PageSteps {

    @Given("Mi cuenta creada en clockify y mi X-Api-Key geneada")
    public void miCuentaCreadaEnClockifyYMiXApiKeyGeneada() {
        BaseService.API_KEY.set("ZGJjNGUwYjQtNGYwNy00ZDg5LWJjYjAtYjkzYjEzMjc2ZDE4");
    }
    @When("^I perform a '(.*)' to '(.*)' endpoint with the '(.*)' and '(.*)'$")
    public void doRequest(String methodName, String entity, String jsonName, String jsonReplacementValues) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class entityService = EntityConfiguration.valueOf(entity).getEntityService();
        Map<String, String> parameters = getParameters(jsonReplacementValues);
        String jsonPath = "request/".concat(jsonName);
        if (parameters == null) {
            entityService.getMethod(methodName.toLowerCase(), String.class).invoke("", jsonPath);
        } else {
            entityService.getMethod(methodName.toLowerCase(), String.class, Map.class).invoke("", jsonPath, parameters);
        }
    }
    @Then("Obtengo los datos de mi Workspace")
    public void obtengoLosDatosDeMiWorkspace() {
        WorkspaceValidator.validate();
    }

    @Given("X-Api-Key invalido")
    public void xApiKeyInvalido() {

    }

    @Given("que genere un X-Api-Key valido")
    public void queGenereUnXApiKeyValido() {BaseService.API_KEY.set("ZGJjNGUwYjQtNGYwNy00ZDg5LWJjYjAtYjkzYjEzMjc2ZDE4");
    }


    private Map<String, String> getParameters(String jsonReplacementValues) {
        Map<String, String> parameters = null;
        if (!StringUtils.isEmpty(jsonReplacementValues)) {
            parameters = Splitter.on(",").withKeyValueSeparator(":").split(jsonReplacementValues);
        }
        return parameters;
    }
    @And("un User Id valido")
    public void unUserIdValido() { BaseService.USER_ID.set("616f3fcc3a4a8554be9cbd9f");
    }

    @Then("Valido los datos obtenidos")
    public void validoLosDatosObtenidos() {
        TimeEntriesValidator.validarIdNoNull();
    }
    @And("un workspace ID valido")
    public void unWorkspaceIDValido() {BaseService.ID_WORKSPACE.set("616f3fcd3a4a8554be9cbda3");

    }
    @Then("valido el ID")
    public void validoElID() {
        TimeEntryRespService timeentryresponse = (TimeEntryRespService) APIManager.getLastResponse().getResponse();
        timeentryresponse.getId();
    }

    @And("designar una nueva hora (.*)")
    public void designarUnaNuevaHoraStartedHour(String hour) {
        BaseService.HOUR.set(hour);
    }
    @And("designar time entry id")
    public void designarTimeEntryId() {
        TimeAddResponse response = (TimeAddResponse) APIManager.getLastResponse().getResponse();
        BaseService.ID_TIME.set(response.getId());
    }

    @And("guardo el id")
    public void guardoElId() {
        TimeEntryRespService response = (TimeEntryRespService) APIManager.getLastResponse().getResponse();
        BaseService.UPDATE_HOUR.set(response.getId());
    }
}
