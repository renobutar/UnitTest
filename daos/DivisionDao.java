package daos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Division;

public class DivisionDao {
    private Connection con;

    public DivisionDao(Connection connection) {
        this.con = connection;
    }

    public List<Division> getAll() {
        List<Division> division = new ArrayList<>();
        String query = "Select divisionId, divisionName from Division";
        try {
            ResultSet resultSet = con.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
        } catch (Exception e) {
       
            e.printStackTrace();
        }
        return division;
    }

   public boolean insertData(Division division){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Insert INTO division(DivisionId, DivisionName) values(?,?)");
            preparedStatement.setInt(1, division.getDivisionId());
            preparedStatement.setString(2, division.getDivisionName());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateData(Division division){
        try {
            String query = "Update division SET divisionId = ?, divisionName = ? WHERE divisionId = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, division.getDivisionId());
            preparedStatement.setString(2, division.getDivisionName());
            preparedStatement.setInt(3, division.getDivisionId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Division division){
        try {
            String query = "Delete from division where divisionId = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, division.getDivisionId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
