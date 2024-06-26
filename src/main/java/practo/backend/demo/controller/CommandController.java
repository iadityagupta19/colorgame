package practo.backend.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practo.backend.demo.service.SubscriptionService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/commands")
public class CommandController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public CommandController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }


    @PostMapping("/subscribe")
    public void subscribe(@RequestParam String name) {
        subscriptionService.subscribe(name);
    }



    @GetMapping("/list")
    public Set<String> listSubscriptions() {
        return subscriptionService.listSubscriptions();
    }

    @PostMapping("/notify")
    public List<String> notifySubscribers(@RequestParam String color) {
        return subscriptionService.notifySubscribers(color);
    }

    @GetMapping("/exit")
    public String exit() {
        return "Exiting application";
    }

}
