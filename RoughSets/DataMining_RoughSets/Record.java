package RoughSets.DataMining_RoughSets;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���ݼ�¼������������¼��������
 *
 * @author Qstar
 */
class Record {
    // ��¼����
    private String name;
    // ��¼���Լ�ֵ��
    private HashMap<String, String> attrValues;

    Record(String name, HashMap<String, String> attrValues){
        this.name = name;
        this.attrValues = attrValues;
    }

    public String getName(){
        return this.name;
    }

    /**
     * �������Ƿ����������ֵ
     *
     * @param attr ���ж�����ֵ
     */
    boolean isContainedAttr(String attr){
        boolean isContained = false;

        if (attrValues.containsValue(attr)) {
            isContained = true;
        }

        return isContained;
    }

    /**
     * �ж����ݼ�¼�Ƿ���ͬһ����¼�����������������ж�
     *
     * @param record Ŀ��Ƚ϶���
     */
    boolean isRecordSame(Record record){
        boolean isSame = false;

        if (this.name.equals(record.name)) {
            isSame = true;
        }

        return isSame;
    }

    /**
     * ���ݵľ������Է���
     */
    String getRecordDecisionClass(){
        return attrValues.get(RoughSetsTool.DECISION_ATTR_NAME);
    }

    /**
     * ����Լ������������߹���
     *
     * @param reductAttr Լ�����Լ���
     */
    String getDecisionRule(ArrayList<String> reductAttr){
        String ruleStr = "";
        String attrName;
        String value;
        String decisionValue;

        decisionValue = attrValues.get(RoughSetsTool.DECISION_ATTR_NAME);
        ruleStr += "����";
        for (Map.Entry entry : this.attrValues.entrySet()) {
            attrName = (String) entry.getKey();
            value = (String) entry.getValue();

            if (attrName.equals(RoughSetsTool.DECISION_ATTR_NAME)
                    || reductAttr.contains(attrName) || value.equals(name)) {
                continue;
            }

            ruleStr += MessageFormat.format("{0}={1},", attrName, value);
        }
        ruleStr += "���ķ���Ϊ" + decisionValue;

        return ruleStr;
    }
}
