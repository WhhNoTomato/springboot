package com.song.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Song on 2017/2/15.
 * 项目启动入口，配置包根路径
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.song")
public class Entry {

    public static void browserUrl(String url){

        //判断是否支持Desktop扩展,如果支持则进行下一步
        if (Desktop.isDesktopSupported()){
            try {
                URI uri = new URI(url);
                Desktop desktop = Desktop.getDesktop(); //创建desktop对象
                //调用默认浏览器打开指定URL
                desktop.browse(uri);

            } catch (URISyntaxException e) {
                e.printStackTrace();

            } catch (IOException e) {
                //如果没有默认浏览器时，将引发下列异常
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        browserUrl("http://localhost:8080/user/index");
        SpringApplication.run(Entry.class, args);
    }
}
