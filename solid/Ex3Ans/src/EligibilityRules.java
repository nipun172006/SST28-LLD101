import java.util.Optional;

class DisciplinaryRule implements EligibilityRule {
    @Override
    public Optional<String> validate(StudentProfile s) {
        if (s.disciplinaryFlag != LegacyFlags.NONE) {
            return Optional.of("disciplinary flag present");
        }
        return Optional.empty();
    }
}

class CgrRule implements EligibilityRule {
    @Override
    public Optional<String> validate(StudentProfile s) {
        if (s.cgr < 8.0) {
            return Optional.of("CGR below 8.0");
        }
        return Optional.empty();
    }
}

class AttendanceRule implements EligibilityRule {
    @Override
    public Optional<String> validate(StudentProfile s) {
        if (s.attendancePct < 75) {
            return Optional.of("attendance below 75");
        }
        return Optional.empty();
    }
}

class CreditsRule implements EligibilityRule {
    @Override
    public Optional<String> validate(StudentProfile s) {
        if (s.earnedCredits < 20) {
            return Optional.of("credits below 20");
        }
        return Optional.empty();
    }
}
