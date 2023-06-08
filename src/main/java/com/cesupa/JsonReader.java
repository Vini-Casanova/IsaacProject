package com.cesupa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    static private final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Produto> readFileAndPopulate(String absolutePath)throws IOException{
        List<Produto> userList = null;
        // Read JSON file and map it to a List of UserData objects
        File file = new File(absolutePath);
        userList = objectMapper.readValue(file, new TypeReference<List<Produto>>() {});

        if(userList.isEmpty()){
            return null;
        }
        return userList;
    }

}
