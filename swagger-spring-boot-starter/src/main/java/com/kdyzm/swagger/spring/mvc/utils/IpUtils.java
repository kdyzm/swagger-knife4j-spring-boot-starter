package com.kdyzm.swagger.spring.mvc.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author kdyzm
 * @date 2021/7/6
 */
@Slf4j
public class IpUtils {

    public static String getHostIP() {
        InetAddress ip4 = null;
        try {
            ip4 = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            log.info("get host ip faild",e);
            return "127.0.0.1";
        }
        return ip4.getHostAddress();
    }
}
