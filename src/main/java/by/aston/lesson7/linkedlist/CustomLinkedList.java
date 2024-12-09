package by.aston.lesson7.linkedlist;

import java.util.ArrayList;

public class CustomLinkedList {

    private ArrayList<CustomNode> nodes = new ArrayList<>();

    void addLast(Object object) {
        CustomNode customNode = new CustomNode(object, null, null);
        if (nodes.size() == 0) {
            nodes.add(customNode);
        } else {
            CustomNode customNodeLast = nodes.get(nodes.size() - 1);
            customNodeLast.setNext(customNode);
            customNode.setPrevious(customNodeLast);
            nodes.add(customNode);
        }
    }

    void addByIndex(Object object, int index) {
        //str1   str3
        //   str2
        CustomNode str1 = nodes.get(index - 1); //получили предыдущий
        CustomNode str3 = nodes.get(index); //получили следующий
        CustomNode str2 = new CustomNode(object, str3, str1); //создали вставляемый объект CustomNode

        str1.setNext(str2);
        str3.setPrevious(str1);

//        nodes.set(index - 1, str1);
        nodes.add(index, str2);
//        nodes.set(index + 1, str3);


    }

}
