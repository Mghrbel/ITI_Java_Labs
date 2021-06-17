package Pyramids_Heights;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PyramidCSVDAO {
    private final String path;
    List<Pyramid> myPyramids;
    public PyramidCSVDAO(String path) {
        this.path = path;
        this.myPyramids = new ArrayList<>();
    }
    public Pyramid createPyramid(String[] col){
        String pharoah = col[0];
        String moden_name = col[2];
        String site = col[4];
        double height;
        if (col[7] == null || col[7].isEmpty() || " ".equals(col[7])){
            height = 0;
        }else{
            height = Double.parseDouble(col[7]);
        }
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
            myPyramids.add(createPyramid(fields));
        }
        return myPyramids;
    }
}