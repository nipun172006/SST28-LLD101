import java.util.*;

public class OnboardingService {
    private final StudentStore db;
    private final StudentParser parser;
    private final StudentValidator validator;
    private final StudentPrinter printer;

    public OnboardingService(StudentStore db) {
        this.db = db;
        this.parser = new StudentParser();
        this.validator = new StudentValidator();
        this.printer = new StudentPrinter();
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        Map<String, String> data = parser.parse(raw);
        List<String> errors = validator.validate(data);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(
                id,
                data.get("name"),
                data.get("email"),
                data.get("phone"),
                data.get("program"));

        db.save(rec);

        printer.printSuccess(id, db.count());
        printer.printConfirmation(rec);
    }
}
