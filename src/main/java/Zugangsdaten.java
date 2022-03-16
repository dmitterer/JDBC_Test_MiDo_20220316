

public class Zugangsdaten extends Entitaet {

    private String username;
    private String passwort;
    private String url;

    public Zugangsdaten(Long id, String username, String passwort, String url) throws FalscherWertException {
        super(id);
        this.username = username;
        this.passwort = passwort;
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
