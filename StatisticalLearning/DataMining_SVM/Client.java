package StatisticalLearning.DataMining_SVM;

/**
 * SVM֧������������������
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        //ѵ���������ļ�·��
        String trainDataPath = "/Users/Qstar/Desktop/DataMiningAlgorithm/StatisticalLearning/DataMining_SVM/trainInput.txt";
        //���������ļ�·��
        String testDataPath = "/Users/Qstar/Desktop/DataMiningAlgorithm/StatisticalLearning/DataMining_SVM/testInput.txt";

        SVMTool tool = new SVMTool(trainDataPath);
        //�Բ������ݽ���svm֧������������
        tool.svmPredictData(testDataPath);
    }

}
