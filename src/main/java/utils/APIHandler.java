/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import dinoModels.SaurioClass;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;


/**
 *
 * @author DAM
 */
public class APIHandler {
    public static Object createSaurio(SaurioClass saurio){
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObject = null;
       
        try  {
            jsonObject = objectMapper.writeValueAsString(saurio);
        }
        catch(Exception e) {
            System.err.print("error al mapear el objeto saurio");
            return 2;
        }
        // realizar una solicitud HTTP a la APISaurio
        HttpResponse<JsonNode> response = Unirest.post("http://127.0.0.1:5000/createSaurio").header("Content-Type", "application/json").body(jsonObject).asJson();
        try { 
             var jsonObject2 = response.getBody().getObject();
          return jsonObject2;}
        catch (Exception e){
        System.out.print(e);}
       
      
        return null;
        
    }
}
