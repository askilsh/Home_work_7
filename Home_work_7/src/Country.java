public enum Country {
    CUBA("Куба", true),
    UAE("ОАЭ", true),
    THAILAND("Тайланд", false),
    BULGARIA("Болгария", false),
    GREECE("Греция", false),
    VIETNAM("Вьетнам", false),
    TURKEY("Турция", true),
    EGYPT("Египет", true),
    CYPRUS("Кипр", false);

    private final String ru;
    private final boolean isOpen;

    Country(final String ru, final boolean isOpen) {
        this.ru = ru;
        this.isOpen = isOpen;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public static void getByRuName(final String ru) throws NoCountryException {
        int i = 0;
        Country[] puff = Country.values();
        while (i < puff.length) {
            if ((puff[i].ru.equals(ru))) {
                Body.checkMet(puff[i]);
                return;
            }
            i++;
        }
        throw new NoCountryException(ru);
    }

    @Override
    public String toString() {
        return name() + " (" + ru + ")";
    }
}
