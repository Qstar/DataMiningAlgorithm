package RoughSets.DataMining_RoughSets;

/**
 * ´Ö²Ú¼¯Ô¼¼òËã·¨
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
