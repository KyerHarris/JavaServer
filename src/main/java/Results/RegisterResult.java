package Results;

import Model.AuthToken;

/**
 * RegisterResult
 * Returns an authtoken as well as the username and personID of who was logged in, and if the register succeeded
 */
public class RegisterResult {
  /**
   * String authtoken;
   * Unique authtoken
   */
  /**
   * String username;
   * Unique username for user
   */
  /**
   * String personID;
   * Unique identifier for this person
   */
  /**
   * boolean success;
   * Whether the request succeeded or failed
   */
  private String authtoken;
  private String username;
  private String personID;
  boolean success;

  public RegisterResult(String authtoken, String username, String personID, boolean success) {
    this.authtoken=authtoken;
    this.username=username;
    this.personID=personID;
    this.success=success;
  }

  public String getAuthtoken() {
    return authtoken;
  }

  public void setAuthtoken(String authtoken) {
    this.authtoken=authtoken;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username=username;
  }

  public String getPersonID() {
    return personID;
  }

  public void setPersonID(String personID) {
    this.personID=personID;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success=success;
  }
}
