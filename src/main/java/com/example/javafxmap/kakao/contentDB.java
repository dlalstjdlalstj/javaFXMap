//지역 코드 안됨(카카오 망함)
//댕댕여지도
//package com.example.javafxmap;
//
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.io.BufferedReader;
//import java.io.IOException;
//public class contentDB {
//
//
//    public class ApiExplorer {
//        public static void main(String[] args) throws IOException {
//            StringBuilder urlBuilder = new StringBuilder("http://www.pettravel.kr/api/detailSeqPart.do"); /*URL*/
//            urlBuilder.append("?" + URLEncoder.encode("areaCode“,"UTF-8") + "+ URLEncoder.encode(”AC01", "UTF-8")); /*지역 코드*/
//                    urlBuilder.append("&" + URLEncoder.encode("contentNum","UTF-8") + "=" + URLEncoder.encode("2", "UTF-8")); /*콘텐츠 번호*/
//            URL url = new URL(urlBuilder.toString());
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Content-type", "application/json");
//            System.out.println("Response code: " + conn.getResponseCode());
//            BufferedReader rd;
//            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            } else {
//                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//            }
//            StringBuilder sb = new StringBuilder();
//            String line;
//            while ((line = rd.readLine()) != null) {
//                sb.append(line);
//            }
//            rd.close();
//            conn.disconnect();
//            System.out.println(sb.toString());
//        }
//    }
//}
