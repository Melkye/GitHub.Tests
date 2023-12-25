package settings;

import io.github.cdimascio.dotenv.Dotenv;

public  class EnvReader {
    private static final Dotenv dotenv = Dotenv.configure().directory("src/main/java/settings").load();

    public static String getUsername() {
        return dotenv.get("gitHub_username");
    }

    public static String getPassword() {
        return dotenv.get("gitHub_password");
    }

    public static boolean getIsHeadless() {
        return Boolean.parseBoolean(dotenv.get("isHeadless"));
    }
}
