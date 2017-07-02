import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Sound
{

	public static Clip audioClip;

	
	public static void stop()
	{
		audioClip.stop();
	}
	
	public static void play(String audioFilePath)
	{
		try
		{
			File audioFile = new File(audioFilePath);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);
			audioClip.start();
		}

		catch (Exception err)
		{
			System.out.println("1. " + err);
		}
	}


}

