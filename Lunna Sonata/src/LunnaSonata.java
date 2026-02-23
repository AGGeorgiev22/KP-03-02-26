import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class LunnaSonata {
    public static void main(String[] args) throws Exception {
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        Sequence sequence = new Sequence(Sequence.PPQ, 12);
        Track track = sequence.createTrack();

        NoteUtils.addNote(track, 37, 0, 48, 50);
        NoteUtils.addNote(track, 25, 0, 48, 50);

        int tick = 0;
        for (int i = 0; i < 4; i++) {
            NoteUtils.addNote(track, 56, tick, 4, 60); tick += 4;
            NoteUtils.addNote(track, 61, tick, 4, 60); tick += 4;
            NoteUtils.addNote(track, 64, tick, 4, 60); tick += 4;
        }

        sequencer.setSequence(sequence);
        sequencer.setTempoInBPM(50);

        JFrame frame = new JFrame("Moonlight Sonata");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton play = new JButton("Play");
        JButton stop = new JButton("Stop");

        play.addActionListener(e -> sequencer.start());
        stop.addActionListener(e -> {
            sequencer.stop();
            sequencer.setMicrosecondPosition(0);
        });

        frame.add(play);
        frame.add(stop);
        frame.setSize(200, 80);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}