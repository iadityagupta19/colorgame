package practo.backend.demo.service;

import org.springframework.stereotype.Service;
import practo.backend.demo.model.Thing;

import java.util.*;

@Service
public class SubscriptionService {

    private final Map<String, Thing> things = new HashMap<>();
    private final Set<String> subscriptions = new HashSet<>();

    public SubscriptionService() {
        things.put("Banana", new Thing("Banana", Arrays.asList("Green", "Yellow")));
        things.put("Ink", new Thing("Ink", Arrays.asList("Red", "Black")));
        things.put("Salt", new Thing("Salt", Collections.singletonList("White")));
        things.put("Blood", new Thing("Blood", Collections.singletonList("Red")));
        things.put("Sky", new Thing("Sky", Arrays.asList("Blue", "Black")));
        things.put("Apple", new Thing("Apple", Arrays.asList("Green", "Red")));
        things.put("Frog", new Thing("Frog", Arrays.asList("Blue", "Yellow")));
    }
    public void subscribe(String name) {
         String newName = name.substring(1);
        if (things.containsKey(newName)) {
            if (name.startsWith("+")) {
                subscriptions.add(newName);

            }
            else {
                this.unsubscribe(newName);
            }
        }
    }
    public void unsubscribe(String name) {
        subscriptions.remove(name);
    }
    public Set<String> listSubscriptions() {
        return subscriptions;
    }
    public List<String> notifySubscribers(String color) {
        List<String> notifications = new ArrayList<>();
        for (String subscription : subscriptions) {
            Thing thing = things.get(subscription);
            if (thing.getColors().contains(color)) {
                if (thing.getName().equals("Frog")) {
                    notifications.add("I'm Frog! I am " + color.toLowerCase() + " today.");
                } else {
                    notifications.add("I'm " + thing.getName() + "! I'm sometimes " + color.toLowerCase() + "!");
                }
            }
        }
        return notifications;
    }

}
