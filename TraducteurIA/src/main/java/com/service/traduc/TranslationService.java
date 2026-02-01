package com.service.traduc;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;

@Path("translate")
public class TranslationService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response translate(String requestBody) {
        try {
            JSONObject inputJson = new JSONObject(requestBody);
            String inputText = inputJson.optString("inputText", "");

            if (inputText.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"error\": \"Input text is missing\"}")
                        .header("Access-Control-Allow-Origin", "*") // Ajout CORS
                        .build();
            }

            Translator translator = new Translator();
            String translatedText = translator.translate(inputText);

            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("translatedText", translatedText);

            // Retour avec les headers de sécurité pour Chrome
            return Response.ok(jsonResponse.toString(), MediaType.APPLICATION_JSON)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "POST, OPTIONS")
                    .header("Access-Control-Allow-Headers", "Content-Type")
                    .build();

        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Invalid request: " + e.getMessage() + "\"}")
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        }
    }
    
    // Nécessaire pour les requêtes "Preflight" de Chrome
    @OPTIONS
    public Response getOptions() {
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type")
                .build();
    }
}