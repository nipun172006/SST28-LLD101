import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    @Override
    public boolean supports(ExportRequest req) {
        return (req.body == null || req.body.length() <= 20);
    }

    @Override
    public String getUnsupportedReason() {
        return "PDF cannot handle content > 20 chars";
    }

    @Override
    public ExportResult export(ExportRequest req) {
        validateRequest(req);
        String fakePdf = "PDF(" + req.title + "):" + (req.body == null ? "" : req.body);
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
