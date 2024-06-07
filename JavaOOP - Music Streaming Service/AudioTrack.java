public class AudioTrack extends Track {

    // Propperties
    private String audioQuality;

    // Constructor
    public AudioTrack(String trackId, String title, int duration, String audioQuality) {
        super(trackId, title, duration);
        this.audioQuality = audioQuality;
    }

    // Getters and Setters
    public String getAudioQuality(){
        return this.audioQuality;
    }

    public void setAudioQuality(String audioQuality){
        this.audioQuality = audioQuality;
    }

    @Override
    public String toString() {
        return
            "AudioTrack {\n" +
                "\ttrackId = '" + this.trackId + "',\n" +
                "\ttitle = '" + this.title + "',\n" +
                "\tduration = " + this.duration + ",\n" +
                "\tplayCount = " + this.playCount + ",\n" +
                "\taudioQuality = " + this.audioQuality +
            "\n}";
    }
}
