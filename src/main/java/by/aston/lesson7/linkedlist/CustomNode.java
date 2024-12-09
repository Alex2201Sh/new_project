package by.aston.lesson7.linkedlist;

public class CustomNode {
    private Object content;
    private CustomNode next;
    private CustomNode previous;

    public CustomNode(Object content, CustomNode next, CustomNode previous) {
        this.content = content;
        this.next = next;
        this.previous = previous;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(CustomNode next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(CustomNode previous) {
        this.previous = previous;
    }
}
