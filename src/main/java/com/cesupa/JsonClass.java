package com.cesupa;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonClass  {
    private JSONObject data;

    public JsonDataManipulator(String filePath) {
        data = readJsonFile(filePath);
    }

    private JSONObject readJsonFile(String filePath) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            return (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new JSONObject();
    }

    public void saveJsonFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addData(String key, Object value) {
        data.put(key, value);
    }

    public Object getData(String key) {
        return data.get(key);
    }

    public void updateData(String key, Object newValue) {
        data.put(key, newValue);
    }

    public void removeData(String key) {
        data.remove(key);
    }

    public static void main(String[] args) {
        String filePath = "data.json";

        // Create an instance of the data manipulator
        JsonDataManipulator dataManipulator = new JsonDataManipulator(filePath);

        // Add new data
        dataManipulator.addData("name", "John Doe");
        dataManipulator.addData("age", 25);
        dataManipulator.addData("city", "New York");

        // Update existing data
        dataManipulator.updateData("age", 26);

        // Remove data
        dataManipulator.removeData("city");

        // Get and print data
        Object name = dataManipulator.getData("name");
        Object age = dataManipulator.getData("age");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        // Save the modified data back to the JSON file
        dataManipulator.saveJsonFile(filePath);
    }
}
