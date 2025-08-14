import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class SeriesTest {

  void setup(){
    Series.clearSeriesList();
  }

  @Test
  public void TestSearchSeries(){
    SeriesModel testSeries = new SeriesModel("S101", "Breaking Good", 16, 10);
    Series.addSeriesDirect(testSeries);
    SeriesModel result =Series.searchSeriesById("S101");

    assertNotNull(result, "Series should be found");
    assertEquals("Breaking Good", result.SeriesName);
    assertEquals(16, result.SeriesAge);
    assertEquals(10, result.SeriesNumberOfEpisodes);
  }
  public static void clearSeriesList(){
    Series.clearSeriesList();
  }

  @Test
  public void TestSearchSeries_SeriesNotFound(){
    SeriesModel result = Series.searchSeriesById("X999");
    assertNull(result,"No series should be found for invalid ID");
  }

  @Test
  public void TestUpdateSeries(){
SeriesModel testSeries = new SeriesModel("S102","Game of chairs",15,8);
Series.addSeriesDirect(testSeries);

boolean updated = Series.updateSeriesById("S102","Game Of Thrones",18,10);

assertTrue(updated, "Series should ge updated");
SeriesModel result = Series.searchSeriesById("S102");
assertEquals("Game Of Thrones",result.SeriesName);
assertEquals(18,result.SeriesAge);
assertEquals(10,result.SeriesNumberOfEpisodes);
  }

  @Test

  public void TestDeleteSeries(){
    SeriesModel testSeries = new SeriesModel("S103","Friends Forever",12,20);
    Series.addSeriesDirect(testSeries);

    boolean deleted = Series.deleteSeriesById("S103");
    assertTrue(deleted,"Series should be deleted");
    assertNull(Series.searchSeriesById("S103"),"Deleted series should not be found");
  }

  @Test
  public void TestDeleteSeries_SeriesNotFound(){
    boolean deleted = Series.deleteSeriesById("ZZZ");
    assertFalse(deleted,"No deletion should happen for a non-existant ID");
  }

  @Test
    public void testSeriesAgeRestriction_Valid(){
      assertTrue(Series.isValidAgeRestriction(5),"Age is valid");
      assertTrue(Series.isValidAgeRestriction(18),"Age is valid");
  }

  @Test
    public void testSeriesAgeRestriction_Invalid(){

      assertFalse(Series.isValidAgeRestriction(1),"Age is invalid");
    assertFalse(Series.isValidAgeRestriction(25),"Age is invalid");
  }
}