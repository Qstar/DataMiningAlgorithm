package Classification.DataMining_NaiveBayes;


/**
 * ���ر�Ҷ˹�㷨����������
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        //ѵ��������
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Classification/DataMining_NaiveBayes/input.txt";
        String testData = "Youth Medium Yes Fair";
        NaiveBayesTool tool = new NaiveBayesTool(filePath);
        System.out.println(testData + " ���ݵķ���Ϊ:" + tool.naiveBayesClassificate(testData));
    }
}
