package techkids.vn.lab6.events;

/**
 * Created by Lush on 12/18/2016.
 */

public class OnButtonClickEvent {
    private String message;
    private String token;

    public OnButtonClickEvent(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }
}
