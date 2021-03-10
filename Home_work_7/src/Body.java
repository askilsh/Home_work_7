import java.util.Scanner;

public class Body {
    public static void main(final String[] argc) {
        int i = 0;
        Body.Country[] puff = Country.values();
        System.out.println("Вывожу список всех стран");
        while (i < puff.length) {
            System.out.println(puff[i]);
            i++;
        }
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
            getByRuName(strIn);
        } catch (NullPointerException e) {
            System.out.println("Вот мы и тут");
            throw new NullPointerException("Ошибка. Кто-то подсунул нам Null. strIn = " + strIn);
        }
    }

    public static void checkMet(final Country country) {
        String bool;
        if (country.isOpen) {
            bool = "открыта";
        } else {
            bool = "закрыта";
        }
        System.out.println("Страна [" + country + "] " + bool + " для туристов.");
        System.out.println();
    }

    public static void getByRuName(final String ru) {
        int i = 0;
        Body.Country[] puff = Country.values();
        while (i < puff.length) {
            if ((puff[i].ru.equals(ru))) {
                checkMet(puff[i]);
                return;
            }
            i++;
        }
        try {
            throw new NoCountryException(ru);
        } catch (NoCountryException e) {
            System.out.println("Попробуйте ещё.");
            System.out.println();
        }
    }

    public enum Country {
        CUBA("Куба", true) {
        },
        UAE("ОАЭ", true) {
        },
        THAILAND("Тайланд", false) {
        },
        BULGARIA("Болгария", false) {
        },
        GREECE("Греция", false) {
        },
        VIETNAM("Вьетнам", false) {
        },
        TURKEY("Турция", true) {
        },
        EGYPT("Египет", true) {
        },
        CYPRUS("Кипр", false) {
        };

        private final String ru;
        private boolean isOpen;

        Country(final String ru, final boolean isOpen) {
            this.ru = ru;
            this.isOpen = isOpen;
        }

        @Override
        public String toString() {
            return name() + " (" + ru + ")";
        }
    }
}
