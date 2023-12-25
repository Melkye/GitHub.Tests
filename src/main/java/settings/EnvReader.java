package settings;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvReader {
    private final Dotenv dotenv;
    public EnvReader() {
        dotenv = Dotenv.configure().load();
    }

    public String getUsername() {
        return dotenv.get("username");
    }

    public String getPassword() {
        return dotenv.get("password");
    }
}
