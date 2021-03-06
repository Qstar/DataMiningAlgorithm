package Others.DataMining_MSApriori;

/**
 * 基于多支持度的Apriori算法测试类
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        //是否是事务型数据
        boolean isTransaction;
        //测试数据文件地址
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Others/DataMining_MSApriori/testInput.txt";
        //关系表型数据文件地址
        String tableFilePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Others/DataMining_MSApriori/testInput2.txt";
        //最小支持度阈值
        double minSup;
        // 最小置信度率
        double minConf;
        //最大支持度差别阈值
        double delta;
        //多项目的最小支持度数,括号中的下标代表的是商品的ID
        double[] mis;
        //msApriori算法工具类
        MSAprioriTool tool;

        //为了测试的方便，取一个偏低的置信度值0.3
        minConf = 0.3;
        minSup = 0.1;
        delta = 0.5;
        //每项的支持度率都默认为0.1，第一项不使用
        mis = new double[]{-1, 0.1, 0.1, 0.1, 0.1, 0.1};

        isTransaction = true;
        tool = new MSAprioriTool(filePath, minConf, delta, mis, isTransaction);
        tool.calFItems();
        System.out.println();

        isTransaction = false;
        //重新初始化数据
        tool = new MSAprioriTool(tableFilePath, minConf, minSup, isTransaction);
        tool.calFItems();
    }
}
