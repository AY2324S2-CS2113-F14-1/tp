package brokeculator.parser;

import brokeculator.command.AddEventCommand;
import brokeculator.command.Command;
import brokeculator.command.InvalidCommand;
import brokeculator.event.Event;
import brokeculator.parser.util.Keyword;
import brokeculator.parser.util.OrderParser;
import brokeculator.storage.parsing.FileKeyword;

public class EventParser {
    private static final Keyword[] KEYWORDS = {
        new Keyword(" /n ", "Event name", false),
        new Keyword(" /d ", "Event description", false)
    };

    /**
     * Parses the user input to identify the event name and description.
     *
     * @param userInput User input.
     * @return InvalidCommand if the input is invalid, AddEventCommand otherwise.
     */
    public static Command parseInput(String userInput) {
        String[] userInputs;
        try {
            userInputs = OrderParser.parseOrder(userInput, KEYWORDS);
        } catch (Exception e) {
            return new InvalidCommand(e.getMessage());
        }
        String eventName = userInputs[0];
        String eventDescription = userInputs[1];

        boolean doesNameContainDelimiters =
                Event.hasFileDelimiters(eventName) || FileKeyword.hasFileDelimiters(eventName);
        boolean doesDescriptionContainDelimiters =
                Event.hasFileDelimiters(eventDescription) || FileKeyword.hasFileDelimiters(eventDescription);
        if (doesNameContainDelimiters || doesDescriptionContainDelimiters ){
            return new InvalidCommand("Input has file delimiters");
        }
        return new AddEventCommand(eventName, eventDescription);
    }
}
