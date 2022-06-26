package Tasks;


import Workers.Worker;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Task1 {
    public static void main(String[] args) throws IOException {
        HashMap<String, FileWriter> writers = new HashMap<>();
        HashMap<String, FileReader> readers = new HashMap<>();
        String prefixPath = "src/";
        String[] fileName = {"worker"};
        String[] pathArray = new String[fileName.length];
        String extensionOfFile = ".xml";
        StringBuffer buffer = new StringBuffer();
        ObjectMapper mapper = new XmlMapper();
        FileWriter fileWriter;
        FileReader fileReader;
        for(int i = 0; i < 1; i++) {
            buffer.append(prefixPath);
            buffer.append(fileName[i]);
            buffer.append(extensionOfFile);
            pathArray[i] = buffer.toString();
            buffer.delete(0, buffer.length());
        }
        for (int i = 0; i < pathArray.length; i++) {
            fileWriter = new FileWriter(pathArray[i]);
            writers.put(fileName[i], fileWriter);
        }
        for (int i = 0; i < pathArray.length; i++) {
            fileReader = new FileReader(pathArray[i]);
            readers.put(fileName[i], fileReader);
        }

        Worker worker = new Worker("Ivan", "Ivanov", "Ivanovich", 35, 50000);

        mapper.writeValue(writers.get("worker"), worker);

        worker = mapper.readValue(readers.get("worker"), Worker.class);

        System.out.println(worker.toString());

    }
}