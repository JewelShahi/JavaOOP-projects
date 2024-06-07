public class VideoTrack extends Track {

    // Properties
    private String videoResolution;

    // Constructor
    public VideoTrack(String trackId, String title, int duration, String videoResolution) {
        super(trackId, title, duration);
        this.videoResolution = videoResolution;
    }

    // Getters and Setters
    public String getVideoResolution(){
        return this.videoResolution;
    }

    public void setVideoResolution(String videoResolution){
        this.videoResolution = videoResolution;
    }

    @Override
    public String toString() {
        return
           "VideoTrack {\n" +
              "\ttrackId = '" + this.trackId + "',\n" +
              "\ttitle = '" + this.title + "',\n" +
              "\tduration = " + this.duration + ",\n" +
              "\tplayCount = " + this.playCount + ",\n" +
              "\tvideoResolution = " + this.videoResolution +
           "\n}";
    }
}
