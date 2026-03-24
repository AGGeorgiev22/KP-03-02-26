public class LunnaSonata {

    private static final int T  = MidiPlayer.TRIPLET;
    private static final int Q  = MidiPlayer.QUARTER;
    private static final int H  = MidiPlayer.HALF;
    private static final int W  = MidiPlayer.WHOLE;
    private static final int DH = H + Q;

    private static final int PPP = 25;
    private static final int PP  = 35;
    private static final int P   = 45;
    private static final int MP  = 55;
    private static final int MF  = 65;
    private static final int F   = 75;
    private static final int FF  = 85;

    private static final int CH_BASS = 0;
    private static final int CH_ARP  = 1;
    private static final int CH_MEL  = 2;

    public static void main(String[] args) {
        try {
            MidiPlayer player = new MidiPlayer();
            player.setInstrument(CH_BASS, 0);
            player.setInstrument(CH_ARP, 0);
            player.setInstrument(CH_MEL, 0);
            player.setTempo(46);

            buildScore(player);
            player.play();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void buildScore(MidiPlayer player) throws Exception {
        long tick = 0;
        tick = introduction(player, tick);
        tick = firstTheme(player, tick);
        tick = trans1(player, tick);
        tick = secondTheme(player, tick);
        tick = development(player, tick);
        tick = recapitulation(player, tick);
        run(player, tick);
    }

    private static long introduction(MidiPlayer player, long tick) throws Exception {
        for (int i = 0; i < 5; i++) {
            bass(player, tick, 37, 49, W, PP);
            tick = arp(player, tick, 56, 61, 64, 4, PP);
        }
        return tick;
    }

    private static long firstTheme(MidiPlayer player, long tick) throws Exception {
        bass(player, tick, 37, 49, W, PP);
        mel(player, tick, 68, W, P);
        tick = arp(player, tick, 56, 61, 64, 4, PP);

        bass(player, tick, 35, 47, W, PP);
        mel(player, tick, 68, H, P);
        mel(player, tick + H, 69, H, P);
        tick = arp(player, tick, 56, 61, 64, 4, PP);

        bass(player, tick, 33, 45, W, PP);
        mel(player, tick, 71, W, P);
        tick = arp(player, tick, 57, 61, 64, 4, PP);

        bass(player, tick, 42, -1, W, PP);
        mel(player, tick, 69, H, P);
        mel(player, tick + H, 68, H, P);
        tick = arp(player, tick, 57, 61, 66, 4, PP);

        bass(player, tick, 44, -1, W, PP);
        mel(player, tick, 68, H, P);
        mel(player, tick + H, 66, H, P);
        tick = arp(player, tick, 56, 59, 64, 4, PP);

        bass(player, tick, 44, -1, W, PP);
        mel(player, tick, 64, H, P);
        mel(player, tick + H, 63, H, P);
        tick = arp(player, tick, 56, 59, 63, 4, PP);

        bass(player, tick, 37, 49, W, PP);
        mel(player, tick, 64, DH, P);
        mel(player, tick + DH, 63, Q, P);
        tick = arp(player, tick, 56, 61, 64, 4, PP);

        bass(player, tick, 37, 49, W, PP);
        mel(player, tick, 61, W, P);
        tick = arp(player, tick, 56, 61, 64, 4, PP);

        bass(player, tick, 42, -1, W, PP);
        mel(player, tick, 61, H, P);
        mel(player, tick + H, 57, H, P);
        tick = arp(player, tick, 54, 57, 61, 4, PP);

        bass(player, tick, 44, -1, W, PP);
        mel(player, tick, 59, W, P);
        tick = arp(player, tick, 56, 59, 63, 4, PP);

        bass(player, tick, 37, 49, W, PP);
        mel(player, tick, 61, W, P);
        tick = arp(player, tick, 56, 61, 64, 4, PP);

        return tick;
    }

    private static long trans1(MidiPlayer player, long tick) throws Exception {
        bass(player, tick, 37, 49, W, PP);
        mel(player, tick, 68, W, MP);
        tick = arp(player, tick, 56, 61, 64, 4, P);

        bass(player, tick, 38, 50, W, PP);
        mel(player, tick, 68, H, MP);
        mel(player, tick + H, 66, H, MP);
        tick = arp(player, tick, 56, 59, 62, 4, P);

        bass(player, tick, 40, 52, W, PP);
        mel(player, tick, 68, W, MP);
        tick = arp(player, tick, 56, 59, 64, 4, P);

        bass(player, tick, 35, 47, W, PP);
        mel(player, tick, 66, H, MP);
        mel(player, tick + H, 68, H, MP);
        tick = arp(player, tick, 54, 59, 63, 4, P);

        bass(player, tick, 40, 52, W, PP);
        mel(player, tick, 71, W, MP);
        tick = arp(player, tick, 56, 59, 64, 4, P);

        bass(player, tick, 33, 45, W, PP);
        mel(player, tick, 73, H, MP);
        mel(player, tick + H, 71, H, MP);
        tick = arp(player, tick, 57, 61, 64, 4, P);

        bass(player, tick, 35, 47, W, PP);
        mel(player, tick, 69, H, MP);
        mel(player, tick + H, 68, H, MP);
        tick = arp(player, tick, 54, 59, 63, 4, P);

        bass(player, tick, 40, 52, W, PP);
        mel(player, tick, 68, W, MP);
        tick = arp(player, tick, 56, 59, 64, 4, P);

        return tick;
    }

    private static long secondTheme(MidiPlayer player, long tick) throws Exception {
        bass(player, tick, 40, 52, W, P);
        mel(player, tick, 71, W, MP);
        tick = arp(player, tick, 56, 59, 64, 4, PP);

        bass(player, tick, 40, 52, W, P);
        mel(player, tick, 73, H, MP);
        mel(player, tick + H, 71, H, MP);
        tick = arp(player, tick, 57, 61, 64, 4, PP);

        bass(player, tick, 42, 54, W, P);
        mel(player, tick, 69, H, MP);
        mel(player, tick + H, 68, H, MP);
        tick = arp(player, tick, 57, 61, 66, 4, PP);

        bass(player, tick, 35, 47, W, P);
        mel(player, tick, 66, W, MP);
        tick = arp(player, tick, 54, 59, 63, 4, PP);

        bass(player, tick, 40, 52, W, P);
        mel(player, tick, 64, H, MP);
        mel(player, tick + H, 68, H, MP);
        tick = arp(player, tick, 56, 59, 64, 4, PP);

        bass(player, tick, 37, 49, W, P);
        mel(player, tick, 68, H, MP);
        mel(player, tick + H, 64, H, MP);
        tick = arp(player, tick, 56, 61, 64, 4, PP);

        bass(player, tick, 35, 47, W, P);
        mel(player, tick, 63, W, MP);
        tick = arp(player, tick, 54, 59, 63, 4, PP);

        bass(player, tick, 40, 52, W, P);
        mel(player, tick, 64, W, P);
        tick = arp(player, tick, 56, 59, 64, 4, PP);

        bass(player, tick, 40, 52, W, P);
        mel(player, tick, 59, H, P);
        mel(player, tick + H, 64, H, P);
        tick = arp(player, tick, 56, 59, 64, 4, PP);

        bass(player, tick, 35, 47, W, P);
        mel(player, tick, 63, W, P);
        tick = arp(player, tick, 54, 57, 63, 4, PP);

        bass(player, tick, 40, 52, W, P);
        mel(player, tick, 64, W, P);
        tick = arp(player, tick, 56, 59, 64, 4, PP);

        return tick;
    }

    private static long development(MidiPlayer player, long tick) throws Exception {
        bass(player, tick, 37, 49, W, MP);
        mel(player, tick, 64, H, MF);
        mel(player, tick + H, 68, H, MF);
        tick = arp(player, tick, 56, 61, 64, 4, MP);

        bass(player, tick, 48, -1, W, MP);
        mel(player, tick, 69, H, MF);
        mel(player, tick + H, 68, H, MF);
        tick = arp(player, tick, 57, 60, 66, 4, MP);

        bass(player, tick, 39, 51, W, MP);
        mel(player, tick, 66, H, MF);
        mel(player, tick + H, 69, H, MF);
        tick = arp(player, tick, 54, 57, 63, 4, MP);

        bass(player, tick, 44, -1, W, MF);
        mel(player, tick, 71, W, F);
        tick = arp(player, tick, 56, 60, 63, 4, MF);

        bass(player, tick, 37, 49, W, MF);
        mel(player, tick, 73, H, F);
        mel(player, tick + H, 71, H, F);
        tick = arp(player, tick, 56, 61, 64, 4, MF);

        bass(player, tick, 42, 54, W, MF);
        mel(player, tick, 69, H, F);
        mel(player, tick + H, 68, H, F);
        tick = arp(player, tick, 57, 61, 66, 4, MF);

        bass(player, tick, 38, 50, W, MF);
        mel(player, tick, 66, H, F);
        mel(player, tick + H, 64, H, F);
        tick = arp(player, tick, 54, 57, 62, 4, MF);

        bass(player, tick, 44, -1, W, F);
        mel(player, tick, 75, W, FF);
        tick = arp(player, tick, 56, 60, 63, 4, F);

        bass(player, tick, 32, 44, W, F);
        mel(player, tick, 76, H, FF);
        mel(player, tick + H, 75, H, FF);
        tick = arp(player, tick, 56, 59, 64, 4, F);

        bass(player, tick, 37, 49, W, F);
        mel(player, tick, 73, W, FF);
        tick = arp(player, tick, 56, 61, 64, 4, F);

        bass(player, tick, 42, -1, W, MF);
        mel(player, tick, 69, H, F);
        mel(player, tick + H, 66, H, MF);
        tick = arp(player, tick, 54, 57, 61, 4, MF);

        bass(player, tick, 44, -1, W, MP);
        mel(player, tick, 63, H, MF);
        mel(player, tick + H, 64, H, MF);
        tick = arp(player, tick, 56, 59, 63, 4, MP);

        bass(player, tick, 37, 49, W, MP);
        mel(player, tick, 64, W, MP);
        tick = arp(player, tick, 56, 61, 64, 4, MP);

        return tick;
    }

    private static long recapitulation(MidiPlayer player, long tick) throws Exception {
        bass(player, tick, 37, 49, W, PP);
        mel(player, tick, 68, W, P);
        tick = arp(player, tick, 56, 61, 64, 4, PP);

        bass(player, tick, 35, 47, W, PP);
        mel(player, tick, 68, H, P);
        mel(player, tick + H, 69, H, P);
        tick = arp(player, tick, 56, 61, 64, 4, PP);

        bass(player, tick, 33, 45, W, PP);
        mel(player, tick, 71, W, P);
        tick = arp(player, tick, 57, 61, 64, 4, PP);

        bass(player, tick, 42, -1, W, PP);
        mel(player, tick, 69, H, P);
        mel(player, tick + H, 68, H, P);
        tick = arp(player, tick, 57, 61, 66, 4, PP);

        bass(player, tick, 44, -1, W, PP);
        mel(player, tick, 68, H, P);
        mel(player, tick + H, 66, H, P);
        tick = arp(player, tick, 56, 59, 64, 4, PP);

        bass(player, tick, 44, -1, W, PP);
        mel(player, tick, 64, H, P);
        mel(player, tick + H, 63, H, P);
        tick = arp(player, tick, 56, 59, 63, 4, PP);

        bass(player, tick, 37, 49, W, PP);
        mel(player, tick, 64, DH, P);
        mel(player, tick + DH, 63, Q, P);
        tick = arp(player, tick, 56, 61, 64, 4, PP);

        bass(player, tick, 37, 49, W, PP);
        mel(player, tick, 61, W, P);
        tick = arp(player, tick, 56, 61, 64, 4, PP);

        bass(player, tick, 37, 49, W, PP);
        mel(player, tick, 68, W, MP);
        tick = arp(player, tick, 56, 61, 64, 4, PP);

        bass(player, tick, 37, 49, W, PP);
        mel(player, tick, 69, H, MP);
        mel(player, tick + H, 68, H, MP);
        tick = arp(player, tick, 57, 61, 64, 4, PP);

        bass(player, tick, 42, 54, W, PP);
        mel(player, tick, 66, H, MP);
        mel(player, tick + H, 64, H, MP);
        tick = arp(player, tick, 57, 61, 66, 4, PP);

        bass(player, tick, 44, -1, W, PP);
        mel(player, tick, 63, W, P);
        tick = arp(player, tick, 56, 59, 63, 4, PP);

        return tick;
    }

    private static long coda(MidiPlayer player, long tick) throws Exception {
        bass(player, tick, 37, 49, W, PP);
        mel(player, tick, 64, W, P);
        tick = arp(player, tick, 56, 61, 64, 4, PP);

        bass(player, tick, 33, 45, W, PP);
        mel(player, tick, 64, H, P);
        mel(player, tick + H, 61, H, P);
        tick = arp(player, tick, 57, 61, 64, 4, PP);

        bass(player, tick, 42, -1, W, PP);
        mel(player, tick, 61, W, P);
        tick = arp(player, tick, 54, 57, 61, 4, PP);

        bass(player, tick, 44, -1, W, PP);
        mel(player, tick, 59, H, P);
        mel(player, tick + H, 63, H, P);
        tick = arp(player, tick, 56, 59, 63, 4, PP);

        bass(player, tick, 37, 49, W, PP);
        mel(player, tick, 64, W, PP);
        tick = arp(player, tick, 56, 61, 64, 4, PP);

        bass(player, tick, 42, -1, H, PP);
        mel(player, tick, 61, H, PP);
        tick = arp(player, tick, 54, 57, 61, 2, PP);
        player.addNote(new Note(44, H, PP), tick, CH_BASS);
        mel(player, tick, 63, H, PP);
        tick = arp(player, tick, 56, 59, 63, 2, PP);

        bass(player, tick, 37, 49, W, PPP);
        mel(player, tick, 61, W, PP);
        tick = arp(player, tick, 56, 61, 64, 4, PPP);

        bass(player, tick, 37, 49, W, PPP);
        tick = arp(player, tick, 56, 61, 64, 4, PPP);

        player.addNote(new Note(37, W, PPP), tick, CH_BASS);
        player.addNote(new Note(49, W, PPP), tick, CH_BASS);
        player.addNote(new Note(56, W, PPP), tick, CH_ARP);
        player.addNote(new Note(61, W, PPP), tick, CH_ARP);
        player.addNote(new Note(64, W, PPP), tick, CH_MEL);
        tick += W;

        return tick;
    }

    private static void bass(MidiPlayer p, long tick, int note1, int note2, int dur, int vel)
            throws Exception {
        p.addNote(new Note(note1, dur, vel), tick, CH_BASS);
        if (note2 > 0) {
            p.addNote(new Note(note2, dur, vel), tick, CH_BASS);
        }
    }

    private static void mel(MidiPlayer p, long tick, int pitch, int dur, int vel) throws Exception {
        p.addNote(new Note(pitch, dur, vel), tick, CH_MEL);
    }

    private static long arp(MidiPlayer p, long tick, int low, int mid, int high, int repeats, int vel)
            throws Exception {
        for (int i = 0; i < repeats; i++) {
            p.addNote(new Note(low, T, vel), tick, CH_ARP);
            p.addNote(new Note(mid, T, vel), tick + T, CH_ARP);
            p.addNote(new Note(high, T, vel), tick + 2 * T, CH_ARP);
            tick += 3 * T;
        }
        return tick;
    }
}