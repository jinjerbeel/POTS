package assignmentdecsix.InventoryManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractFileHandler<T> {

    protected String filePath;

    public AbstractFileHandler(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    // Abstract methods to enforce implementation in subclasses if needed
    public abstract T parseLine(String line, Class<T> clazz);

    // Common helper methods that subclasses and FileManager can use
    protected T defaultParseLine(String line, Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            T object = constructor.newInstance();

            String[] parts = line.split(",");
            Field[] fields = clazz.getDeclaredFields();

            for (int i = 0; i < parts.length; i++) {
                if (i < fields.length) {
                    Field field = fields[i];
                    field.setAccessible(true);

                    if (field.getType().equals(ArrayList.class)) {
                        String value = parts[i].trim();
                        if (value.isEmpty()) {
                            field.set(object, new ArrayList<String>());
                        } else {
                            ArrayList<String> list = new ArrayList<>(Arrays.asList(value.split(";")));
                            field.set(object, list);
                        }
                    } else {
                        Object value = parseValue(field.getType(), parts[i].trim());
                        field.set(object, value);
                    }
                }
            }

            return object;
        } catch (Exception e) {
            System.err.println("Error parsing line: " + line);
            e.printStackTrace();
            return null;
        }
    }

    protected Object parseValue(Class<?> type, String value) {
        if (value.isEmpty()) {
            return null;
        }
        if (type == int.class || type == Integer.class) {
            return Integer.parseInt(value);
        } else if (type == double.class || type == Double.class) {
            return Double.parseDouble(value);
        }
        return value;
    }
}
