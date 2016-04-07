package StatisticalLearning.DataMining_SVM.libsvm;

public class svm_parameter implements Cloneable, java.io.Serializable {
    public static final int EPSILON_SVR = 3;
    /* kernel_type �˺�������*/
    //���ͺ˺���
    public static final int LINEAR = 0;
    /* svm_type ֧��������������*/
    static final int C_SVC = 0;
    static final int NU_SVC = 1;
    //һ��svm
    static final int ONE_CLASS = 2;
    static final int NU_SVR = 4;
    //����ʽ�˺���
    static final int POLY = 1;
    //RBF���������
    static final int RBF = 2;
    //����������˺���
    static final int SIGMOID = 3;
    static final int PRECOMPUTED = 4;

    public int svm_type;
    public int kernel_type;
    // these are for training only ������Щ����ֻ���ѵ����������
    public double cache_size; // in MB
    public double eps;    // stopping criteria
    public double C;    // for C_SVC, EPSILON_SVR and NU_SVR
    public double p;    // for EPSILON_SVR
    int degree;    // for poly
    double gamma;    // for poly/rbf/sigmoid
    double coef0;    // for poly/sigmoid
    int nr_weight;        // for C_SVC
    int[] weight_label;    // for C_SVC
    double[] weight;        // for C_SVC
    double nu;    // for NU_SVC, ONE_CLASS, and NU_SVR
    int shrinking;    // use the shrinking heuristics
    int probability; // do probability estimates

    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
