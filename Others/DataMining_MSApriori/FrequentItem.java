package Others.DataMining_MSApriori;

/**
 * Ƶ���
 *
 * @author Qstar
 */
class FrequentItem implements Comparable<FrequentItem> {
    // Ƶ����ļ���ID
    private String[] idArray;
    // Ƶ�����֧�ֶȼ���
    private int count;
    //Ƶ����ĳ��ȣ�1�����2��������3�
    private int length;

    public FrequentItem(String[] idArray, int count){
        this.idArray = idArray;
        this.count = count;
        length = idArray.length;
    }

    private String[] getIdArray(){
        return idArray;
    }

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public int getLength(){
        return length;
    }

    public void setLength(int length){
        this.length = length;
    }

    @Override
    public int compareTo(FrequentItem o){
        // TODO Auto-generated method stub
        Integer int1 = Integer.parseInt(this.getIdArray()[0]);
        Integer int2 = Integer.parseInt(o.getIdArray()[0]);

        return int1.compareTo(int2);
    }

}
