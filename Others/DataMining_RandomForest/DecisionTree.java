package Others.DataMining_RandomForest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ������
 *
 * @author lyq
 */
class DecisionTree {
    // ���ĸ��ڵ�
    private TreeNode rootNode;
    // ���ݵ�����������
    private String[] featureNames;
    // �����������������
    private ArrayList<String[]> datas;
    // ����������ĵĹ�����
    private CARTTool tool;

    DecisionTree(ArrayList<String[]> datas){
        this.datas = datas;
        this.featureNames = datas.get(0);

        tool = new CARTTool(datas);
        // ͨ��CART��������о������Ĺ��������������ĸ��ڵ�
        rootNode = tool.startBuildingTree();
    }

    /**
     * ���ݸ��������������������������ж�
     *
     * @param features ��������
     */
    String decideClassType(String features){
        String classType;
        // ��ѯ������
        String[] queryFeatures;
        // �ڱ��������ж�Ӧ�Ĳ�ѯ������ֵ����
        ArrayList<String[]> featureStrs;

        featureStrs = new ArrayList<>();
        queryFeatures = features.split(",");

        String[] array;
        for (String name : featureNames) {
            for (String featureValue : queryFeatures) {
                array = featureValue.split("=");
                // ����Ӧ������ֵ���뵽�б���
                if (array[0].equals(name)) {
                    featureStrs.add(array);
                }
            }
        }

        // ��ʼ�Ӹ��ݽڵ����µݹ�����
        classType = recusiveSearchClassType(rootNode, featureStrs);

        return classType;
    }

    /**
     * �ݹ�����������ѯ���Եķ������
     *
     * @param node           ��ǰ�������Ľڵ�
     * @param remainFeatures ʣ��δ�жϵ�����
     */
    private String recusiveSearchClassType(TreeNode node,
                                           ArrayList<String[]> remainFeatures){
        String classType = null;

        // ����ڵ���������ݵ�id������˵���Ѿ����ൽ����
        if (node.getDataIndex() != null && node.getDataIndex().size() > 0) {
            classType = judgeClassType(node.getDataIndex());

            return classType;
        }

        // ȡ��ʣ�������е�һ��ƥ��������Ϊ��ǰ���ж���������
        String[] currentFeature = null;
        for (String[] featureValue : remainFeatures) {
            if (node.getAttrName().equals(featureValue[0])) {
                currentFeature = featureValue;
                break;
            }
        }

        for (TreeNode childNode : node.getChildAttrNode()) {
            // Ѱ���ӽڵ������ڴ�����ֵ�ķ�֧
            if (currentFeature != null) {
                if (childNode.getParentAttrValue().equals(currentFeature[1])) {
                    remainFeatures.remove(currentFeature);
                    classType = recusiveSearchClassType(childNode, remainFeatures);

                    // ����ҵ��˷���������ֱ������ѭ��
                    break;
                } else {
                    //���еڶ���������жϼ���!���ŵ����
                    String value = childNode.getParentAttrValue();

                    if (value.charAt(0) == '!') {
                        //ȥ����һ�����ַ�
                        value = value.substring(1, value.length());

                        if (!value.equals(currentFeature[1])) {
                            remainFeatures.remove(currentFeature);
                            classType = recusiveSearchClassType(childNode, remainFeatures);

                            break;
                        }
                    }
                }
            }
        }

        return classType;
    }

    /**
     * ���ݵõ��������з���������ľ���
     *
     * @param dataIndex ���ݷ��������������
     */
    private String judgeClassType(ArrayList<String> dataIndex){
        // �������ֵ
        String resultClassType = "";
        String classType;
        int count;
        int temp;
        Map<String, Integer> type2Num = new HashMap<>();

        for (String index : dataIndex) {
            temp = Integer.parseInt(index);
            // ȡ���һ�еľ����������
            classType = datas.get(temp)[featureNames.length - 1];

            if (type2Num.containsKey(classType)) {
                // �������Ѿ����ڣ���ʹ�������1
                count = type2Num.get(classType);
                count++;
            } else {
                count = 1;
            }

            type2Num.put(classType, count);
        }

        // ѡ���������֧�ּ�������һ�����ֵ
        count = -1;
        for (Map.Entry entry : type2Num.entrySet()) {
            if ((int) entry.getValue() > count) {
                count = (int) entry.getValue();
                resultClassType = (String) entry.getKey();
            }
        }

        return resultClassType;
    }
}
