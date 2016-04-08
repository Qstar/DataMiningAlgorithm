package SequentialPatterns.DataMining_GSP;

import java.util.ArrayList;
import java.util.Objects;

/**
 * �����е����
 *
 * @author Qstar
 */
class ItemSet {
    /**
     * ��б����������������
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
     * �ж�2����Ƿ����
     *
     * @param itemSet �Ƚ϶���
     */
    boolean compareIsSame(ItemSet itemSet){
        boolean result = true;

        if (this.items.size() != itemSet.items.size()) {
            return false;
        }

        for (int i = 0; i < itemSet.items.size(); i++) {
            if (!Objects.equals(this.items.get(i), itemSet.items.get(i))) {
                // ֻҪ��ֵ����ȣ�ֱ�����������
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * �������ͬ��������һ��
     */
    ArrayList<Integer> copyItems(){
        ArrayList<Integer> copyItems = new ArrayList<>();

        copyItems.addAll(this.items);

        return copyItems;
    }
}
