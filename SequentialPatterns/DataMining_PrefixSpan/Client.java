package SequentialPatterns.DataMining_PrefixSpan;

/**
 * PrefixSpan序列模式挖掘算法
 *
 * @author lyq
 */
public class Client {
    public static void main(String[] agrs){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/SequentialPatterns/DataMining_PrefixSpan/input.txt";
        //最小支持度阈值率
        double minSupportRate = 0.4;

        PrefixSpanTool tool = new PrefixSpanTool(filePath, minSupportRate);
        tool.prefixSpanCalculate();
    }
}

