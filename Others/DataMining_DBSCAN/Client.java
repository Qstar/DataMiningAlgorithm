package Others.DataMining_DBSCAN;

/**
 * Dbscan基于密度的聚类算法测试类
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Others/DataMining_DBSCAN/input.txt";
        //簇扫描半径
        double eps = 3;
        //最小包含点数阈值
        int minPts = 3;

        DBSCANTool tool = new DBSCANTool(filePath, eps, minPts);
        tool.dbScanCluster();
    }
}
