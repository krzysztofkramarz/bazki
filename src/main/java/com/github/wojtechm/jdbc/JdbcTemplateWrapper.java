package com.github.wojtechm.jdbc;

import com.github.wojtechm.DataSourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wojciech Makiela
 */
class JdbcTemplateWrapper {

    private JdbcTemplate jdbcTemplate;

    JdbcTemplateWrapper(DataSourceConfig sourceConfig) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(sourceConfig.driverName);
        dataSource.setUrl(sourceConfig.url);
        dataSource.setUsername(sourceConfig.username);
        dataSource.setPassword(sourceConfig.password);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    void playWithPokemon() {
        resetTablePokemon();
        addSomePokemon();
        printAllPokemon();
        Pokemon pokemon = getPokemonWithId(3);
        pokemon.type = "Poison, but name is really long so you are guaranteed to notice the change";
        update(pokemon);
        printAllPokemon();
    }

    private void resetTablePokemon() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS pokemon;");
        jdbcTemplate.execute("CREATE TABLE pokemon(" +
                "id SERIAL NOT NULL AUTO_INCREMENT, name VARCHAR(255), type VARCHAR(255))");
    }

    private void addSomePokemon() {
        List<Object[]> pokemonToAdd = new ArrayList<>();
        pokemonToAdd.add(new Object[]{"Bulbasaur", "Grass"});
        pokemonToAdd.add(new Object[]{"Pikachu", "Electric"});
        pokemonToAdd.add(new Object[]{"Muk", "Normal"});
        jdbcTemplate.batchUpdate("INSERT INTO pokemon (id, name, type) VALUES (null, ?, ?);", pokemonToAdd);
    }

    private void printAllPokemon() {
        jdbcTemplate.query("SELECT * FROM pokemon", (resultSet, i) -> new Pokemon(resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("type")
        )).forEach(System.out::println);
        System.out.println();
    }

    private Pokemon getPokemonWithId(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM pokemon WHERE (id = ?)", new Object[]{id}, (resultSet, i) -> new Pokemon(resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("type")));
    }

    private void update(Pokemon pokemon) {
        jdbcTemplate.update("UPDATE pokemon SET name = ?, type = ? where id = ?", pokemon.name, pokemon.type, pokemon.id);
    }

}
