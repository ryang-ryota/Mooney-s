package com.example.mooneys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Bootアプリケーションのメインクラス
 */
@SpringBootApplication
public class Mooneys {

    /**
     * アプリケーションのエントリーポイント
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        // Spring Bootアプリケーションを起動
        SpringApplication.run(Mooneys.class, args);
    }

}