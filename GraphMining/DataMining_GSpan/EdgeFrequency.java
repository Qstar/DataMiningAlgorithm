package GraphMining.DataMining_GSpan;

/**
 * �ߵ�Ƶ��ͳ��
 *
 * @author Qstar
 */
class EdgeFrequency {
    //���ڴ�ű߼�����3ά����
    int[][][] edgeFreqCount;

    EdgeFrequency(int nodeLabelNum, int edgeLabelNum){

        edgeFreqCount = new int[nodeLabelNum][edgeLabelNum][nodeLabelNum];
        //���ʼ������
        for (int i = 0; i < nodeLabelNum; i++) {
            for (int j = 0; j < edgeLabelNum; j++) {
                for (int k = 0; k < nodeLabelNum; k++) {
                    edgeFreqCount[i][j][k] = 0;
                }
            }
        }
    }

}
