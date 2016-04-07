package Classification.DataMining_KNN;

/**
 * ����������
 *
 * @author lyq
 */
class Sample implements Comparable<Sample> {
    // �������ݵķ�������
    private String className;
    // �������ݵ���������
    private String[] features;
    //��������֮��ļ��ֵ���Դ�������
    private Integer distance;

    Sample(String[] features){
        this.features = features;
    }

    Sample(String className, String[] features){
        this.className = className;
        this.features = features;
    }

    String getClassName(){
        return className;
    }

    void setClassName(String className){
        this.className = className;
    }

    String[] getFeatures(){
        return features;
    }

    public Integer getDistance(){
        return distance;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    @Override
    public int compareTo(Sample o){
        // TODO Auto-generated method stub
        return this.getDistance().compareTo(o.getDistance());
    }

}

