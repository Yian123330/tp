package seedu.goldencompass.command;

import seedu.goldencompass.exception.GoldenCompassException;
import seedu.goldencompass.internship.InternshipList;
import seedu.goldencompass.parser.Parser;
import seedu.goldencompass.parser.Config;
import seedu.goldencompass.ui.Ui;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class ExampleCommand implements Command {

    private final Ui ui;
    private final Parser parser;
    private final InternshipList internships;

    private static final Set<String> COMMAND_FLAGS = new HashSet<>(Arrays.asList("/eg", "/EG"));

    public ExampleCommand(Parser parser, InternshipList internships) {
        ui = new Ui();
        this.parser = parser;
        this.internships = internships;
//        Config.registerCommandFlag("example", COMMAND_FLAGS);
//        CommandRegistry.registerCommand("example", this); //self register
    }

    /**
     * Prints a list of legal flags with their respective parameters.
     * <P><B>Example Use</B></P>
     */
    @Override
    public void execute() throws GoldenCompassException {

        Map<String, List<String>> flagToParamMap = parser.getFlagToParamMap();

        ui.print("hi, I am ExampleCommand");

        for(String key : flagToParamMap.keySet()) {
            List<String> params = parser.getParamsOf(key);
            ui.print("I have this flag " + key + " with params: " + params);
        }

    }
}