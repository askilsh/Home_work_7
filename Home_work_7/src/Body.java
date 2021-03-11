import java.util.Scanner;

public class Body {
    public static void main(final String[] argc) {
        int i = 0;
        Country[] puff = Country.values();
        System.out.println("Вывожу список всех стран");
        for (Country name : puff) {
            System.out.println(name);
        }
        /*while (i < puff.length) {
            System.out.println(puff[i]);
            i++;
        }*/
        Scanner into = new Scanner(System.in, "UTF-8");
        while (true) {
            System.out.println("Введите интересующую вас страну.");
            System.out.println("Для завершения программы введите {exit}.");
            String strIn = into.nextLine();
            if (strIn.equals("exit")) {
                into.close();
                return;
            }
            findCountry(strIn);
        }
    }

    public static void findCountry(final String strIn) {
        Country puff;
        System.out.println("Ищем интересующую вас страну...");
        try {
            puff = Country.valueOf(strIn);
            checkMet(puff);
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование страны на английском введено некорректно, проверяем русское название...");
            try {
                Country.getByRuName(strIn);
            } catch (NoCountryException x) {
                System.out.println("В нашей базе нет страны под названием " + strIn + ".");
                System.out.println("Попробуйте ещё.");
                System.out.println();
            }
        } catch (NullPointerException e) {
            System.out.println("Ошибка. Кто-то подсунул нам Null. strIn = " + strIn);
            System.out.println();
        }
    }

    public static void checkMet(final Country country) {
        String bool;
        if (country.getIsOpen()) {
            bool = "открыта";
        } else {
            bool = "закрыта";
        }
        System.out.println("Страна [" + country + "] " + bool + " для туристов.");
        System.out.println();
    }
}
