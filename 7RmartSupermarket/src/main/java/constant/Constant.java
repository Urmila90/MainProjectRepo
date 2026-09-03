package constant;

public class Constant {
//give all paths in constants class
//all paths should be public, static and final

	public static final String TESTDATA = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\TestDataSample.xlsx";

	public static final String IMAGEPATH1 = System.getProperty("user.dir") + "\\src\\test\\resources\\dryfruits.jpeg";

	public static final String IMAGEPATH2 = System.getProperty("user.dir") + "\\src\\test\\resources\\dryfruits3.jpg";

	public static final String CONFIGFILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";

//save error messages
	public static final String LOGINVALIDCREDENTIALS = "Home page is not loaded with valid credentails";
	public static final String LOGININVALIDUSERNAME = "Home page is loaded with invalid username";
	public static final String LOGINWITHINVALIDPASSWORD = "Home page is loaded with invaid password";
	public static final String LOGINWITHINVALIDUSERNAMEANDPASSWORD = "Home page is not loaded with invalid username and password";
	public static final String ADMINUSERNOTCREATED = "Admin user is not created and hence the success message is not shown";
	public static final String DELIVERYBOYNOTCREATED = "Delivery Boy is not created";
	public static final String LOCATIONNOTSAVED = "Location information is not saved";
	public static final String NEWSNOTSAVED = "News is not saved";
	public static final String CATEGORYNOTCREATED = "Category not created";
}
