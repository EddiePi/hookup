package utils.fileWatcher;

/**
 * Created by Eddie on 2017/6/8.
 */
public enum FileAction {
    DELETE("ENTRY_DELETE"), CREATE("ENTRY_CREATE"), MODIFY("ENTRY_MODIFY");
    private String value;

    FileAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
