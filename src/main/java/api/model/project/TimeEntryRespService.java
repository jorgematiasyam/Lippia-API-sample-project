package api.model.project;

import api.model.workspace.HourlyRate;
import api.model.workspace.Membership;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TimeEntryRespService {
    private String id;
    private String description;

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

}