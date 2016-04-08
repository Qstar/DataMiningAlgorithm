package RoughSets.DataMining_RoughSets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 数据记录集合，包含一些共同的属性
 *
 * @author Qstar
 */
class RecordCollection {
    // 集合包含的属性
    private HashMap<String, String> attrValues;
    // 数据记录列表
    private ArrayList<Record> recordList;

    RecordCollection(){
        this.attrValues = new HashMap<>();
        this.recordList = new ArrayList<>();
    }

    RecordCollection(HashMap<String, String> attrValues,
                     ArrayList<Record> recordList){
        this.attrValues = attrValues;
        this.recordList = recordList;
    }

    ArrayList<Record> getRecord(){
        return this.recordList;
    }

    /**
     * 返回集合的字符名称数组
     */
    ArrayList<String> getRecordNames(){
        return recordList
                .stream()
                .map(Record::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * 判断集合是否包含此属性名称对应的属性值
     *
     * @param attrName 属性名
     */
    boolean isContainedAttrName(String attrName){
        boolean isContained = false;

        if (this.attrValues.containsKey(attrName)) {
            isContained = true;
        }

        return isContained;
    }

    /**
     * 判断2个集合是否相等，比较包含的数据记录是否完全一致
     *
     * @param rc 待比较集合
     */
    boolean isCollectionSame(RecordCollection rc){
        boolean isSame = false;

        for (Record r : recordList) {
            isSame = false;

            for (Record r2 : rc.recordList) {
                if (r.isRecordSame(r2)) {
                    isSame = true;
                    break;
                }
            }

            // 如果有1个记录不包含，就算集合不相等
            if (!isSame) {
                break;
            }
        }

        return isSame;
    }

    /**
     * 集合之间的交运算
     *
     * @param rc 交运算的参与运算的另外一集合
     */
    RecordCollection overlapCalculate(RecordCollection rc){
        String key;
        String value;
        RecordCollection resultCollection;
        HashMap<String, String> resultAttrValues = new HashMap<>();
        ArrayList<Record> resultRecords = new ArrayList<>();

        // 进行集合的交运算，有相同的记录的则进行添加
        for (Record record : this.recordList) {
            for (Record record2 : rc.recordList) {
                if (record.isRecordSame(record2)) {
                    resultRecords.add(record);
                    break;
                }
            }
        }

        // 如果没有交集，则直接返回
        if (resultRecords.size() == 0) {
            return null;
        }

        // 将2个集合的属性进行合并
        for (Map.Entry entry : this.attrValues.entrySet()) {
            key = (String) entry.getKey();
            value = (String) entry.getValue();

            resultAttrValues.put(key, value);
        }

        for (Map.Entry entry : rc.attrValues.entrySet()) {
            key = (String) entry.getKey();
            value = (String) entry.getValue();

            resultAttrValues.put(key, value);
        }

        resultCollection = new RecordCollection(resultAttrValues, resultRecords);
        return resultCollection;
    }

    /**
     * 求集合的并集，各自保留各自的属性
     *
     * @param rc 待合并的集合
     */
    RecordCollection unionCal(RecordCollection rc){
        RecordCollection resultRc;
        ArrayList<Record> records = new ArrayList<>();

        records.addAll(this.recordList);
        records.addAll(rc.recordList);

        resultRc = new RecordCollection(null, records);
        return resultRc;
    }

    /**
     * 输出集合中包含的元素
     */
    void printRc(){
        System.out.print("{");
        for (Record r : this.getRecord()) {
            System.out.print(r.getName() + ", ");
        }
        System.out.println("}");
    }
}
