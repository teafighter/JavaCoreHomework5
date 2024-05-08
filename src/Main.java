import Exceptions.WrongLoginException;
import Exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        try {
            checkCredentials("swht123", "werg", "werg");
        } catch (WrongPasswordException e) {
            System.out.println("Пароль может содержать в себе только латинские буквы, цифры и знак подчеркивания. Он должен быть равен или меньше 20 символов. Пароль и его проверка должны совпадать.");
        } catch (WrongLoginException e) {
            System.out.println("Логин может содержать в себе только латинские буквы, цифры и знак подчеркивания. Он должен быть равен или меньше 20 символов");
        } finally {
            System.out.println("Проверка завершена.");
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