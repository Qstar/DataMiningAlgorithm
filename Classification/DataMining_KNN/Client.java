package Classification.DataMining_KNN;

/**
 * k最近邻算法场景类型
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        String trainDataPath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Classification/DataMining_KNN/trainInput.txt";
        String testDataPath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Classification/DataMining_KNN/testinput.txt";

        KNNTool tool = new KNNTool(trainDataPath, testDataPath);
        tool.knnCompute(3);
    }
}
