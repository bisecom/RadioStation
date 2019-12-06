package Song;

public class Song {
    private String description;
    private Float duration;
    private String singerName;

    public Song(String description, Float duration, String singerName){
        this.description = description;
        this.duration = duration;
        this.singerName = singerName;
    }

    public String GetDescription(){return this.description;}
    public Float GetDuration(){return this.duration;}
    public String GetSingerName(){return this.singerName;}

}
