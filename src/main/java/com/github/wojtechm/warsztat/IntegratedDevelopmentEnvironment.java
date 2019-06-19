package com.github.wojtechm.warsztat;

/**
 * @author Wojciech Makiela
 */
class IntegratedDevelopmentEnvironment {

    long id;
    String nazwa;
    String licencja;
    boolean czyNapisanyWJavie;
    boolean czyWspieraLinux;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getLicencja() {
        return licencja;
    }

    public void setLicencja(String licencja) {
        this.licencja = licencja;
    }

    public boolean isCzyNapisanyWJavie() {
        return czyNapisanyWJavie;
    }

    public void setCzyNapisanyWJavie(boolean czyNapisanyWJavie) {
        this.czyNapisanyWJavie = czyNapisanyWJavie;
    }

    public boolean isCzyWspieraLinux() {
        return czyWspieraLinux;
    }

    public void setCzyWspieraLinux(boolean czyWspieraLinux) {
        this.czyWspieraLinux = czyWspieraLinux;
    }

    @Override
    public String toString() {
        return "IntegratedDevelopmentEnvironment{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", licencja='" + licencja + '\'' +
                ", czyNapisanyWJavie=" + czyNapisanyWJavie +
                ", czyWspieraLinux=" + czyWspieraLinux +
                '}';
    }


    // BlueJ, GPL2+GNU linking exception, Yes, Yes
    // Eclipse JDT, EPL, No, Yes
    // IntelliJ IDEA, Community Edition: Apache License v2.0, Yes, Yes
}
