package magicwands.utils;

public class ColorConverter{


    public static double convertColorValue(double value){
        if (value <= 0.0D){
            value = -1.0D;
        }
        return value / 255.0D;
    }

}
