import javax.sound.midi.*;

public class NoteUtils {
    public static void addNote(Track track, int pitch, int start, int duration, int velocity) throws Exception {
        ShortMessage on = new ShortMessage(ShortMessage.NOTE_ON, 0, pitch, velocity);
        ShortMessage off = new ShortMessage(ShortMessage.NOTE_OFF, 0, pitch, 0);
        track.add(new MidiEvent(on, start));
        track.add(new MidiEvent(off, start + duration));
    }
}