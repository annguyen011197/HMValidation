package core.result;

public class Result {
    private String name;
    private boolean failed;
    private String message;
    public Result( String name, String message) {
        this.failed = true;
        this.name = name;
        this.message = message;
    }

    public Result( String name) {
        this.failed = false;
        this.name = name;
        this.message = "";
    }

    public boolean isFailed() {
        return failed;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
