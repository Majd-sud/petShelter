package petshelter;

// Custom exception class for handling file input/output errors
public class FileIOException extends Exception {

    // Constructors

    // Default constructor
    public FileIOException() {
        super();
    }

    // Constructor with a custom error message
    public FileIOException(String message) {
        super(message);
    }

    // Constructor with a custom error message and a cause (another throwable)
    public FileIOException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with a cause (another throwable)
    public FileIOException(Throwable cause) {
        super(cause);
    }
}