package util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Graph;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class JsonHandler {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static List<Graph> readGraphs(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            JsonObject obj = gson.fromJson(reader, JsonObject.class);
            JsonArray graphsArray = obj.getAsJsonArray("graphs");
            Type listType = new TypeToken<List<Graph>>() {}.getType();
            return gson.fromJson(graphsArray, listType);
        } catch (IOException e) {
            throw new RuntimeException("Error reading input file: " + e.getMessage());
        }
    }

    public static void writeResults(String filePath, List<MSTReport> results) {
        try (Writer writer = new FileWriter(filePath)) {
            JsonObject root = new JsonObject();
            root.add("results", gson.toJsonTree(results));
            gson.toJson(root, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error writing output file: " + e.getMessage());
        }
    }
}