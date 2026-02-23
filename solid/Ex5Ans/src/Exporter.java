/**
 * Base contract for exporting data.
 * Postconditions: Returns a non-null ExportResult.
 * Preconditions: ExportRequest must be non-null.
 * Behavior: Subclasses may have format-specific constraints (e.g. length
 * limits).
 */
public abstract class Exporter {
    public abstract ExportResult export(ExportRequest req);

    protected void validateRequest(ExportRequest req) {
        if (req == null)
            throw new IllegalArgumentException("request cannot be null");
    }
}
