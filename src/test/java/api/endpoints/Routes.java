package api.endpoints;

/*
 Swagger URL -  https://petstore.swagger.io/ 
 Create User (POST) - https://petstore.swagger.io/v2/user
 Get User (GET) - https://petstore.swagger.io/v2/user/{username}
 Update User (PUT) - https://petstore.swagger.io/v2/user/{username}
 Delete User (DELETE) - https://petstore.swagger.io/v2/user/{username} 
 */

public class Routes {
	public static String BASE_URL="https://petstore.swagger.io/v2";
	
	//User Module
	
	public static String POST_URL=BASE_URL+"/user";
	public static String GET_URL=BASE_URL+"/user/{username}";
	public static String UPDATE_URL=BASE_URL+"/user/{username}";
	public static String DELETE_URL=BASE_URL+"/user/{username}";
	
	//Store Module
	
	//Pet Module
	

}
