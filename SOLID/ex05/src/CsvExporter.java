import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        validateRequest(req);

        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body.replace("\n", " ").replace(",", " ");

        String csv = "title,body\n" + title + "," + body + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }
}
