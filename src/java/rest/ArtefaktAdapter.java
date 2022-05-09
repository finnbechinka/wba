package rest;

import classes.Artefakt;

/**
 * Adapter solveing the issue - Date is not directly parseable from json useing
 * JAXB
 *
 * @author Florian Fehring
 */
public class ArtefaktAdapter {

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

    public Artefakt toArtefakt() {
        Artefakt art = new Artefakt();
        art.setId(this.id);
        art.setTitel(this.titel);
        art.setKurzbeschreibung(this.kurzbeschreibung);  //ISO-Datumsformat yyyy-mm-ddT10:15:30
        return art;
    }
}
