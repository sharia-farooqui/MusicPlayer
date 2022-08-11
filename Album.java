import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public Album(){

    }

    public boolean addSongToAlbum(String title, double duration){
        if(findSong(title)==null){
            songs.add(new Song(title, duration));
            System.out.println(title + " successfully added.");
            return true;
        }
        else{
            System.out.println(title + " already exists.");
            return false;
        }
    }

    public Song findSong(String title) {
        for(Song s:songs){
            if(s.getTitle().equals(title)){
                return s;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNo, LinkedList<Song> PlayList){
        int idx = trackNo-1;
        if(idx>0 && idx<=this.songs.size()){
            PlayList.add(this.songs.get(idx));
            return true;
        }
        System.out.println(trackNo + " track number not found.");
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> PlayList){
        for(Song s : this.songs){
            if(s.getTitle().equals(title)){
                PlayList.add(s);
                return true;
            }
        }
        System.out.println(title + " not found.");
        return false;
    }

}
