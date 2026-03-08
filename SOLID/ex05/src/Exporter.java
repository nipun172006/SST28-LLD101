/**
 * Base contract for exporting data.
 * Postconditions: Returns a non-null ExportResult if supported.
 * Preconditions: ExportRequest must be non-null. Caller should verify supports(req).
 */
public abstract class Exporter {
    public abstract boolean supports(ExportRequest req);
    
    public abstract String getUnsupportedReason();

    public abstract ExportResult export(ExportRequest req);

    protected void validateRequest(ExportRequest req) {
        if (req == null)
            throw new IllegalArgumentException("request cannot be null");
        if (!supports(req)) {
            // Throwing here is safe because we explicitly documented that callers should check supports() first.
            throw new IllegalArgumentException(getUnsupportedReason());
        }
    }
}
