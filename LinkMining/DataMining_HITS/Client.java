package LinkMining.DataMining_HITS;

/**
 * HITS���ӷ����㷨
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/LinkMining/DataMining_HITS/input.txt";

        HITSTool tool = new HITSTool(filePath);
        tool.printResultPage();
    }
}
