package seedu.goldencompass.preparser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Config {
    public static final Set<String> ALL_FLAGS = new HashSet<>(Arrays.asList("/a", "/b", "/c"));
    public static final Set<String> ALL_COMMANDS = new HashSet<>(Arrays.asList("example", "alias"));
    public static final int COMMAND_WORD_INDEX = 0;
    public static final String FLAG_INDICATOR = "/";
    public static final String DEFAULT_FLAG = "/default";
}
