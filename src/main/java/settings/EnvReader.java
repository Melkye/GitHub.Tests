package settings;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvReader {
    private final Dotenv dotenv;
    public EnvReader() {
        dotenv = Dotenv.configure().directory("src/main/java/settings").load();
    }

    public String getUsername() {
        return dotenv.get("gitHub_username");
    }

    public String getPassword() {
        return dotenv.get("gitHub_password");
    }
}
