package Others.DataMining_Chameleon;

/**
 * Chameleon(变色龙)两阶段聚类算法
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Others/DataMining_Chameleon/graphData.txt";
        //k-近邻的k设置
        int k = 1;
        //度量函数阈值
        double minMetric = 0.1;

        ChameleonTool tool = new ChameleonTool(filePath, k, minMetric);
        tool.buildCluster();
    }
}
