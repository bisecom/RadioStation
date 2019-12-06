package RadioStation;

import java.util.LinkedList;
import java.util.List;

import Man.Man;
import Song.Song;

interface Observable {
    void registerMan(Man person);
    void removeMan(Man person);
    void notifyPeople();
}
public class RadioStation implements Observable{
    private List<Song> playList;
    private List<Man> peopleListeners;
    public RadioStation() {
        peopleListeners = new LinkedList<Man>();
        playList = new LinkedList<Song>();
    }

    @Override
    public void registerMan(Man person) {
        peopleListeners.add(person);
    }

    @Override
    public void removeMan(Man person) {
        peopleListeners.remove(person);
    }

    @Override
    public void notifyPeople() {

    }

    public void setSong(Song track) {
        playList.add(track);
    }
    public void removeSong(Song track) {
        playList.remove(track);
    }
}
