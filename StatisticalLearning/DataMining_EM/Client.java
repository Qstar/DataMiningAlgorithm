package StatisticalLearning.DataMining_EM;

/**
 * EM��������㷨����������
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/StatisticalLearning/DataMining_EM/input.txt";

        EMTool tool = new EMTool(filePath);
        tool.readDataFile();
        tool.exceptMaxStep();
    }
}
