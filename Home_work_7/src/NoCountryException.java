public class NoCountryException extends Throwable {
    public NoCountryException(final String ru) {
        System.out.println("В нашей базе нет страны под названием " + ru + ". Обрабатываются строго страны из списка.");
    }
}
