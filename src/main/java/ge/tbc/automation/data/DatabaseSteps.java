package ge.tbc.automation.data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DatabaseSteps {
    public List<UserModel> allRegisteredUserData(){
        List<UserModel> users = new ArrayList<>();
        try (Connection connection = MSSQLConnection.getConnection()) {
            String SQL = "select * from RegistrationData;";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                users.add(new UserModel(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("gender"),
                        resultSet.getString("model"),
                        resultSet.getString("address1"),
                        resultSet.getString("address2"),
                        resultSet.getString("city"),
                        resultSet.getString("contact1"),
                        resultSet.getString("contact2")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

}
