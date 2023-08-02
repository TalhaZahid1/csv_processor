import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String CSV_FILE_PATH
            = "/Volumes/Untitled/personal/csv_processor/csv_data.csv";

    public static void main(String args[]){
        System.out.println("Read All Data at Once and Hide the Header also \n");
        List<MappingObject> mappingObjects = readAllDataAtOnce(CSV_FILE_PATH);
        System.out.println("_______________________________________________");

        for(MappingObject mappingObject: mappingObjects){
            System.out.print(mappingObject.getId() + "\t" + mappingObject.getName());
            System.out.println();
        }
    }

    public static List<MappingObject> readAllDataAtOnce(String file)
    {
        try {
            List<MappingObject> mappingObjects = new ArrayList<>();
            // Create an object of filereader class
            // with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object
            // and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .build();
            List<String[]> allData = csvReader.readAll();

            for(int i=0; i<allData.size(); i++){
                MappingObject mappingObject = new MappingObject();
                String[] cell = allData.get(i);
                mappingObject.setId(cell[0]);
                mappingObject.setName(cell[1]);
                mappingObjects.add(mappingObject);
            }

            return mappingObjects;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
