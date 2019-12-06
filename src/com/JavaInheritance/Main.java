package com.JavaInheritance;

import Man.Man;
import RadioStation.RadioStation;
import Song.Song;

public class Main {

    public static void main(String[] args) {

        RadioStation HitFM = new RadioStation("HitFM", 95.6F);
        RadioStation Volna = new RadioStation("Volna", 105.2F);

        Song circles = new Song("Circles", 4F, "Post Malone");
        Song someone = new Song("Someone You Loved", 5F, "Lewis Capaldi");
        Song goodAsHell = new Song("Good As Hell", 3F, "Lizzo");
        Song roxanne = new Song("Roxanne", 6F, "Arizona Zervas");

        HitFM.setSong(circles);  HitFM.setSong(someone);
        Volna.setSong(circles); Volna.setSong(someone); Volna.setSong(goodAsHell); Volna.setSong(roxanne);

        Man john = new Man("John Doe");
        john.signToStation(HitFM);
        Man jonathan = new Man("Jonathan Smith");
        jonathan.signToStation(HitFM);
        jonathan.signToStation(Volna);

        Volna.onAir(20f);//listening duration 20 seconds;
        HitFM.onAir(20f);
    }
}
