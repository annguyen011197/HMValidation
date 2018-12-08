package core.result;

public class Result {
    private String name;
    private boolean failed;
    private String error;
    public Result( String name, String error) {
        this.failed = true;
        this.name = name;
        this.error = error;
    }

    public Result( String name) {
        this.failed = false;
        this.name = name;
        this.error = "";
    }

    public boolean isFailed() {
        return failed;
    }

    public String getName() {
        return name;
    }

    public String getError() {
        return error;
    }
}
