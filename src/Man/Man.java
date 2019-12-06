package Man;
import java.util.LinkedList;
import java.util.List;

import RadioStation.RadioStation;
import Song.Song;

interface Observer {
    void listen (Song song, RadioStation station);
}

public class Man implements Observer{
    private String name;
    private List<RadioStation> signedStations;


    public Man(String name){
        this.name = name;
        signedStations = new LinkedList<RadioStation>();
    }
    public String GetName(){return this.name;}

    @Override
    public void listen(Song song, RadioStation station) {
        System.out.println("Listener Name: " + this.name);
        System.out.println("Radio Station: " + station.GetStationName() + " Song Name: " + song.GetDescription() +
                " Singer Name: " + song.GetSingerName() + " Duration: "+ song.GetDuration());
    }

    public void signToStation(RadioStation st){
        //private RadioStation station;
        st.registerMan(this);
        signedStations.add(st);
    }
}
