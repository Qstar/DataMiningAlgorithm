package SequentialPatterns.DataMining_PrefixSpan;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符项集类
 *
 * @author lyq
 */
class ItemSet {
    // 项集内的字符
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
     * 获取项集最后1个元素
     */
    String getLastValue(){
        int size = this.items.size();

        return this.items.get(size - 1);
    }
}
