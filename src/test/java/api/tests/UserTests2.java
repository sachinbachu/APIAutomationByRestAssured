package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;


public class UserTests2 {
	
	Faker faker;
	User userPayload;
	public Logger logger; //for logs
	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		//logs
				 logger = LogManager.getLogger(this.getClass());

				logger.debug("debugging.....");
	}
	
	@Test(priority =1)
	public void testPostUser() {
		
		
		logger.info("**************Creating User **********************");
		Response response = UserEndPoints2.createUser(userPayload);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("**************User Created**********************");
		
	}
	@Test(priority=2)
	public void testGetUserByName() 
	{
		logger.info("**************get User Details**********************");
		Response response=UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		//Assert.assertEquals(response.getBody(), this.userPayload);
		logger.info("**************User Details returned**********************");
	}
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		logger.info("**************Update User Details**********************");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		Response response = UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		Response responseafterupdate=UserEndPoints2.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseafterupdate.getStatusCode(), 200);
		logger.info("**************Update User Updated**********************");
	}
	@Test(priority=4)
	public void testDeleteUserByName() 
	{
		logger.info("**************Delete User Details**********************");
		Response response=UserEndPoints2.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		//Assert.assertEquals(response.getBody(), this.userPayload);
		logger.info("**************User Details Deleted**********************");
	
}
}