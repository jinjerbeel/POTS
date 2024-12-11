package InventoryManager;

import java.io.*;
import java.util.ArrayList;

public class FileManager<T> extends AbstractFileHandler<T> {

    public FileManager(String filePath) {
        super(filePath);
    }

    @Override
    public T parseLine(String line, Class<T> clazz) {
        // Default implementation uses the logic from AbstractFileHandler
        return defaultParseLine(line, clazz);
    }
    
    public void read(ArrayList<T> objectList, Class<T> clazz) {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    T object = parseLine(line, clazz);
                    if (object != null) {
                        objectList.add(object);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(ArrayList<T> objects) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath()))) {
            for (T obj : objects) {
                writer.write(obj.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
