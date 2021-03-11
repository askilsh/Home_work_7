public class NoCountryException extends Exception {
    public NoCountryException(final String ru) {
        System.out.print("Эх, ну и что мне с тобой делать? ");
        System.out.println("Мне сказали, что программа должна работать, живи пока");
        System.out.println("Но смотри, если еще раз увижу " + ru + " за себя не ручаюсь!");
    }
}
