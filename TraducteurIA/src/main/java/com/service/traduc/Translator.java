package com.service.traduc;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.Content;
import com.google.genai.types.Part;

public class Translator {
	private final String API_KEY = "AIzaSyAdLgeE4yj0X-717AJ2w0rD2WTvpLpc7CA";

    public String translate(String text) {
        if (API_KEY == null || API_KEY.isEmpty()) {
            return "Erreur : La variable d'environnement GEMINI_API_KEY est manquante.";
        }
        try {
            Client client = Client.builder().apiKey(API_KEY).build();

            GenerateContentConfig config = GenerateContentConfig.builder()
                .systemInstruction(Content.fromParts(Part.fromText("Translate only to Moroccan Darija dialect using Arabic script.")))
                .temperature(1.0f)                  
                .build();

            try {
                GenerateContentResponse response = client.models.generateContent("gemini-3-flash-preview", text, config);
                
                return response.text(); 
                
            } catch (Exception e) {
                if (e.getMessage().contains("429")) {
                    return "Désolé, l'IA fait une petite pause (Quota atteint). Réessayez dans 1 minute !";
                }
                throw e; 
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur technique : " + e.getMessage();
        }
    }
}
