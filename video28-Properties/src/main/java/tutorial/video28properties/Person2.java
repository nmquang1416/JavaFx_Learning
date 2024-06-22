package tutorial.video28properties;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person2 {
    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    //Return the StringProperty object
    public String getFirstName() {
        return firstName.get();
    }
    //Return the firstName value (ue. "Quang")
    public StringProperty firstNameProperty() {
        return firstName;
    }
    //Set the firstName value
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
