package Classification.DataMining_ID3;

import java.util.ArrayList;

/**
 * ���Խڵ㣬����Ҷ�ӽڵ�
 *
 * @author lyq
 */
class AttrNode {
    //��ǰ���Ե�����
    private String attrName;
    //���ڵ�ķ�������ֵ
    private String parentAttrValue;
    //�����ӽڵ�
    private AttrNode[] childAttrNode;
    //����Ҷ�ӽڵ�
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
