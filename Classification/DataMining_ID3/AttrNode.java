package Classification.DataMining_ID3;

import java.util.ArrayList;

/**
 * 属性节点，不是叶子节点
 *
 * @author lyq
 */
class AttrNode {
    //当前属性的名字
    private String attrName;
    //父节点的分类属性值
    private String parentAttrValue;
    //属性子节点
    private AttrNode[] childAttrNode;
    //孩子叶子节点
    private ArrayList<String> childDataIndex;

    public String getAttrName(){
        return attrName;
    }

    public void setAttrName(String attrName){
        this.attrName = attrName;
    }

    AttrNode[] getChildAttrNode(){
        return childAttrNode;
    }

    void setChildAttrNode(AttrNode[] childAttrNode){
        this.childAttrNode = childAttrNode;
    }

    String getParentAttrValue(){
        return parentAttrValue;
    }

    void setParentAttrValue(String parentAttrValue){
        this.parentAttrValue = parentAttrValue;
    }

    ArrayList<String> getChildDataIndex(){
        return childDataIndex;
    }

    void setChildDataIndex(ArrayList<String> childDataIndex){
        this.childDataIndex = childDataIndex;
    }
}
