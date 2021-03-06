package Clustering.DataMining_KMeans;

/**
 * K-means（K均值）算法调用类
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Clustering/DataMining_KMeans/input.txt";
        //聚类中心数量设定
        int classNum = 3;

        KMeansTool tool = new KMeansTool(filePath, classNum);
        tool.kMeansClustering();
    }
}
