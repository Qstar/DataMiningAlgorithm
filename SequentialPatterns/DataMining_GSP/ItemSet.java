package SequentialPatterns.DataMining_GSP;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 序列中的子项集
 *
 * @author Qstar
 */
class ItemSet {
    /**
     * 项集中保存的是数字项数组
     */
    private ArrayList<Integer> items;

    ItemSet(String[] itemStr){
        items = new ArrayList<>();
        for (String s : itemStr) {
            items.add(Integer.parseInt(s));
        }
    }

    ItemSet(int[] itemNum){
        items = new ArrayList<>();
        for (int num : itemNum) {
            items.add(num);
        }
    }

    ItemSet(ArrayList<Integer> itemNum){
        this.items = itemNum;
    }

    ArrayList<Integer> getItems(){
        return items;
    }

    /**
     * 判断2个项集是否相等
     *
     * @param itemSet 比较对象
     */
    boolean compareIsSame(ItemSet itemSet){
        boolean result = true;

        if (this.items.size() != itemSet.items.size()) {
            return false;
        }

        for (int i = 0; i < itemSet.items.size(); i++) {
            if (!Objects.equals(this.items.get(i), itemSet.items.get(i))) {
                // 只要有值不相等，直接算作不相等
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * 拷贝项集中同样的数据一份
     */
    ArrayList<Integer> copyItems(){
        ArrayList<Integer> copyItems = new ArrayList<>();

        copyItems.addAll(this.items);

        return copyItems;
    }
}
