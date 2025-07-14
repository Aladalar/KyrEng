package engine.enums;

public enum Paths {
    
    /* Basic files */
    SCENE("scene/"),
    ENTITY("entity/"),
    IMAGE("images/"),
    AUDIO("audio/");
    
    private final static String ROOT = "/assets/";
    private final String relativePath;

    public String getRelativePath() {
        return relativePath.replace("\\", "/");
    }

    public String getRelativePath(String name) {
        return (relativePath+name).replace("\\", "/");
    }

    Paths(String relativePath){
        this.relativePath = System.getProperty("user.dir") + ROOT + relativePath;
    }

}
