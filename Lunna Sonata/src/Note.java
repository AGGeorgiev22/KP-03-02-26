public class Note {
    private final int pitch;
    private final int duration;
    private final int velocity;

    public Note(int pitch, int duration, int velocity) {
        this.pitch = pitch;
        this.duration = duration;
        this.velocity = velocity;
    }

    public int getPitch() {
        return pitch;
    }
    
    public int getDuration() { 
        return duration; 
    }

    public int getVelocity() { 
        return velocity; 
    }
}
