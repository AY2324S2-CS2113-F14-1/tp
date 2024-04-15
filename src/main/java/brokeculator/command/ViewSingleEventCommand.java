package brokeculator.command;

import brokeculator.dashboard.Dashboard;
import brokeculator.event.Event;
import brokeculator.frontend.UI;

public class ViewSingleEventCommand extends Command {
    private int eventIndex;
    
    public ViewSingleEventCommand(int eventIndex) {
        this.eventIndex = eventIndex;
    }

    /**
     * Prints the details of a single event.
     * <p>
     * If the event index is invalid, an error message will be printed.
     * If the event has no expenses, a message will be printed.
     *
     * @param dashboard the dashboard that contains the event manager.
     */
    @Override
    public void execute(Dashboard dashboard, UI ui) {
        boolean isValidEventIndex = dashboard.getEventManager().isEventIdxValid(eventIndex);
        if (!isValidEventIndex) {
            ui.prettyPrint("Invalid event index provided");
            return;
        }
        Event event = dashboard.getEventManager().getEvent(eventIndex);
        assert event != null : "Event is null";

        int expenseCount = event.getExpenseCount();
        if (expenseCount == 0) {
            String string = event + System.lineSeparator()
                    + "Event has no expenses";
            ui.prettyPrint(string);
            return;
        }

        String countString = expenseCount > 1 ? " expenses. " : " expense. ";
        double total = event.getTotalExpenses();
        String string = event + System.lineSeparator()
                + "Event has " + expenseCount + countString + System.lineSeparator()
                + "Total amount spent = $" + String.format("%.2f", total) + System.lineSeparator()
                + System.lineSeparator()
                + event.listExpenses(dashboard.getExpenseManager());
        ui.prettyPrint(string);
    }
}
