package BaggingAndBoosting.DataMining_AdaBoost;

/**
 * AdaBoost�����㷨������
 * @author Qstar
 *
 */
public class Client {
	public static void main(String[] agrs){
		String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/BaggingAndBoosting/DataMining_AdaBoost/input.txt";
		//�������ֵ
		double errorValue = 0.2;
		
		AdaBoostTool tool = new AdaBoostTool(filePath, errorValue);
		tool.adaBoostClassify();
	}
}
