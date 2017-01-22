
package com.score.mauriziopietrantuono.model.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoachingSummary {

    @SerializedName("activeTodo")
    @Expose
    private boolean activeTodo;
    @SerializedName("activeChat")
    @Expose
    private boolean activeChat;
    @SerializedName("numberOfTodoItems")
    @Expose
    private int numberOfTodoItems;
    @SerializedName("numberOfCompletedTodoItems")
    @Expose
    private int numberOfCompletedTodoItems;
    @SerializedName("selected")
    @Expose
    private boolean selected;

    public boolean isActiveTodo() {
        return activeTodo;
    }

    public void setActiveTodo(boolean activeTodo) {
        this.activeTodo = activeTodo;
    }

    public boolean isActiveChat() {
        return activeChat;
    }

    public void setActiveChat(boolean activeChat) {
        this.activeChat = activeChat;
    }

    public int getNumberOfTodoItems() {
        return numberOfTodoItems;
    }

    public void setNumberOfTodoItems(int numberOfTodoItems) {
        this.numberOfTodoItems = numberOfTodoItems;
    }

    public int getNumberOfCompletedTodoItems() {
        return numberOfCompletedTodoItems;
    }

    public void setNumberOfCompletedTodoItems(int numberOfCompletedTodoItems) {
        this.numberOfCompletedTodoItems = numberOfCompletedTodoItems;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
