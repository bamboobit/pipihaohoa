package com.pipihaohao.demo.utils;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.AnonymousIpResponse;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.Location;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

/**
 * @description:通过HttpServletRequest获取位置信息
 * MMDB即Maxmind DB，是一个设计用于存储IPv4和IPv6的数据信息的数据库，mmdb文件是一个二进制格式的文件，
 * 它使用一个二分查找树加速IP信息的查询。
 * @author: xfh
 * @create: 2019-08-19 17:21
 **/

@Component
public class IpToLocationUtils {
    private static DatabaseReader dbReader = null;

    static {
        readDBFile();
    }


    public static void readDBFile() {
        try {
            File database =new ClassPathResource("static/GeoLite2-City.mmdb").getFile();
            dbReader = new DatabaseReader.Builder(database).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Location getLocationByIP(HttpServletRequest request) throws Exception {
        String ip = getRequestIP(request);
        CityResponse response = dbReader.city(InetAddress.getByName(ip));
        AnonymousIpResponse anonymousIpResponse = dbReader.anonymousIp(InetAddress.getByName(ip));
        CountryResponse countryResponse = dbReader.country(InetAddress.getByName(ip));
        return response.getLocation();
    }

    private static String getRequestIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0];
        }
        return ip;
    }

}
