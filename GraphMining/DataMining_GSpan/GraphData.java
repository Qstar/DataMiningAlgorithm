package GraphMining.DataMining_GSpan;

import java.util.ArrayList;

/**
 * ͼ��������
 *
 * @author Qstar
 */
class GraphData {
    // �ڵ�����
    private ArrayList<Integer> nodeLabels;
    // �ڵ��Ƿ����,���ܱ��Ƴ�
    private ArrayList<Boolean> nodeVisibles;
    // �ߵļ��ϱ��
    private ArrayList<Integer> edgeLabels;
    // �ߵ�һ�ߵ�id
    private ArrayList<Integer> edgeX;
    // �ߵ���һ�ߵĵ�id
    private ArrayList<Integer> edgeY;
    // ���Ƿ����
    private ArrayList<Boolean> edgeVisibles;

    GraphData(){
        nodeLabels = new ArrayList<>();
        nodeVisibles = new ArrayList<>();

        edgeLabels = new ArrayList<>();
        edgeX = new ArrayList<>();
        edgeY = new ArrayList<>();
        edgeVisibles = new ArrayList<>();
    }

    ArrayList<Integer> getNodeLabels(){
        return nodeLabels;
    }

    ArrayList<Boolean> getNodeVisibles(){
        return nodeVisibles;
    }

    ArrayList<Integer> getEdgeLabels(){
        return edgeLabels;
    }

    ArrayList<Integer> getEdgeX(){
        return edgeX;
    }

    ArrayList<Integer> getEdgeY(){
        return edgeY;
    }

    ArrayList<Boolean> getEdgeVisibles(){
        return edgeVisibles;
    }

    /**
     * ���ݵ��Ƶ�����Ƴ�ͼ�в�Ƶ���ĵ��
     *
     * @param freqNodeLabel   ���Ƶ����ͳ��
     * @param freqEdgeLabel   �ߵ�Ƶ����ͳ��
     * @param minSupportCount ��С֧�ֶȼ���
     */
    void removeInFreqNodeAndEdge(int[] freqNodeLabel,
                                 int[] freqEdgeLabel, int minSupportCount){
        int label;
        int x;
        int y;

        for (int i = 0; i < nodeLabels.size(); i++) {
            label = nodeLabels.get(i);
            if (freqNodeLabel[label] < minSupportCount) {
                // ���С��֧�ֶȼ�������˵㲻����
                nodeVisibles.set(i, false);
            }
        }

        for (int i = 0; i < edgeLabels.size(); i++) {
            label = edgeLabels.get(i);

            if (freqEdgeLabel[label] < minSupportCount) {
                // ���С��֧�ֶȼ�������˱߲�����
                edgeVisibles.set(i, false);
                continue;
            }

            // ����˱ߵ�ĳ���˵Ķ˵��Ѿ��������ˣ���˱�Ҳ������,x,y��ʾid��
            x = edgeX.get(i);
            y = edgeY.get(i);
            if (!nodeVisibles.get(x) || !nodeVisibles.get(y)) {
                edgeVisibles.set(i, false);
            }
        }
    }

    /**
     * ���ݱ���������¶����������ĵ�����±��
     *
     * @param nodeLabel2Rank ������
     * @param edgeLabel2Rank ������
     */
    void reLabelByRank(int[] nodeLabel2Rank, int[] edgeLabel2Rank){
        int label;
        int count = 0;
        int temp;
        // �ɵ�id����id�ŵ�ӳ��
        int[] oldId2New = new int[nodeLabels.size()];
        for (int i = 0; i < nodeLabels.size(); i++) {
            label = nodeLabels.get(i);

            // �����ǰ���ǿ��õģ����˱�ŵ���������Ϊ�˵��µı��
            if (nodeVisibles.get(i)) {
                nodeLabels.set(i, nodeLabel2Rank[label]);
                oldId2New[i] = count;
                count++;
            }
        }

        for (int i = 0; i < edgeLabels.size(); i++) {
            label = edgeLabels.get(i);

            // �����ǰ���ǿ��õģ����˱�ŵ���������Ϊ�˵��µı��
            if (edgeVisibles.get(i)) {
                edgeLabels.set(i, edgeLabel2Rank[label]);

                // �Դ˵���x,y��id���滻
                temp = edgeX.get(i);
                edgeX.set(i, oldId2New[temp]);
                temp = edgeY.get(i);
                edgeY.set(i, oldId2New[temp]);
            }
        }
    }
}
