package Classification.DataMining_ID3;

/**
 * ID3决策树分类算法测试场景类
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Classification/DataMining_ID3/input.txt";

        ID3Tool tool = new ID3Tool(filePath);
        tool.startBuildingTree(true);
    }
}
