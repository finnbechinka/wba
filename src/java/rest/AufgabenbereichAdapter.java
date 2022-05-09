package rest;

import classes.Aufgabenbereich;

/**
 * Adapter solveing the issue - Date is not directly parseable from json useing
 * JAXB
 *
 * @author Florian Fehring
 */
public class AufgabenbereichAdapter {

    private String titel;
    private String kurzbeschreibung;
    private Long id;

    public void setTitle(String title) {
        this.titel = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKurzbeschreibung(String kurzbeschreibung) {
        this.kurzbeschreibung = kurzbeschreibung;
    }

    public Aufgabenbereich toAufgabenbereich() {
        Aufgabenbereich auf = new Aufgabenbereich();
        auf.setId(this.id);
        auf.setTitel(this.titel);
        auf.setKurzbeschreibung(this.kurzbeschreibung);  //ISO-Datumsformat yyyy-mm-ddT10:15:30
        return auf;
    }
}
