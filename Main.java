import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {
    //something
    //ssdsad
    public static void main(String[] args) {
        VideoClip suicidal  = new VideoClip("Suicidal ",2.37);
        suicidal.setText(
                """
                        Suicidal, your love is suicidal
                        And lately, I've been feeling suicidal
                        Your love is suicidal""");
        suicidal.setSingers("YNW Melly");
        suicidal.setStreamingPlace("Youtube");
        suicidal.setAdvertise(true);
        suicidal.setProducer("Alex Sarzosa");
        suicidal.watch(); suicidal.watch(); suicidal.watch();
        System.out.println(suicidal);
        System.out.println("Просмотрели: " + suicidal.getViews() + " раз.");
        System.out.println("Можно посмотреть на : " + Arrays.toString(suicidal.getStreamingPlace()));
        System.out.println("Добавлена в систему: " +suicidal.getReleaseDate());

    }
}
class Song {
     protected String songName;
     protected double durability;
     protected String text;
     protected String[] singers; // Певцы
     protected int  auditions = 0;
     protected String[] streamingPlace; // Сервисы где можно прослушать
     static String releaseDate = getDate();

     Song(String songName, double durability, String text, String... singers) {
         this.songName = songName;
         this.durability = durability;
         this.text = text;
         this.singers = singers;
     }
     Song(String songName, double durability) {
         this.songName = songName;
         this.durability = durability;
     }

     public void sing() {
         auditions++;
     }
     public int getAuditions() {
         return auditions;
     }


    public String[] getSingers() {
        return singers;
    }

    public void setSingers(String... singers) {
        this.singers = singers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getStreamingPlace() {
        return streamingPlace;
    }

    public void setStreamingPlace(String... streamingPlace) {
        this.streamingPlace = streamingPlace;
    }

    public String getDurability() {
        return durability +" min";
    }

    public String getSongName() {
        return songName;
    }
    public int countSinger() {
         return singers.length;
    }
    private static String getDate() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "Song: "+getSongName()+". Duration: "+ getDurability()+" Singers: "+ Arrays.toString(singers);
    }
}

class VideoClip extends Song {
    protected String producer;
    protected int views = 0;
    protected boolean advertise; //присутсвует ли реклама

    VideoClip(String songName, double durability, String text,String producer, String... singers) {
        super(songName, durability, text, singers);
        this.producer = producer;
    }

    VideoClip(String songName, double durability) {
        super(songName, durability);
    }

    public void watch() {
        views++;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getViews() {
        return views;
    }

    public boolean isAdvertise() {
        return advertise;
    }

    public void setAdvertise(boolean advertise) {
        this.advertise = advertise;
    }

    @Override
    public String toString() {
        return super.toString()+" Producer: " +producer+" Advertise:" +advertise;
    }
}
