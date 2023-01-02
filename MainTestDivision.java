import models.Division;
import daos.DivisionDao;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MainTestDivision {
    DbConnection con = new DbConnection();
    @Test 
    public void insert(){
        //Arrange
        Integer Id = 3;
        String Name = "Marketing";
        boolean result = true;

        //Act & Assert
        DivisionDao insertDivision = new DivisionDao(con.getConnection());
        Division division = new Division();
        division.setDivisionId(Id);
        division.setDivisionName(Name);

        assertEquals(result,insertDivision.insertData(division));
    }

    @Test
    public void update(){
        //Arrange
        Integer Id = 1;
        String Name = "Public Relations";
        boolean result = true;

        //Act & Assert
        DivisionDao updateDivision = new DivisionDao(con.getConnection());
        Division division = new Division();
        division.setDivisionId(Id);
        division.setDivisionName(Name);
        division.setDivisionId(Id);

        assertEquals(result, updateDivision.updateData(division));
    }

    @Test
    public void delete(){
        Integer Id = 3;
        boolean result = true;

        DivisionDao deleteDivision = new DivisionDao(con.getConnection());
        Division division = new Division();
        division.setDivisionId(Id);

        assertEquals(result, deleteDivision.delete(division));
    }

}
