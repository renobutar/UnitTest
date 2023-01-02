
import models.Region;
import daos.RegionDao;
import models.Division;
import daos.DivisionDao;
public class Test {
    public static void main(String[] args) {
        DbConnection connection = new DbConnection();
        System.out.println(connection.getConnection());

    RegionDao rdao = new RegionDao(connection.getConnection());
    for (Region region : rdao.getAll()){
        System.out.println(region.getRegionId());
        System.out.println(region.getRegionName());
    }
    
    //Insert Data Region
    RegionDao rdao = new RegionDao(connection.getConnection());
    Region region = new Region();
    region.setRegionId(4);
    region.setRegionName("Bali");
    System.out.println(rdao.insertData(region));

   //Update Data Region
    RegionDao rdao = new RegionDao(connection.getConnection());
    Region region = new Region();
    region.setRegionId(5);
    region.setRegionName("Jakarta");
    region.setRegionId(2);
    System.out.println(rdao.updateData(region));
    
    //Delete Data Region
    RegionDao rdao = new RegionDao(connection.getConnection());
    Region region = new Region();
    region.setRegionId(3);
    System.out.println(rdao.delete(region));
    

    //Division
    DivisionDao rdao = new DivisionDao(connection.getConnection());
    for (Division division : rdao.getAll()){
        System.out.println(division.getDivisionId());
        System.out.println(division.getDivisionName());
    }*/
    
   //Insert Data Division
    DivisionDao rdao = new DivisionDao(connection.getConnection());
    Division division = new Division();
    division.setDivisionId(2);
    division.setDivisionName("Finance");
    System.out.println(rdao.insertData(division));

   //Update Data Division
    DivisionDao rdao = new DivisionDao(connection.getConnection());
    Division division = new Division();
    division.setDivisionId(2);
    division.setDivisionName("HR");
    division.setDivisionId(2);
    System.out.println(rdao.updateData(division));
    
    //Delete Data Division
    DivisionDao rdao = new DivisionDao(connection.getConnection());
    Division Division = new Division();
    Division.setDivisionId(2);
    System.out.println(rdao.delete(division));
    
    }
}

