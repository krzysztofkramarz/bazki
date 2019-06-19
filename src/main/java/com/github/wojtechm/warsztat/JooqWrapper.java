package com.github.wojtechm.warsztat;

import com.github.wojtechm.DataSourceConfig;
import org.jooq.DSLContext;
import org.jooq.Record5;
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


    void róbRzeczyZIde() {
        wyczyśćTabelę();
        dodajIde();
        wyświetlIde();
        IntegratedDevelopmentEnvironment intellij = dawajIntellidżejke();
        intellij.licencja = "Ultimate Edition: proprietary";
        zaktualizuj(intellij);
        wyświetlIde();
    }

    private void wyczyśćTabelę() {
        database.truncate("integrated_development").execute();
    }

    private void dodajIde() {
        database.insertInto(table("integrated_development"))
                .columns(field("nazwa"), field("licencja"), field("java"), field("linux"))
                .values("Eclipse JDT", " EPL", false, true)
                .values("IntelliJ IDEA", " Community Edition: Apache License v2.0", true, true)
                .execute();

    }

    private void wyświetlIde() {
        Result<Record5<Object, Object, Object, Object, Object>> ide =
                database.select(field("integrated_development.id"),
                        field("integrated_development.nazwa"),
                        field("integrated_development.licencja"),
                        field("integrated_development.java"),
                        field("integrated_development.linux"))
                        .from(table("integrated_development"))
                        .fetch();


        System.out.println("JOOOOOQQQ   ################### ");
        System.out.println(ide);


    }

    private IntegratedDevelopmentEnvironment dawajIntellidżejke() {

        System.out.println("TUUUUUUUUUUUUUUU");
        return database.select(asterisk())
                .from(table("integrated_development"))
                .where(condition("integrated_development.nazwa like '%IntelliJ%'"))
                .fetchSingle()
                .into(IntegratedDevelopmentEnvironment.class);
    }

    private void zaktualizuj(IntegratedDevelopmentEnvironment integratedDevelopmentEnvironment) {
        database.update(table("integrated_development"))
                .set(field("licencja"), integratedDevelopmentEnvironment.getLicencja())
                .where("nazwa = ?", integratedDevelopmentEnvironment.getNazwa())
                .execute();

    }
}
