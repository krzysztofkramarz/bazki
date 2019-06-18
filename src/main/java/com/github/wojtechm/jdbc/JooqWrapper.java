package com.github.wojtechm.jdbc;

import com.github.wojtechm.DataSourceConfig;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.jooq.impl.DSL.*;

/**
 * @author Wojciech Makiela
 */
class JooqWrapper {
    private DSLContext database;

    JooqWrapper(DataSourceConfig config) throws SQLException {
        Connection connection = DriverManager.getConnection(config.url, config.username, config.password);
        database = DSL.using(connection, SQLDialect.MYSQL);
    }

    void playWithPokemon() {
        resetTablePokemon();
        addSomePokemon();
        printAllPokemon();
        Pokemon pokemon = getPokemonWithId(6);
        pokemon.type = "Poison, but name is really long so you are guaranteed to notice the change";
        update(pokemon);
        printAllPokemon();
    }

    private void resetTablePokemon() {
        // TODO autoinkrementacja id w tabeli nie działa ;( Truncate tylko co by pokazać że reszta działa. Po naprawieniu createTable wywołanie truncate wykasować!
        database.truncate(table("pokemon")).execute();
//        database.dropTableIfExists("pokemon").execute();
//        database.createTable(table("pokemon"))
//                .column("id", SQLDataType.INTEGER)
//                .column("name", SQLDataType.VARCHAR(50).nullable(false))
//                .column("type", SQLDataType.VARCHAR(50).nullable(false))
//                .constraint(constraint("PK_POKEMON").primaryKey("id"))
//                .execute();
//        database.alterTable("pokemon")
//                .alter("id")
//                .defaultValue(1);
    }

    private void addSomePokemon() {
        database.insertInto(table("pokemon"))
                .columns(field("name"), field("type"))
                .values("Bulbasaur", "Grass")
                .values("Pikachu", "Electric")
                .values("Muk", "Normal")
                .execute();
    }

    private Pokemon getPokemonWithId(int id) {
        return database.select(asterisk())
                .from(table("pokemon"))
                .where(condition("pokemon.id = ?", id))
                .fetchSingle()
                .into(Pokemon.class);

    }

    private void update(Pokemon pokemon) {
        database.update(table("pokemon"))
                .set(field("name"), pokemon.name)
                .set(field("type"), pokemon.type)
                .where("id = ?", pokemon.id)
                .execute();
    }

    private void printAllPokemon() {
        Result<Record3<Object, Object, Object>> pokemon =
                database.select(field("pokemon.id"), field("pokemon.name"), field("pokemon.type"))
                        .from(table("pokemon"))
                        .fetch();

        System.out.println(pokemon);
    }
}
