# 🪑 KenFurni — 家具ECサイト

> Spring Boot × Thymeleaf × MySQL で構築した、管理者・ユーザー二面型の家具ECプラットフォーム

---

## ✨ 概要

KenFurni は、一般ユーザーが家具を閲覧・購入できるECサイトと、スタッフが在庫・注文・会員を管理できる管理画面を備えた、フルスタックWebアプリケーションです。

---

## 🛠 技術スタック

| カテゴリ | 技術 |
|---|---|
| バックエンド | Java 17 / Spring Boot / Spring Security |
| テンプレートエンジン | Thymeleaf |
| ORM | Spring Data JPA (Hibernate) |
| データベース | MySQL 8.x |
| ビルドツール | Maven (mvnw) |
| スタイリング | CSS (admin / user / common) |

---

## 📁 ディレクトリ構成

```
src/main/java/com/brexa/kenfurni/
├── config/          # SecurityConfig（管理・ユーザー二重認証）
├── controller/      # 管理側・ユーザー側コントローラー
├── service/         # ビジネスロジック
├── repository/      # Spring Data JPAリポジトリ
├── entity/          # DBエンティティ（M系マスタ / T系トランザクション）
├── dto/             # 画面表示用DTO
└── form/            # フォームバインディング用クラス

src/main/resources/
├── templates/
│   ├── admin/       # 管理画面テンプレート
│   └── user/        # ユーザー画面テンプレート
├── static/css/      # スタイルシート
└── application.properties
```

---

## 🔐 認証・認可

Spring Security により **管理者系** と **ユーザー系** を独立した FilterChain で管理しています。

### 管理者ロール (`/admin/**`)

| ロール | アクセス可能機能 |
|---|---|
| `STAFF_FULL` | 全機能（スタッフ管理含む） |
| `STAFF_CONTRACT` | 商品・カテゴリ管理、発送・在庫 |
| `STAFF_OUTSOURCE` | 会員管理、売上確認、発送・在庫 |
| `STAFF_PART` / `STAFF_OTHER` | 発送・在庫のみ |

### ユーザー (`/top`, `/products/**` etc.)

- 未ログインでも商品閲覧・会員登録可能
- カート・購入・マイページは要ログイン

---

## 🚀 セットアップ

### 前提条件

- Java 17+
- MySQL 8.x
- Maven（または同梱の `mvnw` を使用）

### 手順

```bash
# 1. リポジトリをクローン
git clone https://github.com/EiichiSatou-svg/kenfurni_by_claude_web.git
cd kenfurni_by_claude_web

# 2. DBを作成
mysql -u root -p
CREATE DATABASE kenfurni_database CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

# 3. application.properties を環境に合わせて編集
# src/main/resources/application.properties

# 4. 起動
./mvnw spring-boot:run
```

アプリケーションは `http://localhost:8080` で起動します。

---

## 🌐 主な画面・エンドポイント

| パス | 説明 |
|---|---|
| `/top` | トップ（商品一覧・検索・カテゴリ絞り込み） |
| `/login` | ユーザーログイン |
| `/member/register` | 会員登録 |
| `/member/mypage` | マイページ |
| `/cart` | カート |
| `/purchase/confirm` | 購入確認 |
| `/admin/login` | 管理者ログイン |
| `/admin/menu` | 管理メニュー |
| `/admin/products` | 商品管理 |
| `/admin/members` | 会員管理 |
| `/admin/earnings` | 売上管理 |
| `/admin/stock` | 在庫管理 |
| `/admin/send` | 発送管理 |

---

## ⚙️ 設定ファイル

`src/main/resources/application.properties` の主な設定項目：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/kenfurni_database
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=none
```

> ⚠️ **本番環境では `application.properties` を環境変数に切り替え、パスワードをハードコードしないこと。**

---

## 📝 注意事項

- 現在 `PasswordEncoder` は `NoOpPasswordEncoder`（平文）を使用しています。本番運用前に `BCryptPasswordEncoder` への変更を推奨します。
- DDL自動生成は `none` のため、スキーマは別途適用してください。

---

## 👤 Author

**BREXA Technology Inc.**
