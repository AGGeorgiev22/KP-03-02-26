import javax.sound.midi.*;

public class MidiPlayer {
    public static final int TRIPLET = 8;
    public static final int QUARTER = 24;
    public static final int HALF = 48;
    public static final int WHOLE = 96;

    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;

    public MidiPlayer() throws Exception {
        sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequence = new Sequence(Sequence.PPQ, 24);
        track = sequence.createTrack();
    }

    public void setTempo(int tempoBpm) throws Exception {
        sequencer.setTempoInBPM(tempoBpm);
    }

    public void setInstrument(int channel, int instrument) throws Exception {
        ShortMessage sm = new ShortMessage();
        sm.setMessage(ShortMessage.PROGRAM_CHANGE, channel, instrument, 0);
        track.add(new MidiEvent(sm, 0));
    }

    public void addNote(Note note, long tick, int channel) throws Exception {
        ShortMessage on = new ShortMessage();
        on.setMessage(ShortMessage.NOTE_ON, channel, note.getPitch(), note.getVelocity());
        track.add(new MidiEvent(on, tick));

        ShortMessage off = new ShortMessage();
        off.setMessage(ShortMessage.NOTE_OFF, channel, note.getPitch(), 0);
        track.add(new MidiEvent(off, tick + note.getDuration()));
    }

    public void play() throws Exception {
        sequencer.setSequence(sequence);
        sequencer.start();

        while (sequencer.isRunning()) {
            Thread.sleep(100);
        }

        sequencer.close();
    }
    
    public void stop() {
        if (sequencer != null && sequencer.isOpen()) {
            sequencer.stop();
            sequencer.close();
        }
    }
}
