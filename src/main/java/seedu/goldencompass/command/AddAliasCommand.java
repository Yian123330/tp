package seedu.goldencompass.command;

import seedu.goldencompass.exception.GoldenCompassException;
import seedu.goldencompass.exception.GoldenCompassTooManyArgumentsException;
import seedu.goldencompass.parser.Parser;

import java.util.List;
import java.util.Map;

import static seedu.goldencompass.parser.Config.DEFAULT_FLAG;

public class AddAliasCommand extends CommandClass{

    //default + /c + /a; total 3
    private static final int PARAM_LENGTH = 3;

    public AddAliasCommand(Parser parser) {
        super(parser);
    }
//    @Override
//    public void execute(Map<String, List<String>> flagToParamMap) throws GoldenCompassException {
//        //default flag can only have one element
//        String[] params = flagToParamMap.get(DEFAULT_FLAG).get(0).split("\\s+");
//
//        if(params.length != PARAM_LENGTH) {
//            throw new GoldenCompassTooManyArgumentsException(PARAM_LENGTH);
//        }
//
//        String commandWord = params[COMMAND_WORD_INDEX];
//        String alias = params[ALIAS_INDEX];
//
//        Executable executable = CommandRegistry.getCommand(commandWord);
//        CommandRegistry.registerCommand(alias, executable);
//    }

    @Override
    public void execute() throws GoldenCompassException {
        if(parser.getFlagToParamMap().size() != PARAM_LENGTH) {
            throw new GoldenCompassTooManyArgumentsException(PARAM_LENGTH);
        }
        String commandWord = parser.getParamsOf("/c").get(0);
        String alias = parser.getParamsOf("/a").get(0);

        Executor.addAlias(commandWord, alias);
        ui.print("Command: \"" + commandWord + "\" now has a new alias: \"" + alias + "\"");
    }
}
