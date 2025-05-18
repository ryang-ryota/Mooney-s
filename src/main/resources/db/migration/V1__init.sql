-- 書籍テーブル
CREATE TABLE book (
    isbn VARCHAR(13) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    publisher VARCHAR(255),
    price NUMERIC(10,2)
);

-- 在庫テーブル
CREATE TABLE stock (
    id SERIAL PRIMARY KEY,
    isbn VARCHAR(13) NOT NULL,
    quantity INTEGER NOT NULL DEFAULT 0,
    shelf_no VARCHAR(50),
    last_received_at DATE,
    CONSTRAINT fk_stock_book FOREIGN KEY (isbn) REFERENCES book(isbn)
);

-- 取引先（仕入先）テーブル
CREATE TABLE supplier (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    contact VARCHAR(100)
);

-- 発注テーブル
CREATE TABLE purchase_order (
    id SERIAL PRIMARY KEY,
    supplier_id INTEGER NOT NULL,
    order_date DATE NOT NULL,
    status VARCHAR(50),
    CONSTRAINT fk_purchase_order_supplier FOREIGN KEY (supplier_id) REFERENCES supplier(id)
);

-- 発注明細テーブル
CREATE TABLE purchase_order_item (
    purchase_order_id INTEGER NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    quantity INTEGER NOT NULL,
    unit_price NUMERIC(10,2),
    PRIMARY KEY (purchase_order_id, isbn),
    CONSTRAINT fk_poitem_po FOREIGN KEY (purchase_order_id) REFERENCES purchase_order(id),
    CONSTRAINT fk_poitem_book FOREIGN KEY (isbn) REFERENCES book(isbn)
);

-- 納品（入荷）テーブル
CREATE TABLE purchase (
    id SERIAL PRIMARY KEY,
    purchase_order_id INTEGER NOT NULL,
    receive_date DATE NOT NULL,
    status VARCHAR(50),
    CONSTRAINT fk_purchase_po FOREIGN KEY (purchase_order_id) REFERENCES purchase_order(id)
);

-- 納品明細テーブル
CREATE TABLE purchase_item (
    purchase_id INTEGER NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    quantity INTEGER NOT NULL,
    PRIMARY KEY (purchase_id, isbn),
    CONSTRAINT fk_purchaseitem_purchase FOREIGN KEY (purchase_id) REFERENCES purchase(id),
    CONSTRAINT fk_purchaseitem_book FOREIGN KEY (isbn) REFERENCES book(isbn)
);

