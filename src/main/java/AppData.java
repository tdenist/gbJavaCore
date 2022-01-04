import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {

    private String[] header;
    private Integer[][] data;

    public AppData() {
    }

    public void load(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String strTemp;
            ArrayList<Integer[]> arrayListInt = new ArrayList<>();
            header = reader.readLine().split(";");
            while ((strTemp = reader.readLine()) != null){
                String[] strTempArray = strTemp.split(";");
                Integer[] intTempArray = new Integer[strTempArray.length];
                for (int j = 0; j < strTempArray.length; j ++){
                    intTempArray[j] = Integer.parseInt(strTempArray[j]);
                }
                arrayListInt.add(intTempArray);
            }
            data = arrayListInt.toArray(new Integer[][]{{}});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(AppData data, String filePath){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String out;
        out = String.join(";", header);
        for (int i = 0; i < data.length; i++){
            String[] temp = new String[data[i].length];
            for (int j = 0; j < data[i].length; j++ ){
                temp[j] = String.valueOf(data[i][j]);
            }
            out += "\n" + String.join(";", temp);
        }
        return out;
    }
}
