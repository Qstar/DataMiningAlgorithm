package Clustering.DataMining_BIRCH;

/**
 * BIRCH聚类算法调用类
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Clustering/DataMining_BIRCH/testInput.txt";
        //内部节点平衡因子B
        int B = 2;
        //叶子节点平衡因子L
        int L = 2;
        //簇直径阈值T
        double T = 0.6;

        BIRCHTool tool = new BIRCHTool(filePath, B, L, T);
        tool.startBuilding();
    }
}
