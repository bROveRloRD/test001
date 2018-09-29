import it.sauronsoftware.jave.*;
import java.io.File;

public class ChangeFormat {
    public static void main(String[] args) throws Exception{
        String path1 = "E:\\Program Files (x86)\\Github\\andon\\ChangeFormat\\src\\test.mp3";
        String path2 = "E:\\Program Files (x86)\\Github\\andon\\ChangeFormat\\src\\result.amr";
        changeMp3toAmr(path1,path2);
    }

    public static void changeMp3toAmr(String sourcePath,String targetPath){
        File source = new File(sourcePath);
        File target = new File(targetPath);
        AudioAttributes audio = new AudioAttributes();
        Encoder encoder = new Encoder();

        audio.setCodec("libamr_wb");
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("amr");
        attrs.setAudioAttributes(audio);

        try{
            encoder.encode(source,target,attrs);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }catch (InputFormatException e){
            e.printStackTrace();
        }catch (EncoderException e){
            e.printStackTrace();
        }
    }

}
