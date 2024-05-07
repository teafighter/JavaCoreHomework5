import Exceptions.WrongLoginException;
import Exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        try {
            checkCredentials("swht123", "werg", "werg");
        } catch (WrongPasswordException e) {
            System.out.println("Пароль не соответствует требованиям или не пароли не совпадают");
        } catch (WrongLoginException e) {
            System.out.println("Логин не соответствует требованиям");
        } finally {
            System.out.println("Проверка завершена");
        }
    }

    public static void checkCredentials(String login, String password, String checkPassword) throws WrongPasswordException, WrongLoginException {
        if (checkFailed(login)) {
            throw new WrongLoginException();
        }
        if (checkFailed(password)) {
            throw new WrongPasswordException();
        }
        if (!checkPassword.equals(password)) {
            throw new WrongPasswordException();
        }
    }

    public static boolean checkFailed(String s) {
        return (!s.matches("\\w+") || (s.isEmpty()) || (s.length() >= 21));
    }
}