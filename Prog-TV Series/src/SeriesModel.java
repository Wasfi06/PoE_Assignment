public class SeriesModel {
    //Declaring variables
    public String SeriesId;
    public String SeriesName;
    public int SeriesAge;
    public int SeriesNumberOfEpisodes;

    public SeriesModel(String id, String name,int age, int episodes){
        this.SeriesId = id = id;
        this.SeriesName = name;
        this.SeriesAge = age;
        this.SeriesNumberOfEpisodes = episodes;
    }
    public String toString(){
        return "ID: " + SeriesId + ", Name: " + SeriesName + ", Age: " + SeriesAge
                + ", Episodes: " + SeriesNumberOfEpisodes;
    }
}
