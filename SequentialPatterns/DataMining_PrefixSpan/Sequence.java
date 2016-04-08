package SequentialPatterns.DataMining_PrefixSpan;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * ������
 *
 * @author Qstar
 */
class Sequence {
    // �����ڵ��
    private ArrayList<ItemSet> itemSetList;

    Sequence(){
        this.itemSetList = new ArrayList<>();
    }

    ArrayList<ItemSet> getItemSetList(){
        return itemSetList;
    }

    /**
     * �жϵ�һ���Ƿ�����ڴ�����
     *
     * @param c ���ж���
     */
    boolean strIsContained(String c){
        boolean isContained = false;

        for (ItemSet itemSet : itemSetList) {
            isContained = false;

            for (String s : itemSet.getItems()) {
                if (itemSet.getItems().contains("_")) {
                    continue;
                }

                if (s.equals(c)) {
                    isContained = true;
                    break;
                }
            }

            if (isContained) {
                // ����Ѿ����������ˣ�ֱ������ѭ��
                break;
            }
        }

        return isContained;
    }

    /**
     * �ж������Ƿ������������
     *
     * @param itemSet ��ϵ����Ԫ�س���1��
     */
    boolean compoentItemIsContain(ItemSet itemSet){
        boolean isContained = false;
        ArrayList<String> tempItems;
        String lastItem = itemSet.getLastValue();

        for (ItemSet anItemSetList : this.itemSetList) {
            tempItems = anItemSetList.getItems();
            // ��2��������ң���һ�ִ�_X���ҳ�x���������Ԫ�أ���Ϊ_ǰ׺�Ѿ�Ϊԭ����Ԫ��
            if (tempItems.size() > 1 && tempItems.get(0).equals("_")
                    && tempItems.get(1).equals(lastItem)) {
                isContained = true;
                break;
            } else if (!tempItems.get(0).equals("_")) {
                // ��û��_ǰ׺�����ʼѰ�ң��ڶ���Ϊ�Ӻ���ĺ�׺���ҳ�ֱ���ҳ������ַ�ΪabΪͬһ����
                if (strArrayContains(tempItems, itemSet.getItems())) {
                    isContained = true;
                    break;
                }
            }
        }
        return isContained;
    }

    /**
     * ɾ��������
     *
     * @param s ��ɾ����
     */
    void deleteSingleItem(String s){
        ArrayList<String> tempItems;
        ArrayList<String> deleteItems;

        for (ItemSet itemSet : this.itemSetList) {
            tempItems = itemSet.getItems();
            deleteItems = new ArrayList<>();

            deleteItems.addAll(tempItems
                    .stream()
                    .filter(tempItem -> tempItem.equals(s))
                    .collect(Collectors.toList()));

            tempItems.removeAll(deleteItems);
        }
    }

    /**
     * ��ȡ��s֮�����õ�����
     *
     * @param s Ŀ����ȡ��s
     */
    Sequence extractItem(String s){
        Sequence extractSeq = this.copySeqence();
        ItemSet itemSet;
        ArrayList<String> items;
        ArrayList<ItemSet> deleteItemSets = new ArrayList<>();
        ArrayList<String> tempItems = new ArrayList<>();

        for (int k = 0; k < extractSeq.itemSetList.size(); k++) {
            itemSet = extractSeq.itemSetList.get(k);
            items = itemSet.getItems();
            if (items.size() == 1 && items.get(0).equals(s)) {
                //����ҵ����ǵ������ȫ�Ƴ�������ѭ��
                extractSeq.itemSetList.remove(k);
                break;
            } else if (items.size() > 1 && !items.get(0).equals("_")) {
                //�ں����Ķ�Ԫ�������ж��Ƿ������Ԫ��
                if (items.contains(s)) {
                    //���������s�����Ԫ�ؼ��뵽��ʱ�ַ�������
                    int index = items.indexOf(s);
                    for (int j = index; j < items.size(); j++) {
                        tempItems.add(items.get(j));
                    }
                    //����һλ��s����±��"_"
                    tempItems.set(0, "_");
                    if (tempItems.size() == 1) {
                        // �����ƥ��Ϊ����ĩ�ˣ�ͬ���Ƴ�
                        deleteItemSets.add(itemSet);
                    } else {
                        //���仯�����滻ԭ����
                        extractSeq.itemSetList.set(k, new ItemSet(tempItems));
                    }
                    break;
                } else {
                    deleteItemSets.add(itemSet);
                }
            } else {
                // ����������2��������ͳͳ�Ƴ�
                deleteItemSets.add(itemSet);
            }
        }
        extractSeq.itemSetList.removeAll(deleteItemSets);

        return extractSeq;
    }

