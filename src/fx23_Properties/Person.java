package fx23_Properties;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

	// プロパティ型の値を作る
	private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");


	// Returns the StringProperty object
	public StringProperty firstNameProperty() {
		return firstName;
	}

	// Return the firstName value (i.e. "Buckey")
	public String getFirstName() {
		return firstName.get();
	}

	// Set the first name Value
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}



}
