import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {
    @Override
    public boolean supports(ExportRequest req) {
        return true;
    }

    @Override
    public String getUnsupportedReason() {
        return "";
    }

    @Override
    public ExportResult export(ExportRequest req) {
        validateRequest(req);

        // Uses a proper structured format, keeping null identical semantically (or escaping safely)
        String json = "{\"title\":\"" + escape(req.title) + "\",\"body\":\"" + escape(req.body) + "\"}";
        return new ExportResult("application/json", json.getBytes(StandardCharsets.UTF_8));
    }

    private String escape(String s) {
        if (s == null)
            return "";
        return s.replace("\"", "\\\"");
    }
}
