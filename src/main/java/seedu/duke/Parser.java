package seedu.duke;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides methods to parse user input.
 */
public class Parser {
    private static String commandWord;
    private static Map<String, String> flagToParameterMap;

    private static final int COMMAND_WORD_INDEX = 0;
    private static final String FLAG_INDICATOR = "-";

    public static void parse(String userInput) {
        String[] userInputs = userInput.split("\\s+");
        String[] arguments = Arrays.copyOfRange(userInputs, 1, userInputs.length);

        commandWord = userInputs[COMMAND_WORD_INDEX];

        //extract each flag with its param
        flagToParameterMap = new HashMap<>();
        for(int index = 0; index < arguments.length; index ++) {
            String currArg = arguments[index];
            if(!isFlag(currArg)) {
                //throw
            }
            //it is a flag
            if(!(index + 1 < arguments.length)) {
                flagToParameterMap.put(currArg, "");
                continue;
            }
            //it is a flag, and there is something behind
            String nextArg = arguments[index + 1];
            if(isFlag(nextArg)) {
                flagToParameterMap.put(currArg, "");
                continue;
            }

            //it is a flag, and a param follows
            flagToParameterMap.put(currArg, nextArg);
            //skip the param since it is recorded.
            index++;
        }
    }

    /**
     *
     * @param text a string to be checked against.
     * @return True if {@code text} is a flag.
     */
    private static boolean isFlag(String text) {
        //TODO: maybe can check against a HashSet of flags.
        return text.startsWith(FLAG_INDICATOR);
    }

    public static String getCommandWord() {
        return commandWord;
    }

    public static Map<String, String> getFlagToParameterMap() {
        return flagToParameterMap;
    }
}
