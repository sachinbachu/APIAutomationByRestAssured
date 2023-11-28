package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoints.java used to perform Create, Get, Update and Delete operations on User API

public class UserEndPoints2 {
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
					}
	public static Response createUser(User payload)  
	{
		String post_url = getURL().getString("POST_URL");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(post_url);
		return response;
	}
	
	public static Response readUser(String userName) 
	{
		String GET_URL = getURL().getString("GET_URL");
		Response response=given()
				.pathParam("username", userName)
		.when()
		.get(GET_URL);
		return response;
	}
	public static Response updateUser(String userName, User payload) 
	{
		String UPDATE_URL = getURL().getString("UPDATE_URL");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		.when()
		.put(UPDATE_URL);
		return response;
	}
	public static Response deleteUser(String userName) 
	{
		String DELETE_URL = getURL().getString("DELETE_URL");
		Response response=given()
				.pathParam("username", userName)
		.when()
		.delete(DELETE_URL);
		return response;
	}

}
