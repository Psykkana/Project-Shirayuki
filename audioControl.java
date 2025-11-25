import java.io.File;
import javax.sound.sampled.*;


public class audioControl {
        
    private Clip bgm;
    private boolean playing = false;
    private String location;

    public audioControl(String location) {
        this.location = location;
        try {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(location));
                bgm = AudioSystem.getClip();
                bgm.open (audioInput);
            } catch (Exception e) {
                System.out.println("DEBUG: Error playing audio (bgm):  " + e.getMessage());
            }
    }

    public void start() {           
        if (!playing) {
            bgm.loop(bgm.LOOP_CONTINUOUSLY);
            bgm.start();
            playing = true;            
        }

    }

    public void stop() {
        if (bgm != null && playing) {
            bgm.stop();
            playing = false;
        }        
    }

    public void toggle() {
        if (playing) {
            stop();
            playing = false;
        } else {
            start();
            playing = true;
        }
    }
}
