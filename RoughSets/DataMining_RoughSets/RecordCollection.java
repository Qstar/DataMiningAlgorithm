package RoughSets.DataMining_RoughSets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ���ݼ�¼���ϣ�����һЩ��ͬ������
 *
 * @author lyq
 */
class RecordCollection {
    // ���ϰ���������
    private HashMap<String, String> attrValues;
    // ���ݼ�¼�б�
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
     * ���ؼ��ϵ��ַ���������
     */
    ArrayList<String> getRecordNames(){
        return recordList
                .stream()
                .map(Record::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * �жϼ����Ƿ�������������ƶ�Ӧ������ֵ
     *
     * @param attrName ������
     */
    boolean isContainedAttrName(String attrName){
        boolean isContained = false;

        if (this.attrValues.containsKey(attrName)) {
            isContained = true;
        }

        return isContained;
    }

    /**
     * �ж�2�������Ƿ���ȣ��Ƚϰ��������ݼ�¼�Ƿ���ȫһ��
     *
     * @param rc ���Ƚϼ���
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

            // �����1����¼�����������㼯�ϲ����
            if (!isSame) {
                break;
            }
        }

        return isSame;
    }

    /**
     * ����֮��Ľ�����
     *
     * @param rc ������Ĳ������������һ����
     */
    RecordCollection overlapCalculate(RecordCollection rc){
        String key;
        String value;
        RecordCollection resultCollection;
        HashMap<String, String> resultAttrValues = new HashMap<>();
        ArrayList<Record> resultRecords = new ArrayList<>();

        // ���м��ϵĽ����㣬����ͬ�ļ�¼����������
        for (Record record : this.recordList) {
            for (Record record2 : rc.recordList) {
                if (record.isRecordSame(record2)) {
                    resultRecords.add(record);
                    break;
                }
            }
        }

        // ���û�н�������ֱ�ӷ���
        if (resultRecords.size() == 0) {
            return null;
        }

        // ��2�����ϵ����Խ��кϲ�
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
     * �󼯺ϵĲ��������Ա������Ե�����
     *
     * @param rc ���ϲ��ļ���
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
     * ��������а�����Ԫ��
     */
    void printRc(){
        System.out.print("{");
        for (Record r : this.getRecord()) {
            System.out.print(r.getName() + ", ");
        }
        System.out.println("}");
    }
}
