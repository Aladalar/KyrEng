package engine.meta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import engine.meta.objects.MetaSounds;

public class AudioMeta {

    String path;
    List<MetaSounds> sounds;
    public AudioMeta(String path) {
        _construct(path);
    }

    public AudioMeta(List<MetaSounds> sounds) {
        this.sounds = sounds;
    }

    
    private void _construct(String path){
        try(FileReader fr = new FileReader(path)){
            AudioMeta gson = new Gson().fromJson(fr, AudioMeta.class);
            this.sounds = gson.sounds;
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "AudioMeta [path=" + path + ", sounds=" + sounds + "]";
    }

    
}
