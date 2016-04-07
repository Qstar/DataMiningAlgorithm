package Classification.DataMining_KNN;

/**
 * 样本数据类
 *
 * @author lyq
 */
class Sample implements Comparable<Sample> {
    // 样本数据的分类名称
    private String className;
    // 样本数据的特征向量
    private String[] features;
    //测试样本之间的间距值，以此做排序
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

