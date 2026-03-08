import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
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

        String title = escapeCsv(req.title);
        String body = escapeCsv(req.body);

        String csv = "title,body\n" + title + "," + body + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    private String escapeCsv(String s) {
        if (s == null) return "";
        if (s.contains(",") || s.contains("\n") || s.contains("\"")) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }
}
