package RadioStation;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import Man.Man;
import Song.Song;

interface Observable {
    void registerMan(Man person);
    void removeMan(Man person);
    void onAir(Float stationListeningTime);
}
public class RadioStation implements Observable{
    private String name;
    private Float frequency;
    private Integer priorSong;
    private List<Song> playList;
    private List<Man> peopleListeners;
    public RadioStation(String name, Float frequency) {
        this.name = name;
        this.frequency = frequency;
        peopleListeners = new LinkedList<Man>();
        playList = new LinkedList<Song>();
        this.priorSong = 0;
    }

    public String GetStationName(){return this.name;}
    public Float GetFrequency(){return this.frequency;}
    @Override
    public void registerMan(Man person) {
        peopleListeners.add(person);
    }

    @Override
    public void removeMan(Man person) {
        peopleListeners.remove(person);
    }

    @Override
    public void onAir(Float listeningTime) {
        while(listeningTime > 0) {
            Song s = broadcast();
            for (Man observer : peopleListeners){
                observer.listen(s, this);}
            listeningTime = listeningTime-s.GetDuration();
            long songDurationMs = (long)(s.GetDuration() * 1000);
            try
            {  Thread.sleep(songDurationMs);  }
            catch(InterruptedException ex)
            {Thread.currentThread().interrupt();}
        }
    }

    public void setSong(Song track) {
        playList.add(track);
    }
    public void removeSong(Song track) {
        playList.remove(track);
    }

    public Song broadcast(){
        if (this.playList.size() == 0) return null;
        int min = 0, randomSong = 0; int max = playList.size();
        while (randomSong == this.priorSong) {
            randomSong = ThreadLocalRandom.current().nextInt(min, max);
        }
        this.priorSong = randomSong;
        return playList.get(randomSong);
    }
}
