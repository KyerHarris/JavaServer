package Requests;

/**
 * FillRequest
 * Populates the server's database with generated data for the specified username. The required "username" parameter must be a user already registered with the server. If there is any data in the database already associated with the given username, it is deleted.
 * The optional "generations" parameter lets the caller specify the number of generations of ancestors to be generated, and must be a non-negative integer (the default is 4, which results in 31 new persons each with associated events).
 */
public class FillRequest {
  /**
   * String username
   * int generations
   */
  private String username;
  private int generations;

  public FillRequest(){}

  public FillRequest(String username) {
    this.username=username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username=username;
  }

  public int getGenerations() {
    return generations;
  }

  public void setGenerations(int generations) {
    this.generations=generations;
  }
}
