public class Pojisteny {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telCislo;

    // Konstruktor
    public Pojisteny(String jmeno, String prijmeni, int vek, String telCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telCislo = telCislo;
    }

    // Gettery
    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    // Vypsání pojištěného pomocí metody toString()
    @Override
    public String toString() {
        return "Jméno: " + jmeno + ", Příjmení: " + prijmeni + ", Věk: " + vek + ", Telefonní číslo: " + telCislo;
    }
}



