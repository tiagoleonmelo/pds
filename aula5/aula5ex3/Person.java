package aula5ex3;

public class Person {

	private final String lastName;
	private final String firstName;
	private final String middleName;
	private final String salutation;
	private final String suffix;
	private final String streetAddress;
	private final String city;
	private final String state;
	private final boolean isFemale;
	private final boolean isEmployed;
	private final boolean isHomewOwner;
	
	public static class Builder{
		private final String lastName;
		private final String firstName;
		private final String middleName;
		private String salutation="";
		private String suffix="";
		private String streetAddress="";
		private String city="";
		private String state="";
		private boolean isFemale=false;
		private boolean isEmployed=false;
		private boolean isHomewOwner=false;
		
		public Builder(String newlastName, String newfirstName, String newmiddleName) {
			this.lastName=newlastName;
			this.firstName=newfirstName;
			this.middleName=newmiddleName;
		}
		public Builder salutation(String val) {
			salutation=val;
			return this;
		}
		public Builder suffix(String val) {
			suffix=val;
			return this;

		}
		public Builder streetAddress(String val) {
			streetAddress=val;
			return this;

		}
		public Builder city(String val) {
			city=val;
			return this;

		}
		public Builder state(String val) {
			state=val;
			return this;

		}
		public Builder isFemale(boolean val) {
			isFemale=val;
			return this;

		}
		public Builder isEmployed(boolean val) {
			isEmployed=val;
			return this;

		}
		public Builder isHomewOwner(boolean val) {
			isHomewOwner=val;
			return this;
		}
		public Person build() {
			return new Person(this);
		}
	}
	private Person(Builder builder) {
		lastName=builder.lastName;
		firstName=builder.firstName;
		middleName=builder.middleName;
		salutation=builder.salutation;
		suffix=builder.suffix;
		streetAddress=builder.streetAddress;
		city=builder.city;
		state=builder.state;
		isFemale=builder.isFemale;
		isEmployed=builder.isEmployed;
		isHomewOwner=builder.isHomewOwner;
	}
	@Override
	public String toString() {
		return "Person [lastName=" + lastName + "\n, firstName=" + firstName + "\n, middleName=" + middleName
				+ "\n, salutation=" + salutation + "\n, suffix=" + suffix + "\n, streetAddress=" + streetAddress + "\n, city="
				+ city + "\n, state=" + state + "\n, isFemale=" + isFemale + "\n, isEmployed=" + isEmployed
				+ "\n, isHomewOwner=" + isHomewOwner + "]";
	}
	
}
