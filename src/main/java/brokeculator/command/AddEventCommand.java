package brokeculator.command;

import brokeculator.dashboard.Dashboard;
import brokeculator.event.Event;
import brokeculator.frontend.UI;

public class AddEventCommand extends Command {
    
    private String eventName;
    private String eventDescription;

    public AddEventCommand(String eventName, String eventDescription) {
        assert eventName != null : "Event name cannot be null";
        assert eventDescription != null : "Event description cannot be null";
        this.eventName = eventName;
        this.eventDescription = eventDescription;
    }

    /**
     * Creates an event with the given name and description.
     * Adds the event to the dashboard's event manager.
     *
     * @param dashboard the dashboard that contains the event manager.
     */
    @Override
    public void execute(Dashboard dashboard, UI ui) {
        Event event = new Event(eventName, eventDescription);
        dashboard.getEventManager().addEvent(event);
        ui.prettyPrint("Event added successfully");
    }
}
