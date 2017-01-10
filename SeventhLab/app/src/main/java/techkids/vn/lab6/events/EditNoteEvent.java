package techkids.vn.lab6.events;

import techkids.vn.lab6.networks.jsonmodels.responsemodels.ToDoResponseBody;

/**
 * Created by Lush on 12/25/2016.
 */

public class EditNoteEvent {
    private ToDoResponseBody toDoResponseBody;

    public EditNoteEvent(ToDoResponseBody toDoResponseBody) {
        this.toDoResponseBody = toDoResponseBody;
    }

    public ToDoResponseBody getToDoResponseBody() {
        return toDoResponseBody;
    }
}
