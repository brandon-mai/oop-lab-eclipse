package Lab02.AimsProject.src.hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(String title) {
        super();
        this.setTitle(title);
        tracks = new ArrayList<Track>();
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added.");
        } else {
            System.out.println("Track " + track.getTitle() + " existed.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed.");
        } else {
            System.out.println("Track " + track.getTitle() + " not found.");
        }
    }

    public int getLength() {
        return tracks.stream().map(Track::getLength).reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        StringBuilder printing = new StringBuilder("CD - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " - " + getDirector()
                + " - " + getLength() + " : " + getCost() + "$");
        for (Track track : tracks) {
            printing.append("\n\t").append(track.toString());
        }
        return printing.toString();
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        tracks.forEach(Track::play);
    }
}
