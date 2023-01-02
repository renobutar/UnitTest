import models.Region;
import daos.RegionDao;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MainTestRegion {
    DbConnection con = new DbConnection();
    @Test 
    public void insert(){
        //Arrange
        Integer Id = 5;
        String Name = "Banten";
        boolean result = true;

        //Act & Assert
        RegionDao insertRegion = new RegionDao(con.getConnection());
        Region region = new Region();
        region.setRegionId(Id);
        region.setRegionName(Name);

        assertEquals(result,insertRegion.insertData(region));
    }

    @Test
    public void update(){
        //Arrange
        Integer Id = 1;
        String Name = "Bandung";
        boolean result = true;

        //Act & Assert
        RegionDao updateRegion = new RegionDao(con.getConnection());
        Region region = new Region();
        region.setRegionId(Id);
        region.setRegionName(Name);
        region.setRegionId(Id);

        assertEquals(result, updateRegion.updateData(region));
    }

    @Test
    public void delete(){
        Integer id = 5;
        boolean result = true;

        RegionDao deleteRegion = new RegionDao(con.getConnection());
        Region region = new Region();
        region.setRegionId(id);

        assertEquals(result, deleteRegion.delete(region));
    }

}
