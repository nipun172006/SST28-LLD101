import java.util.*;

public class FileStore implements InvoiceStore {
    private final Map<String, String> files = new HashMap<>();

    @Override
    public void save(String id, String content) {
        files.put(id, content);
    }

    @Override
    public int countLines(String id) {
        if (!files.containsKey(id))
            return 0;
        return files.get(id).split("\n").length;
    }
}
