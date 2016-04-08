package Others.DataMining_RandomForest;

import java.util.ArrayList;

/**
 * �ع�������ڵ�
 *
 * @author Qstar
 */
class TreeNode {
    // �ڵ���������
    private String attrName;
    // �ڵ��������
    private int nodeIndex;
    //������Ҷ�ӽڵ���
    private int leafNum;
    // �ڵ������
    private double alpha;
    // ���׷�������ֵ
    private String parentAttrValue;
    // ���ӽڵ�
    private TreeNode[] childAttrNode;
    // ���ݼ�¼����
    private ArrayList<String> dataIndex;

    public String getAttrName(){
        return attrName;
    }

    public void setAttrName(String attrName){
        this.attrName = attrName;
    }

    int getNodeIndex(){
        return nodeIndex;
    }

    void setNodeIndex(int nodeIndex){
        this.nodeIndex = nodeIndex;
    }

    double getAlpha(){
        return alpha;
    }

    void setAlpha(double alpha){
        this.alpha = alpha;
    }

    String getParentAttrValue(){
        return parentAttrValue;
    }

    void setParentAttrValue(String parentAttrValue){
        this.parentAttrValue = parentAttrValue;
    }

    TreeNode[] getChildAttrNode(){
        return childAttrNode;
    }

    void setChildAttrNode(TreeNode[] childAttrNode){
        this.childAttrNode = childAttrNode;
    }

    ArrayList<String> getDataIndex(){
        return dataIndex;
    }

    void setDataIndex(ArrayList<String> dataIndex){
        this.dataIndex = dataIndex;
    }

    int getLeafNum(){
        return leafNum;
    }

    void setLeafNum(int leafNum){
        this.leafNum = leafNum;
    }


}
