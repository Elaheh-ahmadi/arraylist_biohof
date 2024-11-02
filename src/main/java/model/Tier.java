package model;

import java.time.Year;

public class Tier {
    private String name;
    private float gewicht;
    private float preis;
    private Year geburtsjahr;
    private boolean maenlich;

    public Tier() {

    }

    public Tier(String name, float gewicht, float preis, Year geburtsjahr, boolean meanlich) throws BiohofException {
        setName(name);
        setGewicht(gewicht);
        setPreis(preis);
        setGeburtsjahr(geburtsjahr);
        setMaenlich(meanlich);
    }

    public Tier(String name, float gewicht, float preis, int geburtsjahr, boolean meanlich) throws BiohofException {
        setName(name);
        setGewicht(gewicht);
        setPreis(preis);
        setGeburtsjahr(Year.of(geburtsjahr));
        setMaenlich(meanlich);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws BiohofException {
        if ((name != null) && (name.length() >= 3)) {
            this.name = name;
        } else {
            throw new BiohofException("Fehler:darf nicht null sein and Darf nicht leer sein and Muss aus mind. 3 Zeichen bestehen");
        }
    }

    public float getGewicht() {
        return gewicht;
    }

    public void setGewicht(float gewicht) throws BiohofException {
        if (gewicht > 1 && gewicht < 1500) {
            this.gewicht = gewicht;
        } else {
            throw new BiohofException("Fehler:Darf nicht kleiner als 1 kg sein and Darf nicht größer als 1500 kg sein");
        }
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) throws BiohofException {
        if (preis > 10 && preis < 2500) {
            this.preis = preis;
        } else {
            throw new BiohofException("Fehler:Darf nicht kleiner als 10 € sein and Darf nicht größer als 2500 € sei ");
        }
    }

    public int getAlter() {
        return Year.now().getValue() - this.geburtsjahr.getValue();
    }

    public void setGeburtsjahr(Year geburtsjahr) throws BiohofException {
        if (geburtsjahr.getValue() < 10) {
            throw new BiohofException("Fehler");
        }

        int now = Year.now().getValue();
        if(geburtsjahr.getValue() > now) {
            throw new BiohofException("Fehler");
        }

        this.geburtsjahr = geburtsjahr;
    }


    public boolean isMaenlich() {
        return maenlich;
    }

    public void setMaenlich(boolean maenlich) {
        this.maenlich = maenlich;
    }

    public void print() {
        System.out.println(toString());

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name=").append(name)
                .append("Gewicht=").append(gewicht).append("kg")
                .append("Preis=").append(preis).append(" €")
                .append("Alter").append(this.getAlter()).append("Jahre")
                .append(isMaenlich() ? "männlich" : "weiblich");
        return sb.toString();
    }
}
