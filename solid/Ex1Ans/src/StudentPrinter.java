import java.util.List;

public class StudentPrinter {
    public void printInput(String raw) {
        System.out.println("INPUT: " + raw);
    }

    public void printErrors(List<String> errors) {
        System.out.println("ERROR: cannot register");
        for (String e : errors)
            System.out.println("- " + e);
    }

    public void printSuccess(String id, int totalCount) {
        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + totalCount);
    }

    public void printConfirmation(StudentRecord record) {
        System.out.println("CONFIRMATION:");
        System.out.println(record);
    }

    public void printDbDump(StudentStore store) {
        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(store));
    }
}
