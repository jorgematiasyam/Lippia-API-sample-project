package services;

import api.model.project.TimeEntryRespService;
import com.crowdar.api.rest.Response;

import java.util.HashMap;
import java.util.Map;


public class ProjectTimeEntry extends BaseService{

    public static Response get(String jsonName) {return get(jsonName, TimeEntryRespService[].class,setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("api-key",API_KEY.get());
        params.put("workspaceId",ID_WORKSPACE.get());
        params.put("userId",USER_ID.get());
        return params;
    }
    public static Response post(String jsonName) {return post(jsonName, TimeEntryRespService.class,setParams());
    }
    public static Response put(String jsonName) {return put(jsonName, TimeEntryRespService.class,setParamsput());
    }
    private static Map<String, String> setParamsput() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("api-key",API_KEY.get());
        params.put("workspaceId",ID_WORKSPACE.get());
        params.put("id", UPDATE_HOUR.get());
        return params;
    }

}
