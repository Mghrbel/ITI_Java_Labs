package pyramids_median_quartile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PyramidCSVDAO {
   private String path;
    List<Pyramid> myPyramids;
    public PyramidCSVDAO(String path) {
        this.path = path;
        this.myPyramids = new ArrayList<>();
    }
    public Pyramid createPyramid(String[] col){
        String pharoah = col[0];
        String moden_name = col[2];
        String site = col[4];
        double height = Double.parseDouble(col[7]);
        Pyramid pyramid = new Pyramid(height , moden_name , pharoah , site);
        return pyramid;
    }
    List<String> lines;
    public List<Pyramid> readPyramidFromCSV(){
        try {
            File file = new File(path);
            lines = Files.readAllLines(file.toPath());
        } catch (IOException ex) {
            Logger.getLogger(PyramidCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int pyramidIndex = 1; pyramidIndex < lines.size(); pyramidIndex++){
            String line = lines.get(pyramidIndex);
            String[] fields = line.split(",");
            if (fields[7]==null || fields[7].equals("") || fields[7].isEmpty() || fields[7].equals("0")){
                continue;
            }else{
                myPyramids.add(createPyramid(fields));
            }
        }
        return myPyramids;
    }    
}
