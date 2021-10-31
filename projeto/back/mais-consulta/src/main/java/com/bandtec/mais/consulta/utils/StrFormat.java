package com.bandtec.mais.consulta.utils;

public class StrFormat {

    public static String toTitledCase(String str){
        // CLASSE PARA ALTERAR A PRIMEIRA LETRA DA PALAVRA PARA MAISCULO
        if (str != null || str != "") {
            String[] words = str.split("\\s");
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < words.length; i++){
                sb.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase());
                sb.append(" ");
            }

            return sb.toString();
        }

        return "";
    }
}
