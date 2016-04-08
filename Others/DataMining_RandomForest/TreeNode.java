package Others.DataMining_RandomForest;

import java.util.ArrayList;

/**
 * 回归分类树节点
 *
 * @author Qstar
 */
class TreeNode {
    // 节点属性名字
    private String attrName;
    // 节点索引标号
    private int nodeIndex;
    //包含的叶子节点数
    private int leafNum;
    // 节点误差率
    private double alpha;
    // 父亲分类属性值
    private String parentAttrValue;
    // 孩子节点
    private TreeNode[] childAttrNode;
    // 数据记录索引
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
