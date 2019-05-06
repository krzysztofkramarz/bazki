package com.github.wojtechm.jdbc;

/**
 * @author Wojciech Makiela
 */
class Pokemon {

    long id;
    String name;
    String type;

    public Pokemon(long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

