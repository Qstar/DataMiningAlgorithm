package GraphMining.DataMining_GSpan;

/**
 * �ߣ�����Ԫ���ʾ
 *
 * @author lyq
 */
class Edge {
    static final int EDGE_SMALLER = 1;
    static final int EDGE_LARGER = 2;
    // ��Ԫ��Ĵ�С�ȽϽ��
    private static final int EDGE_EQUAL = 0;
    // �ߵ�һ�˵�id�ű�ʶ
    int ix;
    // �ߵ���һ�˵�id�ű�ʶ
    int iy;
    // �ߵ�һ�˵ĵ���
    int x;
    // �ߵı��
    int a;
    // �ߵ���һ�˵ĵ���
    int y;

    Edge(int ix, int iy, int x, int a, int y){
        this.ix = ix;
        this.iy = iy;
        this.x = x;
        this.a = a;
        this.y = y;
    }

    /**
     * ��ǰ����������ıߵĴ�С�ȽϹ�ϵ
     *
     * @param e ��ǰ��
     */
    int compareWith(Edge e){
        int result = EDGE_EQUAL;
        int[] array1 = new int[]{ix, iy, x, y, a};
        int[] array2 = new int[]{e.ix, e.iy, e.x, e.y, e.a};

        // ����ix, iy,x,y,a�Ĵ������αȽ�
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] < array2[i]) {
                result = EDGE_SMALLER;
                break;
            } else if (array1[i] > array2[i]) {
                result = EDGE_LARGER;
                break;
            }
        }
        return result;
    }
}
