import java.io.File;
import java.util.ArrayList;

public class Surf{
    private File[] dir;
    private File page;
    private ArrayList<File> history = new ArrayList<>();
    private int historyLoc;

    public Surf(){
        page = new File("/");
        history.add(page);
        historyLoc = 0;
        if (page.isDirectory())
            dir = page.listFiles();
        else
            dir = null;
    }
    public Surf(String path){
        if (! new File(path).exists()) {
            try {
                throw new Exception("File not found");
            } catch (Exception ignored) {}
        }
        page = new File(path);
        history.add(page);
        historyLoc = 0;
        if (page.isDirectory())
            dir = page.listFiles();
        else
            dir = null;
    }

    public void openFile(String path){
        if (! new File(path).exists()) {
            try {
                throw new Exception("File not found");
            } catch (Exception ignored) {}
        }
        page = new File(path);
        history.add(page);
        historyLoc ++;
        if (page.isDirectory())
            dir = page.listFiles();
        else
            dir = null;
    }

    public void openFile(int path){

        if (dir == null || path < -2 || path > dir.length-1) {
            try {
                throw new Exception("File not found");
            } catch (Exception ignored) {}
        }
        if (path == -1){
            if (historyLoc > 0) {
                page = history.get(historyLoc - 1);
                historyLoc --;
            }
        }else if (path == -2){
            if (historyLoc < history.size()-1){
                page = history.get(historyLoc + 1);
                historyLoc ++;
            }
        }else {
            page = dir[path];
            history.add(page);
            historyLoc ++;
        }
        if (page.isDirectory())
            dir = page.listFiles();
        else
            dir = null;
    }

    public File[] listFiles(){
        return dir;
    }

    @Override
    public String toString() {
        return page.toString();
    }
}
