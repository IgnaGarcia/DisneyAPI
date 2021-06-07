----SECURITY DROPS
DROP TABLE IF EXISTS disney.movie_characters CASCADE;
DROP TABLE IF EXISTS disney.characters CASCADE;
DROP TABLE IF EXISTS disney.movies CASCADE;
DROP TABLE IF EXISTS disney.genres CASCADE;

----CREATES
CREATE TABLE disney.characters (
  c_id BIGINT NOT NULL AUTO_INCREMENT,
  image VARCHAR(200),
  name VARCHAR(30),
  age INT,
  weigth DOUBLE,
  history VARCHAR(400),
  PRIMARY KEY (c_id));

CREATE TABLE disney.genres (
  g_id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45),
  image VARCHAR(200),
  PRIMARY KEY (g_id));

CREATE TABLE disney.movies (
  m_id BIGINT NOT NULL AUTO_INCREMENT,
  image VARCHAR(200),
  title VARCHAR(50),
  date DATE,
  rate TINYINT(1),
  g_id BIGINT NOT NULL,
  PRIMARY KEY (m_id),
  INDEX fk_movie_genre_idx (g_id ASC) VISIBLE,
  CONSTRAINT fk_movie_genre
    FOREIGN KEY (g_id)
    REFERENCES disney.genres (g_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE disney.movie_characters (
  c_id BIGINT NOT NULL,
  m_id BIGINT NOT NULL,
  PRIMARY KEY (c_id, m_id),
  INDEX fk_movie_characters_movie_idx (m_id ASC) VISIBLE,
  INDEX fk_movie_characters_character_idx (c_id ASC) VISIBLE,
  CONSTRAINT fk_movie_characters_character_idx
    FOREIGN KEY (c_id)
    REFERENCES disney.characters (c_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_movie_characters_movie_idx
    FOREIGN KEY (m_id)
    REFERENCES disney.movies (m_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


----INSERTS
INSERT INTO disney.characters(image, name, age, weigth, history) VALUES
  ("/nemo.png", "Nemo", 3, 1.5, "Un pez payaso que se escapa"),
  ("/dory.png", "Dory", 10, 2, "Un pez olvidadizo"),
  ("/buzz.png", "Buzz Lightyear", 7, 0.5, "Un muneco que no vuela"),
  ("/woody.png", "Woody", 20, 0.3, "Un vaquero guapo"),
  ("/jack.png", "Jack", 100, 20, "Un muerto agradable");

INSERT INTO disney.genres(image, name) VALUES
  ("/animacion.png", "Animacion"),
  ("/terror.png", "Terror"),
  ("/comedia.png", "Comedia");

INSERT INTO disney.movies(image, title, date, rate, g_id) VALUES
  ("/buscandoanemo.png", "Buscando a Nemo", '2003-7-03', 4, 1),
  ("/buscandoadory.png", "Buscando a Dory", '2016-6-16', 2, 2),
  ("/toystory.png", "Toy Story", '1996-3-14', 5, 3),
  ("/toystory2.png", "Toy Story 2", '1999-12-02', 1, 1),
  ("/toystory3.png", "Toy Story 3", '2010-3-15', 3, 3),
  ("/elmundodejack.png", "El extrano mundo de Jack", '1994-10-17', 5, 2);

INSERT INTO disney.movie_characters(c_id, m_id) VALUES
  (1, 1),
  (1, 2),
  (2, 1),
  (2, 2),
  (3, 3),
  (3, 4),
  (3, 5),
  (4, 3),
  (4, 4),
  (4, 5),
  (5, 6);