package GraphMining.DataMining_GSpan;

/**
 * 边的频繁统计
 *
 * @author Qstar
 */
class EdgeFrequency {
    //用于存放边计数的3维数组
    int[][][] edgeFreqCount;

    EdgeFrequency(int nodeLabelNum, int edgeLabelNum){

        edgeFreqCount = new int[nodeLabelNum][edgeLabelNum][nodeLabelNum];
        //最初始化操作
        for (int i = 0; i < nodeLabelNum; i++) {
            for (int j = 0; j < edgeLabelNum; j++) {
                for (int k = 0; k < nodeLabelNum; k++) {
                    edgeFreqCount[i][j][k] = 0;
                }
            }
        }
    }

}
