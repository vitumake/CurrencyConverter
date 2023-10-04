# SQL queries

## 1. DB creation

```sql

CREATE DATABASE IF NOT EXISTS `currencyrates`
USE `currencyrates`;

CREATE TABLE IF NOT EXISTS `currency` (
  `isocode` varchar(3) NOT NULL DEFAULT '',
  `rate` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `currency` (`isocode`, `rate`) VALUES
	('USD', 4.4155),
	('AUD', 2.792),
	('HKD', 0.5639),
	('CAD', 3.224),
	('NZD', 2.6058),
	('SGD', 3.2186),
	('EUR', 4.6303),
	('HUF', 0.01192),
	('CHF', 4.8065),
	('GBP', 5.3492),
	('UAH', 0.1206),
	('JPY', 0.029637),
	('CZK', 0.1891),
	('DKK', 0.6208),
	('ISK', 0.031736),
	('NOK', 0.4033),
	('SEK', 0.3986),
	('RON', 0.9307),
	('BGN', 2.3674),
	('TRY', 0.1602),
	('ILS', 1.1447),
	('CLP', 0.004812),
	('PHP', 0.0779),
	('MXN', 0.2446),
	('ZAR', 0.2287),
	('BRL', 0.8544),
	('MYR', 0.9332),
	('IDR', 0.0002825),
	('INR', 0.053051),
	('KRW', 0.003255),
	('CNY', 0.6009),
	('XDR', 5.7811),
	('USD', 4.4155),
	('AUD', 2.792),
	('HKD', 0.5639),
	('CAD', 3.224),
	('NZD', 2.6058),
	('SGD', 3.2186),
	('EUR', 4.6303),
	('HUF', 0.01192),
	('CHF', 4.8065),
	('GBP', 5.3492),
	('UAH', 0.1206),
	('JPY', 0.029637),
	('CZK', 0.1891),
	('DKK', 0.6208),
	('ISK', 0.031736),
	('NOK', 0.4033),
	('SEK', 0.3986),
	('RON', 0.9307),
	('BGN', 2.3674),
	('TRY', 0.1602),
	('ILS', 1.1447),
	('CLP', 0.004812),
	('PHP', 0.0779),
	('MXN', 0.2446),
	('ZAR', 0.2287),
	('BRL', 0.8544),
	('MYR', 0.9332),
	('IDR', 0.0002825),
	('INR', 0.053051),
	('KRW', 0.003255),
	('CNY', 0.6009),
	('XDR', 5.7811),
	('USD', 4.4155),
	('AUD', 2.792),
	('HKD', 0.5639),
	('CAD', 3.224),
	('NZD', 2.6058),
	('SGD', 3.2186),
	('EUR', 4.6303),
	('HUF', 0.01192),
	('CHF', 4.8065),
	('GBP', 5.3492),
	('UAH', 0.1206),
	('JPY', 0.029637),
	('CZK', 0.1891),
	('DKK', 0.6208),
	('ISK', 0.031736),
	('NOK', 0.4033),
	('SEK', 0.3986),
	('RON', 0.9307),
	('BGN', 2.3674),
	('TRY', 0.1602),
	('ILS', 1.1447),
	('CLP', 0.004812),
	('PHP', 0.0779),
	('MXN', 0.2446),
	('ZAR', 0.2287),
	('BRL', 0.8544),
	('MYR', 0.9332),
	('IDR', 0.0002825),
	('INR', 0.053051),
	('KRW', 0.003255),
	('CNY', 0.6009),
	('XDR', 5.7811),
	('USD', 4.4155),
	('AUD', 2.792),
	('HKD', 0.5639),
	('CAD', 3.224),
	('NZD', 2.6058),
	('SGD', 3.2186),
	('EUR', 4.6303),
	('HUF', 0.01192),
	('CHF', 4.8065),
	('GBP', 5.3492),
	('UAH', 0.1206),
	('JPY', 0.029637),
	('CZK', 0.1891),
	('DKK', 0.6208),
	('ISK', 0.031736),
	('NOK', 0.4033),
	('SEK', 0.3986),
	('RON', 0.9307),
	('BGN', 2.3674),
	('TRY', 0.1602),
	('ILS', 1.1447),
	('CLP', 0.004812),
	('PHP', 0.0779),
	('MXN', 0.2446),
	('ZAR', 0.2287),
	('BRL', 0.8544),
	('MYR', 0.9332),
	('IDR', 0.0002825),
	('INR', 0.053051),
	('KRW', 0.003255),
	('CNY', 0.6009),
	('XDR', 5.7811),
	('USD', 4.4155),
	('AUD', 2.792),
	('HKD', 0.5639),
	('CAD', 3.224),
	('NZD', 2.6058),
	('SGD', 3.2186),
	('EUR', 4.6303),
	('HUF', 0.01192),
	('CHF', 4.8065),
	('GBP', 5.3492),
	('UAH', 0.1206),
	('JPY', 0.029637),
	('CZK', 0.1891),
	('DKK', 0.6208),
	('ISK', 0.031736),
	('NOK', 0.4033),
	('SEK', 0.3986),
	('RON', 0.9307),
	('BGN', 2.3674),
	('TRY', 0.1602),
	('ILS', 1.1447),
	('CLP', 0.004812),
	('PHP', 0.0779),
	('MXN', 0.2446),
	('ZAR', 0.2287),
	('BRL', 0.8544),
	('MYR', 0.9332),
	('IDR', 0.0002825),
	('INR', 0.053051),
	('KRW', 0.003255),
	('CNY', 0.6009),
	('XDR', 5.7811),
	('USD', 4.4155),
	('AUD', 2.792),
	('HKD', 0.5639),
	('CAD', 3.224),
	('NZD', 2.6058),
	('SGD', 3.2186),
	('EUR', 4.6303),
	('HUF', 0.01192),
	('CHF', 4.8065),
	('GBP', 5.3492),
	('UAH', 0.1206),
	('JPY', 0.029637),
	('CZK', 0.1891),
	('DKK', 0.6208),
	('ISK', 0.031736),
	('NOK', 0.4033),
	('SEK', 0.3986),
	('RON', 0.9307),
	('BGN', 2.3674),
	('TRY', 0.1602),
	('ILS', 1.1447),
	('CLP', 0.004812),
	('PHP', 0.0779),
	('MXN', 0.2446),
	('ZAR', 0.2287),
	('BRL', 0.8544),
	('MYR', 0.9332),
	('IDR', 0.0002825),
	('INR', 0.053051),
	('KRW', 0.003255),
	('CNY', 0.6009),
	('XDR', 5.7811);

DROP USER IF EXISTS appuser;

CREATE USER appuser;

GRANT SELECT, ALTER, DELETE, INSERT ON currencyrates.* TO appuser;
```

## 2. DB queries

### 2.1. Get all currencies

```sql
SELECT * FROM currencies;
```

### 2.2. Get currency by isocode

```sql
SELECT * FROM currencies WHERE isocode = 'EUR';
```

### 2.3. Get currency count

```sql
SELECT COUNT(*) FROM currencies;
```

### 2.4. Get highest exchange rate;

```sql
SELECT * FROM currencies ORDER BY exchange_rate DESC LIMIT 1;
```
