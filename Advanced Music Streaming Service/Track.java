public class Track implements IPlayable {

    // Properties
    protected String trackId;
    protected String title;
    protected int duration; // seconds
    protected int playCount;

    // Constructor
    public Track(String trackId, String title, int duration){
        this.trackId = trackId;
        this.title = title;
        this.duration = duration;
        this.playCount = 0;
    }

    // Getters and Setters
    public String getTrackId(){
        return this.trackId;
    }

    public void setTrackId(String trackId){
        this.trackId = trackId;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getDuration(){
        return this.duration;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    public int getPlayCount(){
        return this.playCount;
    }

    public void incrementPlayCount(){
        this.playCount += 1;
    }

    // Methods
    @Override
    public void play(){
        incrementPlayCount();
        System.out.println("Playing track: " + this.title);
    }
}
