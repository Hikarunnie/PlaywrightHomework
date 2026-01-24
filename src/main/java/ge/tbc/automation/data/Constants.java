package ge.tbc.automation.data;

import ge.tbc.automation.pages.FavouritesPage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Constants {
    public static final String WEBSITE_URL = "https://practicesoftwaretesting.com/";
    public static final String TECH_CANVAS_URL="https://techcanvass.com/examples/register.html";
    public static final String FAVOURITE_CARD = " Pliers ";
    public static final String POWER_TOOLS= " Power Tools ";
    public static final String THOR_HAMMER =" Thor Hammer ";
    public static final int THOR_HAMMER_INDEX=8;
    public static final String TOOLS_BELTS= " Tool Belts ";
    public static final String HAMMER ="Hammer";
    public static final String FORGE_FLEX_TOOLS ="ForgeFlex Tools";
    public static final String SAFETY_GEAR ="Safety Gear";
    public  static final String FILTER_KEYWORDS ="Safety";
    public static final String  QUANTITY ="2";
    public static final String CART_SUCCESS_NOTIFICATION ="Product added to shopping cart.";
    public static final String FAVOURITE_ADDED_MESSAGE = "Product added to your favorites list.";
    public static final String PLIERS ="Pliers";
    public static final String QUANTITY_NEW ="4";
    public static final String SIGN_IN_STEP ="Sign in";
    public static final String BILLING_STEP ="Billing Address";
    public static final String PAYMENT_STEP= "Payment";
    public static final String PAYMENT_METHOD="Cash on Delivery";
    public static final String ORDER_CONFIRMATION ="Thanks for your order!";
    public static final String PAYMENT_METHOD_MESSAGE="Payment was successful";
    public static final int RANDOM_PRODUCT=1;
    public static final String INVALID_EMAIL ="invalid.com";
    public static final String INVALID_PASSWORD ="4444";
    public static final String INVALID_EMAIL_MESSAGE="Email format is invalid";
    public static final String INVALID_PASSWORD_MESSAGE="Password must be minimal 6 characters long. Password must include invalid characters.";
    public static final String REGISTER_HEADER="Customer registration";
    public static final String FORGOT_PASSWORD_HEADER ="Forgot Password";
    public static final String EMAIL="email";
    public static final String PASSWORD="password";
    public static final String PASSWORD_UPDATE_SUCCESS_MESSAGE="Your password is successfully updated!";
    public static final String FIRST_NAME_ALERT="First name is required";
    public static final String LAST_NAME_ALERT="Last name is required";
    public static final String EMAIL_ALERT="Email is required";
    public static final String SUBJECT_ALERT="Subject is required";
    public static final String MESSAGE_ALERT="Message is required";
    public static final String FILE_ALERT="File should be empty.";

    public static final String[] ALL_CONTACT_ALERTS =new String[]{FIRST_NAME_ALERT,LAST_NAME_ALERT, EMAIL_ALERT,SUBJECT_ALERT,MESSAGE_ALERT};
    public static final String[] SUBJECT_AND_MESSAGE_ALERTS =new String[]{SUBJECT_ALERT,MESSAGE_ALERT};
    public static final int TWO_INVALID_INPUT_SIZE=2;
    public static final int ONE_ALERT_SIZE=1;
    public static final int NO_ALERT_SIZE=0;
    public static final int ALL_INVALID_INPUT_SIZE=5;
    public static final String NAME="Hika";
    public static final String LAST_NAME= "ru";
    public static final String CONTACT_EMAIL="hika@ru.com";
    public static final String SUBJECT ="Payments";
    public static final String  CONTACT_MESSAGE="The story centers on Monkey D. Luffy, a boy who wants to find the “One Piece” – a legendary treasure left by the greatest pirate who ever lived, Gol D. Roger – so that he can become the King of the Pirates.";
    public static final Path INVALID_FILE = Paths.get("src/main/resources/files/Lotr 🍂 Will Turner- I mean Legolas.jpg");
    public static final Path VALID_FILE= Paths.get("src/main/resources/files/TNT.txt");
    public static final String CONTACT_FORM_SUCCESS="Thanks for your message! We will contact you shortly.";


    public static final String PRESTA_SHOP_URL ="https://demo.prestashop.com/";
    public static final String PRESTA_SHOP="PrestaShop";
    public static final String HOME="Home";
    public static final String PRESTA_CONTACT_SUBJECT= "Webmaster";
    public static final String FILE_NAME ="pandas.jpg";
    public static final Path TO_UPLOAD_FILE = Paths.get("src/main/resources/files/"+FILE_NAME);
    public static final String CONTACT_SUCCESS_MESSAGE="Your message has been successfully sent to our team.";
    public static final String CONTACT_US_TEXT="Contact us";
    public static final String SEND_BUTTON_TEXT="Send";
    public static final String EMAIL_ADDRESS_TEXT="Email address";

    public static final String FEMALE ="female";
    public static final String MALE ="male";
}
