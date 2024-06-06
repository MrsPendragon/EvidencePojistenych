import java.util.ArrayList;

public class SpravcePojistenych {
    private ArrayList<Pojisteny> seznamPojistenych = new ArrayList<>();  // Vytvoření ArrayListu pro ukládání pojištěných

    // Metoda pro uložení pojištěných do seznamu, volána ve třídě UzivatelskeRozhrani v rámci metody vytvořPojištěného
    public void pridejPojisteneho(Pojisteny pojisteny) {
        seznamPojistenych.add(pojisteny);
        System.out.println("Pojištěný byl uložen do seznamu.");
    }

    // Metoda pro vypsání všech pojištěných, volána ve třídě UzivatelskeRozhrani v rámci metody vypisPojistene()
    public void vypisPojistene() {
        if (seznamPojistenych.size() > 0) {  // Ověří, zda seznam není prázdný
            for (Pojisteny pojisteny : seznamPojistenych) {
                System.out.println(pojisteny);
            }
        } else {
            System.out.println("Seznam je prázdný.");
        }
    }

    // Metoda pro vyhledání pojištěného pomocí údajů zadaných uživatelem, volána ve třídě UzivatelskeRozhrani v rámci metody najdiPojisteneho()
    public void najdiPojisteneho(String hledaneJmeno, String hledanePrijmeni) {
        boolean nalezen = false;
        for (Pojisteny pojisteny : seznamPojistenych) {
            if (pojisteny.getJmeno().equalsIgnoreCase(hledaneJmeno) &&
                    pojisteny.getPrijmeni().equalsIgnoreCase(hledanePrijmeni)) {  // Zajistí nalezení pojištěného i v případě jiné velikosti písmen v zadání uživatele
                System.out.println(pojisteny);
                nalezen = true;
                break;  // Pokud je pojištěný nalezen, cyklus se ukončí
            }
        }
        if (!nalezen) {
            System.out.println("Pojištěný nebyl nalezen.");
        }
    }
}
