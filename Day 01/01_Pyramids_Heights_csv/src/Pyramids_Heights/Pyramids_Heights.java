package Pyramids_Heights;

import java.util.List;

public class Pyramids_Heights {

    public static void main(String[] args) {  
        PyramidCSVDAO py = new PyramidCSVDAO("F:\\AI\\06- Java development\\pyramids.csv");
        List<Pyramid> myPyramid = py.readPyramidFromCSV();
        myPyramid.forEach(pyr -> 
            System.out.println("Height = " + pyr.getHeight() + ",Modern_name = " + pyr.getModern_name() + ",Pharaoh = " + pyr.getPharaoh() + ",Site = " + pyr.getSite()));
    }
}

