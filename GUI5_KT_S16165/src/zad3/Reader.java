package zad3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	int counter = 0;
	Object[][] file_data;
	
	public Reader(){
		String csvFile = "bin\\zad3\\books\\info.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<Object> lines = new ArrayList<Object>();
        
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	counter++;
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                lines.add(country[0]);
                lines.add(country[1]);
                lines.add(country[2]);
            //    System.out.println(country[0]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        file_data = new String[counter][3];
        Object[] help = lines.toArray();
        for(int i=0; i<counter; i++){
        	file_data[i][0] = help[3*i];
        	file_data[i][1] = help[(3*i)+1];
        	file_data[i][2] = help[(3*i)+2];
        	System.out.println(file_data[i][0] + " " + file_data[i][1] + " " + file_data[i][2]);
        }
        
	}
}
