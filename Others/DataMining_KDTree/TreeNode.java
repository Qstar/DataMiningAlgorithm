package Others.DataMining_KDTree;

/**
 * KD���ڵ�
 *
 * @author Qstar
 */
class TreeNode {
    //����ʸ��
    Point nodeData;
    //�ָ�ƽ��ķָ���
    int spilt;
    //�ռ�ʸ�����ýڵ�����ʾ�Ŀռ䷶Χ
    Range range;
    //���ڵ�
    TreeNode parentNode;
    //λ�ڷָƽ�����ĺ��ӽڵ�
    TreeNode leftNode;
    //λ�ڷָƽ���Ҳ�ĺ��ӽڵ�
    TreeNode rightNode;
    //�ڵ��Ƿ񱻷��ʹ�,���ڻ���ʱʹ��
    boolean isVisited;

    TreeNode(){
        this.isVisited = false;
    }
}
