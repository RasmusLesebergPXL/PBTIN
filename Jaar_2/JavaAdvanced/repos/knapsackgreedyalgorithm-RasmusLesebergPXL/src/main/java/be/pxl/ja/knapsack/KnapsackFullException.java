package be.pxl.ja.knapsack;

public class KnapsackFullException extends Exception {

    public KnapsackFullException() {
    }

    public KnapsackFullException(String description) {
        super(description);
    }

    public KnapsackFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public KnapsackFullException(Throwable cause) {
        super(cause);
    }

    public KnapsackFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
