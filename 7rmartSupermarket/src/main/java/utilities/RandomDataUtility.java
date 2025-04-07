package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker faker=new Faker();
	
	public String createRandomUsername() {
		return faker.name().username();
	}
	public String createRandomPassword() {
		return faker.internet().password();
	}
	public String createRandomName() {
		return faker.name().firstName();
	}
	public String createRandomemail() {
		return faker.internet().emailAddress();
	}
	public int createRandomPhonenum() {
		return (int) faker.number().randomNumber();
	}
	public String generateRandomColour() {
		return faker.color().name();
	}
}
