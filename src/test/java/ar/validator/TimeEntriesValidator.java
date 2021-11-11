package ar.validator;

import api.model.project.TimeEntryRespService;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class TimeEntriesValidator {
    public static void validarIdNoNull() {
        TimeEntryRespService[] response = (TimeEntryRespService[]) APIManager.getLastResponse().getResponse();
        for (TimeEntryRespService timeentry : response) {
            Assert.assertNotNull(timeentry.getId());
        }
    }
}
