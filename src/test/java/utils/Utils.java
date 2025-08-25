package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void SaveEmployee(String firstName,String middleName,String lastName,String userName,String password,String confirmPassword) throws IOException, ParseException {
        String filePath="./src/test/resources/employee.json";
        JSONParser parser=new JSONParser();
        JSONArray addedArray= (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject obj=new JSONObject();
        obj.put("FirstName",firstName);
        obj.put("MiddleName",middleName);
        obj.put("LastName",lastName);
        obj.put("UserName",userName);
        obj.put("Password",password);
        obj.put("ConfirmPassword",confirmPassword);

        addedArray.add(obj);
        FileWriter writer=new FileWriter(filePath);
        writer.write(addedArray.toJSONString());
        writer.flush();
        writer.close();



    }
    public static JSONObject getUser() throws IOException, ParseException {
        String filePath="./src/test/resources/employee.json";
        JSONParser parser=new JSONParser();
        JSONArray addedArray= (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject lastEmpObject= (JSONObject) addedArray.get(addedArray.size()-1);
        return lastEmpObject;

    }

}
