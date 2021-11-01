package com.bandtec.mais.consulta.utils;

public class StrFormat {

    public static String toTitledCase(String str){
        // CLASSE PARA ALTERAR A PRIMEIRA LETRA DA PALAVRA PARA MAISCULO
        try {
            String[] words = str.split("\\s");
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1).toLowerCase());
                sb.append(" ");
            }

            return sb.toString();
        } catch (Exception e) {
            System.out.println("ERRO AO REESCREVER MENSAGEM: " + e.getMessage());
            return "";
        }

    }
}
