package SequentialPatterns.DataMining_PrefixSpan;

import java.util.ArrayList;
import java.util.Collections;

/**
 * �ַ����
 *
 * @author lyq
 */
class ItemSet {
    // ��ڵ��ַ�
    private ArrayList<String> items;

    public ItemSet(String[] str){
        items = new ArrayList<>();
        Collections.addAll(items, str);
    }

    ItemSet(ArrayList<String> itemsList){
        this.items = itemsList;
    }

    ItemSet(String s){
        items = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            items.add(s.charAt(i) + "");
        }
    }

    ArrayList<String> getItems(){
        return items;
    }

    /**
     * ��ȡ����1��Ԫ��
     */
    String getLastValue(){
        int size = this.items.size();

        return this.items.get(size - 1);
    }
}
