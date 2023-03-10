package Results;

import Model.Event;

/**
 * EventResult
 * Returns the single Event object with the specified ID (if the event is associated with the current user). The current user is determined by the provided authtoken.
 * OR
 * Returns ALL events for ALL family members of the current user. The current user is determined from the provided auth token.
 */
public class EventResult {
  /**
   *   Event[] events
   *   All events related to the person and its family tree
   */
   /**
    * String eventID;
    * Unique identifier for this event
    */
   /**
    * String associatedUsername;
    * associatedUsername
    */
   /**
    * String personID;
    * personID
    */
   /**
    * Float latitude;
    * Latitude of event’s location
    */
   /**
    * Float longitude;
    * Longitude of event’s location
    */
   /**
    * String country;
    * Country in which event occurred
    */
   /**
    * String city;
    * City in which event occurred
    */
   /**
    * String eventType;
    * Type of event
    */
   /**
    * Integer year;
    * Year in which event occurred
    */
   /**
    * boolean success;
    * Whether the request succeeded or failed
    */
  private Event[] data;
  private String eventID;
  private String associatedUsername;
  private String personID;
  private Float latitude;
  private Float longitude;
  private String country;
  private String city;
  private String eventType;
  private Integer year;
  private boolean success;
  private String message;

  public void setInfo(Event event){
    eventID = event.getEventID();
    associatedUsername = event.getAssociatedUsername();
    personID = event.getPersonID();
    latitude = event.getLatitude();
    longitude = event.getLongitude();
    country = event.getCountry();
    city = event.getCity();
    eventType = event.getEventType();
    year = event.getYear();
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message=message;
  }

  public Event[] getData() {
    return data;
  }

  public void setData(Event[] data) {
    this.data=data;
  }

  public String getEventID() {
    return eventID;
  }

  public void setEventID(String eventID) {
    this.eventID=eventID;
  }

  public String getAssociatedUsername() {
    return associatedUsername;
  }

  public void setAssociatedUsername(String associatedUsername) {
    this.associatedUsername=associatedUsername;
  }

  public String getPersonID() {
    return personID;
  }

  public void setPersonID(String personID) {
    this.personID=personID;
  }

  public Float getLatitude() {
    return latitude;
  }

  public void setLatitude(Float latitude) {
    this.latitude=latitude;
  }

  public Float getLongitude() {
    return longitude;
  }

  public void setLongitude(Float longitude) {
    this.longitude=longitude;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country=country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city=city;
  }

  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType=eventType;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year=year;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success=success;
  }
}
