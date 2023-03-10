package Results;

/**
 * ClearResult
 * Returns if database was cleared
 */
public class ClearResult {
  /**
   * bool success
   * Whether the request succeeded or failed
   */
  private boolean success = false;
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message=message;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success=success;
  }
}
