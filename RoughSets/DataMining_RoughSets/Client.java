package RoughSets.DataMining_RoughSets;

/**
 * �ֲڼ�Լ���㷨
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/RoughSets/DataMining_RoughSets/input.txt";

        RoughSetsTool tool = new RoughSetsTool(filePath);
        tool.findingReduct();
    }
}
