package seedu.goldencompass.parser;

import seedu.goldencompass.exception.GoldenCompassException;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Parser {

    public String command = "";
    public String companyName = "";
    public String jobDescription = "";

    public void parse(String message) throws GoldenCompassException {
        String[] words = message.split("\\s+");

        command = words[0];

        switch (command) {
            case "bye", "list" -> {

            }
            case "find" -> {
                try {
                    companyName = message.substring(5);
                } catch (StringIndexOutOfBoundsException e) {
                    throw new GoldenCompassException("Find what?");
                }
            }
            default -> {
                throw new GoldenCompassException("Invalid command");
            }
        }


    }
}
