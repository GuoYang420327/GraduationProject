package com.gy.graduationproject.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BilibiliCoverFetcher {

    private static final String API_URL = "https://api.bilibili.com/x/web-interface/view?bvid=";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 根据BV号获取视频封面地址
     *
     * @param bvId 视频的BV号
     * @return 封面图片地址
     * @throws IOException 如果网络请求或解析失败
     */
    public static String getCoverUrl(String bvId) throws IOException {
        try {
            String requestUrl = API_URL + bvId;

            // 发起HTTP请求
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                return null;
            }

            // 读取响应内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // 解析JSON数据
            JsonNode rootNode = objectMapper.readTree(response.toString());
            int code = rootNode.get("code").asInt();
            if (code != 0) {
                return null;
            }

            JsonNode dataNode = rootNode.get("data");
            return dataNode.get("pic").asText();  // 返回封面URL
        } catch (Exception e) {
            return null;
        }
    }
}
