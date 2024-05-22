package ie.williamswalsh.resilience4j_circuit_breaker.web;

import ie.williamswalsh.resilience4j_circuit_breaker.svc.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    @ResponseBody
    public String getActivity() {
        return activityService.getActivity();
    }
}
