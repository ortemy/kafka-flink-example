-- source
CREATE TABLE orders (
    amount DOUBLE,
    country VARCHAR,
    description VARCHAR,
    order_timestamp  VARCHAR
) WITH (
    'connector' = 'kafka',
    'properties.bootstrap.servers' = '',
    'scan.startup.mode' = 'earliest-offset',
    'topic' = 'orders',
    'value.format' = 'json'
)

-- sink
CREATE TABLE orders_us (
    amount DOUBLE,
    country VARCHAR,
    description VARCHAR,
    order_timestamp VARCHAR 
) WITH (
    'connector' = 'kafka',
    'properties.bootstrap.servers' = '',
    'scan.startup.mode' = 'earliest-offset',
    'topic' = 'orders_us',
    'value.format' = 'json'
)

-- filter
INSERT INTO orders_us
SELECT 
    o.amount,
     o.country,
    o.description,
    o.order_timestamp
 from orders o
 where o.country = 'US'