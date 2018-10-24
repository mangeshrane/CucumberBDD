package Utils;

public class ResourceProvider {

    public String getResource(String filename){
        ClassLoader loader = getClass().getClassLoader();
        String file = loader.getResource(filename).getFile();
        return file;
    }
}
