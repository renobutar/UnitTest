package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Region;

public class RegionDao {
    private Connection con;

    public RegionDao(Connection connection) {
        this.con = connection;
    }

    public List<Region> getAll() {
        List<Region> region = new ArrayList<>();
        String query = "Select regionId, regionName from Region";
        try {
            ResultSet resultSet = con.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
        } catch (Exception e) {
       
            e.printStackTrace();
        }
        return region;
    }

    public boolean insertData(Region region){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Insert INTO region(regionId, regionName) values(?,?)");
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.setString(2, region.getRegionName());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateData(Region region){
        try {
            String query = "Update region SET regionId = ?, regionName = ? WHERE regionId = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.setString(2, region.getRegionName());
            preparedStatement.setInt(3, region.getRegionId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Region region){
        try {
            String query = "Delete from region where regionId = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
