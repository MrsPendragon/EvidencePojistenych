import java.util.Scanner;

public class UzivatelskeRozhrani {
    private Scanner scanner = new Scanner(System.in);
    private SpravcePojistenych spravce = new SpravcePojistenych();  // Instance třídy SpravcePojistenych

    // Metoda pro zobrazení menu
    public void zobrazMenu() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("     EVIDENCE POJIŠTĚNÝCH     ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Vyberte si akci:");
        System.out.println("1. Přidat nového pojištěného");
        System.out.println("2. Vypsat všechny pojištěné");
        System.out.println("3. Vyhledat pojištěného");
        System.out.println("4. Konec");
    }

    // Metoda pro zadání jména uživatelem
    private String zadejJmeno() {
        System.out.println("Zadejte jméno:");
        String jmeno = scanner.nextLine().trim();
        while (jmeno.isEmpty()) {  // Dokud uživatel zadává prázdné pole
            System.out.print("Jméno je povinný údaj, zadejte jej prosím znovu: ");
            jmeno = scanner.nextLine().trim();
        }
        return jmeno;
    }

    // Metoda pro zadání příjmení uživatelem
    private String zadejPrijmeni() {
        System.out.println("Zadejte příjmení:");
        String prijmeni = scanner.nextLine().trim();
        while (prijmeni.isEmpty()) {  // Dokud uživatel zadává prázdné pole
            System.out.print("Příjmení je povinný údaj, zadejte jej prosím znovu: ");
            prijmeni = scanner.nextLine().trim();
        }
        return prijmeni;
    }

    // Metoda pro vytvoření nového pojištěného pomocí údajů zadaných uživatelem a jeho uložení do seznamu pojištěných
    public void vytvorPojisteneho() {
        // Získání údajů od uživatele
        String jmeno = zadejJmeno();
        String prijmeni = zadejPrijmeni();

        System.out.println("Zadejte věk:");
        int vek = 0;
        while (true) {
            try {
                vek = Integer.parseInt(scanner.nextLine());
                if (vek < 0) {  // Zjistí, zda uživatel nezadal záporné číslo
                    System.out.print("Věk nemůže být záporné číslo, zadejte jej prosím znovu: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {  // Zjistí, zda uživatel zadal číslo
                System.out.print("Zadejte prosím celé číslo: ");
            }
        }

        System.out.println("Zadejte telefonní číslo:");
        String telCislo = scanner.nextLine().trim();

        // Vytvoření objektu pojisteny a zavolání metody (ze třídy SpravcePojistenych) pro jeho uložení do seznamu
        Pojisteny pojisteny = new Pojisteny(jmeno, prijmeni, vek, telCislo);
        spravce.pridejPojisteneho(pojisteny);  // zavolání metody (ze třídy SpravcePojistenych) pro uložení pojištěného
    }

    // Metoda pro vypsání seznamu všech pojištěných
    public void vypisPojistene() {
        System.out.println("Seznam všech pojištěných:");
        spravce.vypisPojistene();  // zavolání metody (ze třídy SpravcePojistenych) pro vypsání pojištěných
    }

    // Metoda pro vyhledání pojištěného pomocí údajů zadaných uživatelem
    public void najdiPojisteneho() {
        String hledaneJmeno = zadejJmeno();
        String hledanePrijmeni = zadejPrijmeni();
        spravce.najdiPojisteneho(hledaneJmeno, hledanePrijmeni);  // zavolání metody (ze třídy SpravcePojistenych) pro vyhledání pojištěného
    }

    public void pokracuj() {  // Metoda pro pokračování a opětovné zobrazení menu
        System.out.println("Pro pokračování stiskněte klávesu enter.");
        scanner.nextLine();
        zobrazMenu();
    }

    public static void main(String[] args) {  // Hlavní metoda
        UzivatelskeRozhrani uzivatelskeRozhrani = new UzivatelskeRozhrani();  // Instance třídy UyivatelskeRozhrani pro získání přístupu k jejím metodám
        Scanner scanner = new Scanner(System.in);
        boolean konec = false;

        uzivatelskeRozhrani.zobrazMenu();

        while (!konec) {  // Cyklus while běží, dokud uživatel nezadá volbu pro ukončení
            int volba = Integer.parseInt(scanner.nextLine());
            switch (volba) {  // Konstrukce switch pro zpracování volby uživatele
                case 1:
                    uzivatelskeRozhrani.vytvorPojisteneho();
                    uzivatelskeRozhrani.pokracuj();
                    break;
                case 2:
                    uzivatelskeRozhrani.vypisPojistene();
                    uzivatelskeRozhrani.pokracuj();
                    break;
                case 3:
                    uzivatelskeRozhrani.najdiPojisteneho();
                    uzivatelskeRozhrani.pokracuj();
                    break;
                case 4:
                    konec = true;
                    break;
                default:
                    System.out.println("Neplatná volba, zkuste to znovu.");
                    uzivatelskeRozhrani.pokracuj();
                    break;
            }
        }
        scanner.close();
    }
}