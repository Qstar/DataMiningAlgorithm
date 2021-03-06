package AssociationAnalysis.DataMining_FPTree;

/**
 * FPTree频繁模式树算法
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/AssociationAnalysis/DataMining_FPTree/testInput.txt";
        //最小支持度阈值
        int minSupportCount = 2;

        FPTreeTool tool = new FPTreeTool(filePath, minSupportCount);
        tool.startBuildingTree();
    }
}
