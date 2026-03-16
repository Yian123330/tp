package seedu.goldencompass.command;

import org.junit.jupiter.api.Test;
import seedu.goldencompass.exception.GoldenCompassException;
import seedu.goldencompass.internship.InternshipList;
import seedu.goldencompass.parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddInternshipCommandTest {

    private final Parser parser;
    private final InternshipList internshipList;
    private final AddInternshipCommand addInternshipCommand;

    public AddInternshipCommandTest() throws GoldenCompassException {
        this.parser = new Parser();
        this.internshipList = new InternshipList();
        addInternshipCommand = new AddInternshipCommand(parser, internshipList);
    }

    @Test
    public void execute_validInput_addsInternshipSuccessfully() throws GoldenCompassException {

        // 2. Simulate what the Preparser does for: add Shopee /t Software Engineer
//        Map<String, List<String>> parameters = new HashMap<>();
//        parameters.put("add-application", List.of("Shopee"));
//        parameters.put("/t", List.of("Software Engineer"));
        parser.parse("add Shopee /t Software Engineer");

        // 3. Execute the command
        addInternshipCommand.execute();

        // 4. Verify the result (List should now have 1 item)
        assertEquals(1, internshipList.getSize());
    }

    @Test
    public void execute_emptyCompanyName_throwsException() throws GoldenCompassException {

        parser.parse("add     /t Software Engineer");

        // Verify that executing this throws the expected exception
        assertThrows(GoldenCompassException.class, addInternshipCommand::execute);

    }

    @Test
    public void execute_emptyTitle_throwsException() throws GoldenCompassException {

        parser.parse("add Shopee /t    ");

        // Verify that executing this throws the expected exception
        assertThrows(GoldenCompassException.class, addInternshipCommand::execute);

    }
}
