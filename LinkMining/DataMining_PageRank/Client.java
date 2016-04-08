package LinkMining.DataMining_PageRank;

/**
 * PageRank计算网页重要性/排名算法
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/LinkMining/DataMining_PageRank/input.txt";

        PageRankTool tool = new PageRankTool(filePath);
        tool.printPageRankValue();
    }
}
