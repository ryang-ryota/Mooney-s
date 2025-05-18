# Mooney's Book Store

## 概要

小規模な書店の業務を効率化するためのWebアプリケーションです。Spring Boot フレームワークを使用して開発された本システムでは、発注の作成から管理まで一貫して行うことができます。

## 機能

- 書籍の管理（登録・編集・検索）
- 在庫管理
- 発注（仕入れ）管理
- ~~納品（入荷）処理~~
- ~~店頭販売管理~~
- ~~顧客からの取り寄せ注文受付~~
- ~~返品管理~~
- ~~各種帳票・レポート出力~~

## 技術スタック

| 項目           | 技術・ツール         |
|----------------|----------------------|
| バックエンド   | Spring Boot          |
| テンプレートエンジン   | Thymeleaf            |
| データアクセス | MyBatis              |
| DB   | PostgreSQL           |
| ビルドツール   | Maven        |
| セキュリティ   | Spring Security |
| 開発言語       | Java                 |

---

## システム構成

- MVC
- Controller → Service → Repository → Database
- Thymeleafによるサーバーサイドレンダリング

---

## 画面イメージ

![image](https://github.com/user-attachments/assets/c3c39dde-bc3b-4c88-824d-448a845504e2)

---



