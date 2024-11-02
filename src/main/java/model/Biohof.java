package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Biohof {

    private String hofname;
    private ArrayList<Tier> tiere;
    private int maxAnzahl;
    private int alter;

    public Biohof(String hofname, int maxAnzahl) throws BiohofException {
        setHofname(hofname);
        setMaxAnzahl(maxAnzahl);
    }

    public Biohof() {
        tiere = new ArrayList<>();
    }

    public String getHofname() {
        return hofname;
    }

    public void setHofname(String hofname) throws BiohofException {
        if (hofname != null) {
            this.hofname = hofname;
        } else {
            throw new BiohofException("Fehler :name darf nicht null sein!");
        }
    }

    public ArrayList<Tier> getTiere() {
        return tiere;
    }

    public void setTiere(ArrayList<Tier> tiere) {
        this.tiere = tiere;
    }

    public int getMaxAnzahl() {
        return maxAnzahl;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setMaxAnzahl(int maxAnzahl) throws BiohofException {
        if (maxAnzahl <= 5) {
            this.maxAnzahl = maxAnzahl;
        } else {
            throw new BiohofException("Fehler: maxale anzahl muss 5 sein!");
        }
    }

    public void aufnehmen(Tier tier) throws BiohofException {
        if (tier == null) {
            throw new BiohofException("Fehler :Fehler: Kein Tier übergeben!");
        }
        if (tiere.contains(tier)) {
            throw new BiohofException("Fehler :Fehler: Dieses Tier wurde bereits aufgenommen!");
        }
        if (tiere.size() >= maxAnzahl) {
            throw new BiohofException("Fehler: Kein Platz mehr im Stall!");
        }

        tiere.add(tier);
    }

    public boolean entfernen(Tier tier) throws BiohofException {
        if (tier == null) {
            throw new BiohofException(" Fehler: Kein Tier übergeben!");
        }
        if (!this.tiere.contains(tier)) {
            throw new BiohofException("Fehler: Tier wurde nicht entfernt!");
        }
        this.tiere.remove(tier);
        System.out.println("Tier" + tier.getName() + "erfolgreich entfernt!");
        return true;
    }

    public String entfernen(int alter) throws BiohofException {
        int anz = 0;

        Iterator<Tier> it = tiere.iterator();
        while (it.hasNext()) {
            Tier tier = it.next();
            if (tier.getAlter() == alter)
                it.remove();
            anz++;
        }

        if (anz == 0) {
            String message = "Kein Tier mit dem Alter " + alter + "gefunden.";
            System.err.println(message);
            return message;
        }

        return String.format("%d Tier(e) aus dem Stall entfernt.", anz);
    }

    public int minAlter() {
        int min = 9999;

        for (Tier t : this.tiere) {
            if (t.getAlter() < min) {
                min = t.getAlter();
            }
        }
        return min;
    }

    public int anzahlTiere() {
        return this.tiere.size();

    }

    public double durchSchnittsAlter() {
        int sum = 0;

        for (Tier t : this.tiere) {
            sum += t.getAlter();
        }

        return (double) sum / this.tiere.size();
    }

    public int gesamtgewichtTiere() {
        int sum = 0;
        for (Tier t : tiere) {
            sum += t.getGewicht();
        }
        return sum;

    }

    public Tier altesteTier() {
        int max = 0;
        Tier tier = null;

        for (Tier t : tiere) {
            if (t.getAlter() > max) {
                max = t.getAlter();
                tier = t;
            }
        }

        return tier;
    }

    public void print() {
        System.out.println(this.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hofname + "'s Rindviecha\n");
        sb.append("(" + this.altesteTier().toString() + ")\n");
        sb.append("===============================\n");
        for (Tier t : this.tiere) {
            sb.append(t.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
