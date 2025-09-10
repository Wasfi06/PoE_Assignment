import static org.junit.jupiter.api.Assertions.*;

import org.example.Series;
import org.example.SeriesModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
//ChatGBT assisted with this JUnit Test
public class SeriesTest {
    private Series series;

    @BeforeEach
    public void setUp() {
        series = new Series();

        series.CaptureSeriesForTest("101", "Extreme Sports", "12", "10");
        series.CaptureSeriesForTest("102", "Bargain Hunters", "10", "10");
    }
    @Test
    public void TestSearchSeries() {
        SeriesModel result = series.findSeriesByIdForTest("101");
        assertNotNull(result);
        assertEquals("Extreme Sports", result.SeriesName);
    }
    @Test
    public void TestSearchSeries_SeriesNotFound() {
        SeriesModel result = series.findSeriesByIdForTest("999");
        assertNull(result);
    }
    @Test
    public void TestUpdateSeries() {
        boolean updated = series.updateSeriesAgeForTest("101", "15");
        assertTrue(updated);

        SeriesModel result = series.findSeriesByIdForTest("101");
        assertEquals("15", result.SeriesAge);
    }
    @Test
    public void TestDeleteSeries() {
        boolean deleted = series.deleteSeriesForTest("101");
        assertTrue(deleted);

        SeriesModel result = series.findSeriesByIdForTest("101");
        assertNull(result);
    }
    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        boolean deleted = series.deleteSeriesForTest("999");
        assertFalse(deleted);
    }
    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(series.isValidAge("12"));
        assertTrue(series.isValidAge("18"));
        assertTrue(series.isValidAge("2"));
    }
    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        assertFalse(series.isValidAge("1"));    // below valid range
        assertFalse(series.isValidAge("20"));   // above valid range
        assertFalse(series.isValidAge("abc"));  // not a number
    }
}

