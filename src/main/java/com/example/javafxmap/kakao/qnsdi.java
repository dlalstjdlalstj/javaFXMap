//지역 코드 안됨(카카오 망함)
//댕댕여지도
//package com.example.javafxmap;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.io.BufferedReader;
//import java.io.IOException;
//
//public class qnsdi {
//
//    public class ApiExplorer {
//        public static void main(String[] args) throws IOException {
//            StringBuilder urlBuilder = new StringBuilder("http://www.pettravel.kr/api/listPart.do"); /*URL*/
//            urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//            urlBuilder.append("&" + URLEncoder.encode(“pageBlock","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//                    urlBuilder.append("&" + URLEncoder.encode("partCode“,"UTF-8") + "+ URLEncoder.encode("PC01", "UTF-8")); /*분야 코드*/
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
