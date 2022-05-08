CREATE TABLE IF NOT EXISTS WEB_LOOKUP (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  web_address VARCHAR(250) NOT NULL,
  search_keyword VARCHAR(250) NOT NULL,
  minority_owned VARCHAR(250) DEFAULT NULL,
  status VARCHAR(250) DEFAULT NULL,
  last_scan_date TIMESTAMP DEFAULT NULL
);