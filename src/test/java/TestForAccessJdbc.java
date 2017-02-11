import com.java.jdbc.AccessJdbc;


import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by Oleg on 11.02.2017.
 */
public class TestForAccessJdbc {
    private AccessJdbc accessJdbc;
    @Test
    public void getAllFlats(){
accessJdbc=new AccessJdbc();
        try {
            assertEquals("Результат:\n"+"Cоломенский 50 2 100000 Борщаговская 146\n"+"Соломенский 75 4 150000 Металистов 14\n"+"Соломенский 80 4 175000 Полевая 12".trim(),accessJdbc.selectAll().trim());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void getFlatsByArea() throws SQLException {
        accessJdbc=new AccessJdbc();
        assertEquals("Результат:\n"+"Cоломенский 50 2 100000 Борщаговская 146\n"+"Соломенский 75 4 150000 Металистов 14\n"+"Соломенский 80 4 175000 Полевая 12".trim(),accessJdbc.selectFlatsByArea(100).trim());
    }
        @Test
        public void getFlatsByAnotherArea() throws SQLException {
            accessJdbc=new AccessJdbc();
            assertEquals("Результат:\n"+"Cоломенский 50 2 100000 Борщаговская 146\n"+"Соломенский 75 4 150000 Металистов 14".trim(),accessJdbc.selectFlatsByArea(76).trim());
        }
    @Test
    public void getFlatsByPrice() throws SQLException {
accessJdbc=new AccessJdbc();
        assertEquals("Результат:\n"+"Cоломенский 50 2 100000 Борщаговская 146\n"+"Соломенский 75 4 150000 Металистов 14\n"+"Соломенский 80 4 175000 Полевая 12".trim(),accessJdbc.selectFlatsByPrice(200000).trim());
    }
}
