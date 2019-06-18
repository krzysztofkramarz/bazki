package com.github.wojtechm;

import java.util.ResourceBundle;

/**
 * Chamskie zaciągnięcie do kodu konfiguracji z application.properties.
 *
 * Zapytasz pewnie:
 * "Ale Wojciech! Skoro i tak wciągasz całą zawartość do kodu, to czemu nie usuniesz pliku
 *      .properties całkiem, a zawartości wstawisz tutaj?"
 *
 * Znakomite pytanie!
 *
 * Poniżej znajdziesz serię wymówek, dlaczego popełniłem ten okropny kawałek kodu, ale nie są one istotne dla
 * zrozumienia całości tego repozytorium, więc możesz je ominąć.
 *
 * Jednak czytasz? Dobrze. A więc...
 * Odpowiedź jest dość prosta: wypchnięcie konfiguracji do jednego miejsca.
 * Nie chcemy szukać konfiguracji po całym kodzie - chcemy ją mieć w jednym miejscu.
 * Pozwala nam to na łatwiejsze modyfikacje oraz poprawia spójności aplikacji.
 * Dodatkowo, przy aplikacjach Spring Bootowych swego rodzaju odruchem jest szukanie konfiguracji
 * w pliku application.properties właśnie.
 *
 * Oczywiście tej aplikacji nikt nie będzie rozszerzał (a przynajmniej wątpię by ktoś chciał to robić)
 * więc jest to lekka przesada, ale cóż... decyzje zostały podjęte.
 *
 * @author Wojciech Makiela
 */
public class DataSourceConfig {
    public String url;
    public String username;
    public String password;
    public String driverName;

    public DataSourceConfig() {
        ResourceBundle config = ResourceBundle.getBundle("application");
        url = config.getString("spring.datasource.url");
        username = config.getString("spring.datasource.username");
        password = config.getString("spring.datasource.password");
        driverName = config.getString("datasource.driverName");
    }
}
