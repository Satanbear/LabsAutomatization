package test.DAO;

import test.model.Foodstuffs;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DAOFoodStuffs {
    public List getAll() {
        try (Connection connection = ConnectionJDBC.getConnect()) {
            ResultSet resultSet =
                    connection.createStatement().executeQuery("SELECT * FROM \"Foodstuffs\" ORDER BY \"id\" ASC");
            List list = new ArrayList();
            while (resultSet.next()) {
                list.add(new Foodstuffs(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("purchasePrice"),
                        resultSet.getInt("amount"),
                        resultSet.getInt("markup"),
                        resultSet.getDate("shelfLife")));
            }
            return list;
        } catch (SQLException e) {
            return null;
        }
    }
    public List getAllFromView() {
        try (Connection connection = ConnectionJDBC.getConnect()) {
            ResultSet resultSet =
                    connection.createStatement().executeQuery("SELECT * FROM \"productdetails\"");
            List list = new ArrayList();
            while (resultSet.next()) {
                list.add(new Foodstuffs(
                        resultSet.getString("name"),
                        resultSet.getInt("PriceForOneItem"),
                        resultSet.getInt("purchasePrice"),
                        resultSet.getInt("profit")));
            }
            return list;
        } catch (SQLException e) {
            return null;
        }
    }
    public List getExpiredProducts() {
        try (Connection connection = ConnectionJDBC.getConnect()) {
            ResultSet resultSet =
                    connection.createStatement().executeQuery("SELECT \"name\" FROM \"Foodstuffs\" WHERE CURRENT_DATE > \"shelfLife\"");
            List list = new ArrayList();
            while (resultSet.next()) {
                list.add(new Foodstuffs(
                        resultSet.getString("name")));
            }
            return list;
        } catch (SQLException e) {
            return null;
        }
    }
    public void insert(Foodstuffs foodstuffs) {
        try (Connection connection = ConnectionJDBC.getConnect()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO \"Foodstuffs\" (\"name\", \"purchasePrice\", \"amount\", \"markup\", \"shelfLife\", \"comment\") VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1, foodstuffs.getName());
            preparedStatement.setInt(2, foodstuffs.getPurchasePrice());
            preparedStatement.setInt(3, foodstuffs.getAmount());
            preparedStatement.setInt(4, foodstuffs.getMarkup());
            preparedStatement.setDate(5, foodstuffs.getShelfLife());
            preparedStatement.setString(6, foodstuffs.getComment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return;
        }
    }
    public void delete(int id) {
        try (Connection connection = ConnectionJDBC.getConnect()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM \"Foodstuffs\"  WHERE  \"id\" = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return;
        }
    }
}
