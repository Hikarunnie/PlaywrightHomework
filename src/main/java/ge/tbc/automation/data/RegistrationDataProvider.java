package ge.tbc.automation.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.testng.annotations.DataProvider;

public class RegistrationDataProvider {
    @DataProvider
    public static Object[][] newUsersDataProvider(){
        DatabaseSteps databaseSteps = new DatabaseSteps();
        List<UserModel> users = databaseSteps.allRegisteredUserData();

        Object[][] newUserData = new Object[users.size()][1];
        for (int i = 0; i < users.size(); i++){
            newUserData[i][0] = users.get(i);
        }
        return newUserData;
    }
}
