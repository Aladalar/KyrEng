package engine.meta;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MetaPaths {

    private final String ROOT = "assets";

    public String sceneJSON(String sceneName){
        return Paths.get(ROOT, sceneName + ".json").normalize().toString();
    };
    
    public String getAsset(String relativePath){
        return Paths.get(ROOT, relativePath).normalize().toString();
    };

    public boolean isValid(String pathString){
        return Files.exists(Paths.get(pathString));
    }

    public java.io.Reader openReader(String pathString) throws FileNotFoundException{
        return new InputStreamReader(new FileInputStream(Paths.get(pathString).toFile()), StandardCharsets.UTF_8);
    }
}