    /**
     * ��ȡ�����֮�������
     *
     * @param array �������
     */
    Sequence extractCompoentItem(ArrayList<String> array){
        // �ҵ�Ŀ����Ƿ�����ֹͣ
        Sequence seq = this.copySeqence();
        String lastItem = array.get(array.size() - 1);
        ArrayList<String> tempItems;
        ArrayList<ItemSet> deleteItems = new ArrayList<>();

        for (int i = 0; i < seq.itemSetList.size(); i++) {

            tempItems = seq.itemSetList.get(i).getItems();
            // ��2��������ң���һ�ִ�_X���ҳ�x���������Ԫ�أ���Ϊ_ǰ׺�Ѿ�Ϊԭ����Ԫ��
            if (tempItems.size() > 1 && tempItems.get(0).equals("_")
                    && tempItems.get(1).equals(lastItem)) {
                if (tempItems.size() == 2) {
                    seq.itemSetList.remove(i);
                } else {
                    // ��1��λ�ñ�Ϊ�±��"_"��������1���ַ���λ��
                    tempItems.set(1, "_");
                    // �Ƴ���һ����"_"�»���
                    tempItems.remove(0);
                }
                break;
            } else if (!tempItems.get(0).equals("_")) {
                // ��û��_ǰ׺�����ʼѰ�ң��ڶ���Ϊ�Ӻ���ĺ�׺���ҳ�ֱ���ҳ������ַ�ΪabΪͬһ����
                if (strArrayContains(tempItems, array)) {
                    // ���������ҳ���һ�������ַ���λ�ã��Ѻ���Ĳ��ֽ�ȡ����
                    int index = tempItems.indexOf(lastItem);
                    ArrayList<String> array2 = new ArrayList<>();

                    for (int j = index; j < tempItems.size(); j++) {
                        array2.add(tempItems.get(j));
                    }
                    array2.set(0, "_");

                    if (array2.size() == 1) {
                        //���������ĩβ��λ�ã����Ƴ������������滻
                        deleteItems.add(seq.itemSetList.get(i));
                    } else {
                        seq.itemSetList.set(i, new ItemSet(array2));
                    }
                    break;
                } else {
                    deleteItems.add(seq.itemSetList.get(i));
                }
            } else {
                // ��������Ǵ���_X��X���������һ��Ԫ�ص����
                deleteItems.add(seq.itemSetList.get(i));
            }
        }

        seq.itemSetList.removeAll(deleteItems);

        return seq;
    }

    /**
     * ���һ������
     */
    Sequence copySeqence(){
        Sequence copySeq = new Sequence();
        ItemSet tempItemSet;
        ArrayList<String> items;

        for (ItemSet itemSet : this.itemSetList) {
            items = (ArrayList<String>) itemSet.getItems().clone();
            tempItemSet = new ItemSet(items);
            copySeq.getItemSetList().add(tempItemSet);
        }

        return copySeq;
    }

    /**
     * ��ȡ���������һ��������1��Ԫ��
     */
    public String getLastItemSetValue(){
        int size = this.getItemSetList().size();
        ItemSet itemSet = this.getItemSetList().get(size - 1);
        size = itemSet.getItems().size();

        return itemSet.getItems().get(size - 1);
    }

    /**
     * �ж�strList2�Ƿ���strList1��������
     *
     * @param strList1 ����1
     * @param strList2 ����2
     */
    private boolean strArrayContains(ArrayList<String> strList1,
                                     ArrayList<String> strList2){
        boolean isContained = false;

        for (int i = 0; i < strList1.size() - strList2.size() + 1; i++) {
            isContained = true;

            for (int j = 0, k = i; j < strList2.size(); j++, k++) {
                if (!strList1.get(k).equals(strList2.get(j))) {
                    isContained = false;
                    break;
                }
            }

            if (isContained) {
                break;
            }
        }

        return isContained;
    }
}
