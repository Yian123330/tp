package seedu.goldencompass.internship;

import java.util.ArrayList;

public class InternshipList {

    private final ArrayList<Internship> internships = new ArrayList<>();

    public void add(Internship x) {

        internships.add(x);
    }

    public void list() {
        if (internships.isEmpty()) {
            System.out.println("No internships in the list.");
            return;
        }

        System.out.println("Here are the internships you have added:");
        for (int i = 0; i < internships.size(); i++) {
            Internship intern = internships.get(i);
            System.out.println((i + 1) + ". " + intern.companyName + " - " + intern.title);
        }
    }
}
